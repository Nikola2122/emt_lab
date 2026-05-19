package com.example.lab_emt.web.controller;

import com.example.lab_emt.model.dto.RequestCountryDto;
import com.example.lab_emt.model.dto.RequestHostDto;
import com.example.lab_emt.model.dto.ResponseCountryDto;
import com.example.lab_emt.model.dto.ResponseHostDto;
import com.example.lab_emt.service.application.HostApplicationService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/add")
    public ResponseEntity<ResponseHostDto> create(@RequestBody @Valid RequestHostDto requestHostDto) {
        return ResponseEntity.ok(hostApplicationService.create(requestHostDto));
    }

    @PutMapping("/{id}/edit")
    public ResponseEntity<ResponseHostDto> update(
            @PathVariable Long id,
            @Valid @RequestBody RequestHostDto requestHostDto
    ) {
        return hostApplicationService
                .update(id, requestHostDto)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<ResponseHostDto> deleteById(@PathVariable Long id) {
        return hostApplicationService
                .deleteById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
