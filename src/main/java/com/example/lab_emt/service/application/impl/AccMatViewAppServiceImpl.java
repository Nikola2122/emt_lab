package com.example.lab_emt.service.application.impl;

import com.example.lab_emt.model.dto.AccMatViewResponse;
import com.example.lab_emt.model.dto.AccommodationViewResponseDto;
import com.example.lab_emt.service.application.AccMatViewAppService;
import com.example.lab_emt.service.domain.AccMatViewService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccMatViewAppServiceImpl implements AccMatViewAppService {
    private final AccMatViewService accMatViewService;

    public AccMatViewAppServiceImpl(AccMatViewService accMatViewService) {
        this.accMatViewService = accMatViewService;
    }
    @Override
    public List<AccMatViewResponse> findAll() {
        return AccMatViewResponse.from(accMatViewService.findAll());
    }
}
