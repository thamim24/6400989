package com.thamimul.ormlearn.diffexample;

import com.thamimul.ormlearn.diffexample.entity.Country;
import com.thamimul.ormlearn.diffexample.springdata.CountryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;


@SpringBootApplication(scanBasePackages = "com.thamimul.ormlearn")
@EntityScan(basePackages = "com.thamimul.ormlearn.diffexample.entity")
public class JpaHibernateSpringdataDiffApplication {

    public static void main(String[] args) {
        SpringApplication.run(JpaHibernateSpringdataDiffApplication.class, args);
    }
    
    @Bean
    CommandLineRunner insertData(CountryRepository repo) {
        return args -> {
            repo.save(new Country("IN", "India"));
        };
    }
}
