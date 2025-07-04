package com.thamimul.ormlearn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.thamimul.ormlearn.model.Country;

public interface CountryRepository extends JpaRepository<Country, String> {
}
