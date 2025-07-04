package com.thamimul.ormlearn.diffexample.springdata;

import com.thamimul.ormlearn.diffexample.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, String> {
}
