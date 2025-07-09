package com.cognizant.createauthservicejwt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CreateauthservicejwtApplication {
    public static void main(String[] args) {
        SpringApplication.run(CreateauthservicejwtApplication.class, args);
        System.out.println(">>>>> Auth Service with JWT Started on Port 8090 <<<<<");
    }
}
