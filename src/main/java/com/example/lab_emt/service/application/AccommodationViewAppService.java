package com.example.lab_emt.service.application;

import com.example.lab_emt.model.dto.AccommodationViewResponseDto;
import com.example.lab_emt.model.views.AccommodationView;

import java.util.List;

public interface AccommodationViewAppService {
    List<AccommodationViewResponseDto> findAll();
}
