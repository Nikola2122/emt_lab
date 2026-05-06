package com.example.lab_emt.web.controller;

import com.example.lab_emt.model.dto.ResponseHostDto;
import com.example.lab_emt.service.application.HostApplicationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/hosts")
public class HostController {
    private final HostApplicationService hostApplicationService;
    public HostController(HostApplicationService hostApplicationService) {
        this.hostApplicationService = hostApplicationService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseHostDto> findById(@PathVariable Long id) {
        return hostApplicationService
                .findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping()
    public ResponseEntity<List<ResponseHostDto>> findAll() {
        return ResponseEntity.ok(hostApplicationService.findAll());
    }
}
