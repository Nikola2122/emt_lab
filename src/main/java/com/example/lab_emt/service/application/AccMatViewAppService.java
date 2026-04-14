package com.example.lab_emt.service.application;

import com.example.lab_emt.model.dto.AccMatViewResponse;

import java.util.List;

public interface AccMatViewAppService {
    List<AccMatViewResponse> findAll();

}
