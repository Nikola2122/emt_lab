package com.example.lab_emt.service.domain.impl;

import com.example.lab_emt.model.views.AccMatView;
import com.example.lab_emt.repository.AccMatViewRepository;
import com.example.lab_emt.service.domain.AccMatViewService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccMatViewServiceImpl implements AccMatViewService {
    private final AccMatViewRepository accMatViewRepository;

    public AccMatViewServiceImpl(AccMatViewRepository accMatViewRepository) {
        this.accMatViewRepository = accMatViewRepository;
    }

    @Override
    public List<AccMatView> findAll() {
        return accMatViewRepository.findAll();
    }
}
