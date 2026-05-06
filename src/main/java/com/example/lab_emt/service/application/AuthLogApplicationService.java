package com.example.lab_emt.service.application;

import com.example.lab_emt.model.dto.ResponseAuthLogDto;

import java.util.List;

public interface AuthLogApplicationService {
    List<ResponseAuthLogDto> findAll();
}
