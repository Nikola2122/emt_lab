package com.example.lab_emt.service.application.impl;

import com.example.lab_emt.model.dto.RequestCountryDto;
import com.example.lab_emt.model.dto.ResponseAccommodationDto;
import com.example.lab_emt.model.dto.ResponseCountryDto;
import com.example.lab_emt.service.application.CountryApplicationService;
import com.example.lab_emt.service.domain.CountryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryApplicationServiceImpl implements CountryApplicationService {
    private final CountryService countryService;
    public CountryApplicationServiceImpl(CountryService countryService) {
        this.countryService = countryService;
    }

    @Override
    public Optional<ResponseCountryDto> findById(Long id) {
        return countryService
                .findById(id)
                .map(ResponseCountryDto::from);
    }

    @Override
    public List<ResponseCountryDto> findAll() {
        return ResponseCountryDto.from(countryService.findAll());
    }

    @Override
    public ResponseCountryDto create(RequestCountryDto requestCountryDto) {
        return ResponseCountryDto.from(countryService.create(requestCountryDto.toCountry()));
    }

    @Override
    public Optional<ResponseCountryDto> update(Long id, RequestCountryDto requestCountryDto) {
        return countryService
                .update(id, requestCountryDto.toCountry())
                .map(ResponseCountryDto::from);
    }

    @Override
    public Optional<ResponseCountryDto> deleteById(Long id) {
        return countryService
                .deleteById(id)
                .map(ResponseCountryDto::from);
    }
}
