package com.example.lab_emt.model.dto;

import com.example.lab_emt.model.domain.AuthLog;

import java.util.Date;
import java.util.List;

public record ResponseAuthLogDto(
        Long id,
        String username,
        String token,
        Date issuedAt,
        Date expiresAt

){
    public static ResponseAuthLogDto from(AuthLog log) {
        return new ResponseAuthLogDto(
                log.getId(),
                log.getUsername(),
                log.getToken(),
                log.getIssuedAt(),
                log.getExpiresAt()
        );
    }

    public static List<ResponseAuthLogDto> from(List<AuthLog> logs) {
        return logs
                .stream()
                .map(ResponseAuthLogDto::from)
                .toList();
    }
}
