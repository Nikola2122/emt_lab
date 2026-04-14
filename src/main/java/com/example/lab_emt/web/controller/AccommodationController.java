package com.example.lab_emt.web.controller;

import com.example.lab_emt.model.dto.*;
import com.example.lab_emt.model.projection.DetailedAccProjection;
import com.example.lab_emt.service.application.AccMatViewAppService;
import com.example.lab_emt.service.application.AccommodationApplicationService;
import com.example.lab_emt.service.application.AccommodationViewAppService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/accommodations")
public class AccommodationController {
    private final AccommodationApplicationService accommodationAppService;
    private final AccommodationViewAppService accommodationViewAppService;
    private final AccMatViewAppService accMatViewAppService;

    public AccommodationController(AccommodationApplicationService accommodationAppService, AccommodationViewAppService accommodationViewAppService, AccMatViewAppService accMatViewAppService) {
        this.accommodationAppService = accommodationAppService;
        this.accommodationViewAppService = accommodationViewAppService;
        this.accMatViewAppService = accMatViewAppService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseAccommodationDto> findById(@PathVariable Long id) {
        return accommodationAppService
                .findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/entity-graph/{id}")
    public ResponseEntity<ResponseAccommodationDto> findByIdEntityGraph(@PathVariable Long id) {
        return accommodationAppService
                .findByIdEntityGraph(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }


    @GetMapping
    public ResponseEntity<List<ResponseAccommodationDto>> findAll() {
        return ResponseEntity.ok(accommodationAppService.findAll());
    }

    @GetMapping("/view")
    public ResponseEntity<List<AccommodationViewResponseDto>> getView() {
        return ResponseEntity.ok(accommodationViewAppService.findAll());
    }

    @GetMapping("/mat-view")
    public ResponseEntity<List<AccMatViewResponse>> getMatView() {
        return ResponseEntity.ok(accMatViewAppService.findAll());
    }

    @PostMapping("/add")
    public ResponseEntity<ResponseAccommodationDto> create(@RequestBody @Valid RequestAccommodationDto requestAccommodationDto) {
        return ResponseEntity.ok(accommodationAppService.create(requestAccommodationDto));
    }

    @PutMapping("/{id}/edit")
    public ResponseEntity<ResponseAccommodationDto> update(
            @PathVariable Long id,
            @Valid @RequestBody RequestAccommodationDto requestAccommodationDto
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

    @PostMapping("/paginated")
    public ResponseEntity<Page<ResponseAccommodationDto>> findAll(
            @RequestBody PagedAccRequestDto pagedAccRequestDto
    ) {
        return ResponseEntity.ok(accommodationAppService.findAllPaged(pagedAccRequestDto));
    }

    @GetMapping("/projection")
    public ResponseEntity<List<DetailedAccProjection>> findProjection() {
        return ResponseEntity.ok(accommodationAppService.findDetailedProjection());
    }
}
