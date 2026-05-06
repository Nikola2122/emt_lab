package com.example.lab_emt.web.controller;

import com.example.lab_emt.model.dto.ResponseCountryDto;
import com.example.lab_emt.service.application.CountryApplicationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/countries")
public class CountryController {
    private final CountryApplicationService countryApplicationService;
    public CountryController(CountryApplicationService countryApplicationService) {
        this.countryApplicationService = countryApplicationService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseCountryDto> findById(@PathVariable Long id) {
        return countryApplicationService
                .findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping()
    public ResponseEntity<List<ResponseCountryDto>> findAll() {
        return ResponseEntity.ok(countryApplicationService.findAll());
    }
}
