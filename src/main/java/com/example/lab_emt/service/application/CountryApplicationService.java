package com.example.lab_emt.service.application;


import com.example.lab_emt.model.dto.ResponseCountryDto;

import java.util.List;
import java.util.Optional;

public interface CountryApplicationService {
    Optional<ResponseCountryDto> findById(Long id);

    List<ResponseCountryDto> findAll();
}
