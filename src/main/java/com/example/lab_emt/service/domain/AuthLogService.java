package com.example.lab_emt.service.domain;

import com.example.lab_emt.model.domain.AuthLog;

import java.util.List;
import java.util.Optional;

public interface AuthLogService {
    Optional<AuthLog> findById(Long id);

    List<AuthLog> findAll();

}

