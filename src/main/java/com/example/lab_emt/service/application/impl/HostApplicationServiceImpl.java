package com.example.lab_emt.service.application.impl;

import com.example.lab_emt.model.dto.ResponseHostDto;
import com.example.lab_emt.service.application.HostApplicationService;
import com.example.lab_emt.service.domain.HostService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HostApplicationServiceImpl implements HostApplicationService {
    private final HostService hostService;
    public HostApplicationServiceImpl(final HostService hostService) {
        this.hostService = hostService;
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
}
