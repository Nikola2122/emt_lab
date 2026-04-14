package com.example.lab_emt.web.controller;

import com.example.lab_emt.model.dto.BookingActivityResponseDto;
import com.example.lab_emt.service.application.BookingActivityAppService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/booking")
public class BookingController {
    private final BookingActivityAppService  bookingActivityAppService;
    public BookingController(BookingActivityAppService bookingActivityAppService) {
        this.bookingActivityAppService = bookingActivityAppService;
    }

    @GetMapping("/paginated")
    public ResponseEntity<Page<BookingActivityResponseDto>> findAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "bookTime") String sortBy
    ) {
        return ResponseEntity.ok(bookingActivityAppService.findAll(page, size, sortBy));
    }
}
