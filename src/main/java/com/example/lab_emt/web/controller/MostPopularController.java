package com.example.lab_emt.web.controller;

import com.example.lab_emt.model.dto.MostPopularAccProjection;
import com.example.lab_emt.model.dto.MostPopularHostProjection;
import com.example.lab_emt.model.dto.ResponseGuestDto;
import com.example.lab_emt.service.application.MostPopularAppService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/most-popular")
public class MostPopularController {
    private final MostPopularAppService mostPopularAppService;

    public MostPopularController(MostPopularAppService mostPopularAppService) {
        this.mostPopularAppService = mostPopularAppService;
    }

    @GetMapping("most-p-acc")
    public ResponseEntity<MostPopularAccProjection> findMostPopularAcc() {
        return ResponseEntity.ok(mostPopularAppService.getMostPopularAcc());
    }

    @GetMapping("most-p-host")
    public ResponseEntity<MostPopularHostProjection> findMostPopularHost() {
        return ResponseEntity.ok(mostPopularAppService.getMostPopularHost());
    }
}
