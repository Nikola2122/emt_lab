package com.example.lab_emt.web.dto;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public record ApiError(
    Integer status,
    String message,
    LocalDateTime timestamp
) {
    public static ApiError of(HttpStatus status, String message) {
        return new ApiError(status.value(), message, LocalDateTime.now());
    }
}
