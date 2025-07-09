package com.cognizant.LoadCountryfromSpring;

import com.cognizant.LoadCountryfromSpring.model.Country;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class LoadCountryfromSpringApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoadCountryfromSpringApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(LoadCountryfromSpringApplication.class, args);
        System.out.println(">>>>> LoadCountryfromSpringApplication Started Successfully <<<<<");

        displayCountryList();
    }

    public static void displayCountryList() {
        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
        List<Country> countryList = context.getBean("countryList", List.class);

        LOGGER.debug("List of Countries:");
        for (Country c : countryList) {
            LOGGER.debug("{}", c);
        }
    }

}
