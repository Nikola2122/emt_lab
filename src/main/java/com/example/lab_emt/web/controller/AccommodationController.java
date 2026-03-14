package com.example.lab_emt.web.controller;

import com.example.lab_emt.model.dto.RequestAccommodationDto;
import com.example.lab_emt.model.dto.ResponseAccommodationDto;
import com.example.lab_emt.service.application.AccommodationApplicationService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/accommodations")
public class AccommodationController {
    private final AccommodationApplicationService accommodationAppService;

    public AccommodationController(AccommodationApplicationService accommodationAppService) {
        this.accommodationAppService = accommodationAppService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseAccommodationDto> findById(@PathVariable Long id) {
        return accommodationAppService
                .findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<ResponseAccommodationDto>> findAll() {
        return ResponseEntity.ok(accommodationAppService.findAll());
    }

    @PostMapping("/add")
    public ResponseEntity<ResponseAccommodationDto> create(@RequestBody @Valid RequestAccommodationDto requestAccommodationDto) {
        return ResponseEntity.ok(accommodationAppService.create(requestAccommodationDto));
    }

    @PutMapping("/{id}/edit")
    public ResponseEntity<ResponseAccommodationDto> update(
            @PathVariable Long id,
            @RequestBody RequestAccommodationDto requestAccommodationDto
    ) {
        return accommodationAppService
                .update(id, requestAccommodationDto)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}/book")
    public ResponseEntity<ResponseAccommodationDto> book(
            @PathVariable Long id
    ) {
        return accommodationAppService
                .book(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<ResponseAccommodationDto> deleteById(@PathVariable Long id) {
        return accommodationAppService
                .deleteById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
