package com.example.lab_emt.web.controller;

import com.example.lab_emt.model.dto.RequestAccommodationDto;
import com.example.lab_emt.model.dto.RequestGuestDto;
import com.example.lab_emt.model.dto.ResponseAccommodationDto;
import com.example.lab_emt.model.dto.ResponseGuestDto;
import com.example.lab_emt.service.application.GuestApplicationService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/guests")
public class GuestController {

    private final GuestApplicationService guestApplicationService;

    public GuestController(GuestApplicationService guestApplicationService) {
        this.guestApplicationService = guestApplicationService;
    }

    @GetMapping
    public ResponseEntity<List<ResponseGuestDto>> findAll() {
        return ResponseEntity.ok(guestApplicationService.findAll());
    }

    @PostMapping("/add")
    public ResponseEntity<ResponseGuestDto> create(@RequestBody RequestGuestDto requestGuestDto) {
        return ResponseEntity.ok(guestApplicationService.create(requestGuestDto));
    }

    @PutMapping("/addGTH/{guest_id}/{host_id}")
    public ResponseEntity<ResponseGuestDto> addGuestToHost(
            @PathVariable Long guest_id,
            @PathVariable Long host_id
    ) {
        return guestApplicationService
                .addGuestToHost(guest_id, host_id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseGuestDto> deleteById(@PathVariable Long id) {
        return guestApplicationService
                .deleteById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
