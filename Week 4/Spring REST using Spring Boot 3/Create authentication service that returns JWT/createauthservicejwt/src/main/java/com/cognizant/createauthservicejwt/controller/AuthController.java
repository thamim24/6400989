package com.cognizant.createauthservicejwt.controller;

import com.cognizant.createauthservicejwt.model.JwtResponse;
import com.cognizant.createauthservicejwt.util.JwtUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

@RestController
public class AuthController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthController.class);
    private final JwtUtil jwtUtil;

    public AuthController(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @GetMapping("/authenticate")
    public JwtResponse authenticate(@RequestHeader(HttpHeaders.AUTHORIZATION) String authHeader) {
        LOGGER.info("START: authenticate()");

        // Parse Basic Auth header: "Basic base64(user:password)"
        String base64Credentials = authHeader.substring("Basic ".length()).trim();
        byte[] credDecoded = Base64.getDecoder().decode(base64Credentials);
        String credentials = new String(credDecoded, StandardCharsets.UTF_8);

        String[] values = credentials.split(":", 2);
        String username = values[0];
        String password = values[1];

        LOGGER.info("Credentials received - user: {}", username);

        // (Temporary check — in real apps, validate against DB)
        if ("user".equalsIgnoreCase(username) && "pwd".equals(password)) {
            String token = jwtUtil.generateToken(username);
            LOGGER.info("END: authenticate()");
            return new JwtResponse(token);
        } else {
            throw new RuntimeException("Invalid credentials");
        }
    }
}
