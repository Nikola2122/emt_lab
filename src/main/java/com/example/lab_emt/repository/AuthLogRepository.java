package com.example.lab_emt.repository;

import com.example.lab_emt.model.domain.AuthLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthLogRepository extends JpaRepository<AuthLog, Long> {
}
