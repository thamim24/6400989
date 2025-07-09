package com.cognizant.restgetcountrybasedoncountrycode.controller;

import com.cognizant.restgetcountrybasedoncountrycode.model.Country;
import com.cognizant.restgetcountrybasedoncountrycode.service.CountryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CountryController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CountryController.class);

    @Autowired
    private CountryService countryService;

    @GetMapping("/country/{code}")
    public Country getCountry(@PathVariable String code) {
        LOGGER.info("START: getCountry({})", code);
        Country country = countryService.getCountry(code);
        LOGGER.info("END: getCountry() - Found: {}", country);
        return country;
    }
}
