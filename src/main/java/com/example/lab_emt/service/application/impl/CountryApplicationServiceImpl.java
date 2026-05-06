package com.example.lab_emt.service.application.impl;

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
}
