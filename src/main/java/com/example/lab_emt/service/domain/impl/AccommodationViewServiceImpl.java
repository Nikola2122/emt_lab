package com.example.lab_emt.service.domain.impl;

import com.example.lab_emt.model.views.AccommodationView;
import com.example.lab_emt.repository.AccommodationViewRepository;
import com.example.lab_emt.service.domain.AccommodationViewService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccommodationViewServiceImpl implements AccommodationViewService {
    private final AccommodationViewRepository accommodationViewRepository;

    public AccommodationViewServiceImpl(AccommodationViewRepository accommodationViewRepository) {
        this.accommodationViewRepository = accommodationViewRepository;
    }

    @Override
    public List<AccommodationView> findAll() {
        return accommodationViewRepository.findAll();
    }
}
