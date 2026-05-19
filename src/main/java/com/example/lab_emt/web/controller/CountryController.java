package com.example.lab_emt.web.controller;

import com.example.lab_emt.model.dto.RequestAccommodationDto;
import com.example.lab_emt.model.dto.RequestCountryDto;
import com.example.lab_emt.model.dto.ResponseAccommodationDto;
import com.example.lab_emt.model.dto.ResponseCountryDto;
import com.example.lab_emt.service.application.CountryApplicationService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/add")
    public ResponseEntity<ResponseCountryDto> create(@RequestBody @Valid RequestCountryDto requestCountryDto) {
        return ResponseEntity.ok(countryApplicationService.create(requestCountryDto));
    }

    @PutMapping("/{id}/edit")
    public ResponseEntity<ResponseCountryDto> update(
            @PathVariable Long id,
            @Valid @RequestBody RequestCountryDto requestCountryDto
    ) {
        return countryApplicationService
                .update(id, requestCountryDto)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<ResponseCountryDto> deleteById(@PathVariable Long id) {
        return countryApplicationService
                .deleteById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
