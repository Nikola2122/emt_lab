package com.example.lab_emt.service.domain;

import com.example.lab_emt.model.domain.Accommodation;
import com.example.lab_emt.model.domain.Country;

import java.util.List;
import java.util.Optional;

public interface CountryService {
    Optional<Country> findById(Long id);

    List<Country> findAll();

    Country create(Country country);

    Optional<Country> update(Long id, Country country);

    Optional<Country> deleteById(Long id);

}
