package com.example.lab_emt.service.application.impl;

import com.example.lab_emt.model.dto.AccommodationViewResponseDto;
import com.example.lab_emt.model.views.AccommodationView;
import com.example.lab_emt.service.application.AccommodationViewAppService;
import com.example.lab_emt.service.domain.AccommodationViewService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccommodationViewAppServiceImpl implements AccommodationViewAppService {
    private final AccommodationViewService accommodationViewService;

    public AccommodationViewAppServiceImpl(AccommodationViewService accommodationViewService) {
        this.accommodationViewService = accommodationViewService;
    }


    @Override
    public List<AccommodationViewResponseDto> findAll() {
        return AccommodationViewResponseDto.from(accommodationViewService.findAll());
    }
}
