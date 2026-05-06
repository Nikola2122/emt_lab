package com.example.lab_emt.service.application.impl;

import com.example.lab_emt.model.dto.ResponseAuthLogDto;
import com.example.lab_emt.repository.AuthLogRepository;
import com.example.lab_emt.service.application.AuthLogApplicationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthLogApplicationServiceImpl implements AuthLogApplicationService {
    private final AuthLogRepository authLogRepository;

    public AuthLogApplicationServiceImpl(AuthLogRepository authLogRepository) {
        this.authLogRepository = authLogRepository;
    }

    @Override
    public List<ResponseAuthLogDto> findAll() {
        return ResponseAuthLogDto.from(authLogRepository.findAll());
    }
}
