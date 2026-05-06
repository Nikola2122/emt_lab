package com.example.lab_emt.service.domain;

import com.example.lab_emt.model.domain.Country;

import java.util.List;
import java.util.Optional;

public interface CountryService {
    Optional<Country> findById(Long id);

    List<Country> findAll();
}
