package com.example.lab_emt.service.domain;

import com.example.lab_emt.model.dto.AccMatViewResponse;
import com.example.lab_emt.model.views.AccMatView;

import java.util.List;

public interface AccMatViewService {
    List<AccMatView> findAll();
}
