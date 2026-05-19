package com.example.lab_emt.service.application;

import com.example.lab_emt.model.dto.RequestCountryDto;
import com.example.lab_emt.model.dto.RequestHostDto;
import com.example.lab_emt.model.dto.ResponseCountryDto;
import com.example.lab_emt.model.dto.ResponseHostDto;

import java.util.List;
import java.util.Optional;

public interface HostApplicationService {
    Optional<ResponseHostDto> findById(Long id);

    List<ResponseHostDto> findAll();

    ResponseHostDto create(RequestHostDto requestHostDto);

    Optional<ResponseHostDto> update(Long id, RequestHostDto requestHostDto);

    Optional<ResponseHostDto> deleteById(Long id);
}
