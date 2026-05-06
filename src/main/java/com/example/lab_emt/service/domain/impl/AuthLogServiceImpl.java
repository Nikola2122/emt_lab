package com.example.lab_emt.service.domain.impl;

import com.example.lab_emt.model.domain.AuthLog;
import com.example.lab_emt.repository.AuthLogRepository;
import com.example.lab_emt.service.domain.AuthLogService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthLogServiceImpl implements AuthLogService {
    private final AuthLogRepository authLogRepository;

    public AuthLogServiceImpl(AuthLogRepository authLogRepository) {
        this.authLogRepository = authLogRepository;
    }

    @Override
    public Optional<AuthLog> findById(Long id) {
        return authLogRepository.findById(id);
    }

    @Override
    public List<AuthLog> findAll() {
        return authLogRepository.findAll();
    }
}
