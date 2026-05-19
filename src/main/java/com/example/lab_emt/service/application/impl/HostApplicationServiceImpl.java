package com.example.lab_emt.service.application.impl;

import com.example.lab_emt.model.domain.Country;
import com.example.lab_emt.model.domain.Host;
import com.example.lab_emt.model.dto.RequestHostDto;
import com.example.lab_emt.model.dto.ResponseAccommodationDto;
import com.example.lab_emt.model.dto.ResponseCountryDto;
import com.example.lab_emt.model.dto.ResponseHostDto;
import com.example.lab_emt.model.exception.HostNotFoundException;
import com.example.lab_emt.service.application.HostApplicationService;
import com.example.lab_emt.service.domain.CountryService;
import com.example.lab_emt.service.domain.HostService;
import org.springframework.stereotype.Service;

import java.security.InvalidParameterException;
import java.util.List;
import java.util.Optional;

@Service
public class HostApplicationServiceImpl implements HostApplicationService {
    private final HostService hostService;
    private final CountryService countryService;
    public HostApplicationServiceImpl(final HostService hostService, CountryService countryService) {
        this.hostService = hostService;
        this.countryService = countryService;
    }
    @Override
    public Optional<ResponseHostDto> findById(Long id) {
        return hostService
                .findById(id)
                .map(ResponseHostDto::from);
    }

    @Override
    public List<ResponseHostDto> findAll() {
        return ResponseHostDto.from(hostService.findAll());
    }

    @Override
    public ResponseHostDto create(RequestHostDto requestHostDto) {
        Country country = countryService
                .findById(requestHostDto.countryId())
                .orElseThrow(() -> new InvalidParameterException(String.valueOf(requestHostDto.countryId())));
        return ResponseHostDto.from(hostService.create(requestHostDto.toHost(country)));
    }

    @Override
    public Optional<ResponseHostDto> update(Long id, RequestHostDto requestHostDto) {
        Country country = countryService
                .findById(requestHostDto.countryId())
                .orElseThrow(() -> new InvalidParameterException(String.valueOf(requestHostDto.countryId())));
        return hostService
                .update(id, requestHostDto.toHost(country))
                .map(ResponseHostDto::from);
    }

    @Override
    public Optional<ResponseHostDto> deleteById(Long id) {
        return hostService
                .deleteById(id)
                .map(ResponseHostDto::from);
    }
}
