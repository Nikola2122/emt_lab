package com.example.lab_emt.service.application;


import com.example.lab_emt.model.dto.RequestAccommodationDto;
import com.example.lab_emt.model.dto.RequestCountryDto;
import com.example.lab_emt.model.dto.ResponseAccommodationDto;
import com.example.lab_emt.model.dto.ResponseCountryDto;

import java.util.List;
import java.util.Optional;

public interface CountryApplicationService {
    Optional<ResponseCountryDto> findById(Long id);

    List<ResponseCountryDto> findAll();

    ResponseCountryDto create(RequestCountryDto requestCountryDto);

    Optional<ResponseCountryDto> update(Long id, RequestCountryDto requestCountryDto);

    Optional<ResponseCountryDto> deleteById(Long id);
}
