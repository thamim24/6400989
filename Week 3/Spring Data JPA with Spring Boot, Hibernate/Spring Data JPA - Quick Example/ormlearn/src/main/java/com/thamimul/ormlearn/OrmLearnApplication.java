package com.thamimul.ormlearn;

import java.util.List;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import com.thamimul.ormlearn.model.Country;
import com.thamimul.ormlearn.service.CountryService;

@SpringBootApplication
@EntityScan("com.thamimul.ormlearn.model")
public class OrmLearnApplication {

    private static CountryService countryService;

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
        countryService = context.getBean(CountryService.class);
        testGetAllCountries();
    }

    private static void testGetAllCountries() {
        List<Country> list = countryService.getAllCountries();
        System.out.println("🟢 List of Countries:");
        for (Country c : list) {
            System.out.println(c);
        }
    }
}
