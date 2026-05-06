package com.example.lab_emt.service.application;

import com.example.lab_emt.model.dto.ResponseHostDto;

import java.util.List;
import java.util.Optional;

public interface HostApplicationService {
    Optional<ResponseHostDto> findById(Long id);

    List<ResponseHostDto> findAll();
}
