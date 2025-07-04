package com.thamimul.ormlearn.diffexample.springdata;

import com.thamimul.ormlearn.diffexample.entity.Country;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CountrySpringDataDemo implements CommandLineRunner {

    private final CountryRepository repo;

    public CountrySpringDataDemo(CountryRepository repo) {
        this.repo = repo;
    }

    @Override
    public void run(String... args) {
        System.out.println("=== Spring Data JPA Example ===");
        Country country = repo.findById("IN").orElse(null);
        System.out.println("Spring Data Found: " + country);
    }
}
