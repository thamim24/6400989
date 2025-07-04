package com.thamimul.ormlearn.diffexample.jpa;

import com.thamimul.ormlearn.diffexample.entity.Country;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CountryJpaDemo implements CommandLineRunner {

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        System.out.println("=== JPA Example ===");
        Country country = em.find(Country.class, "IN");
        System.out.println("JPA Found: " + country);
    }
}
