package com.example.lab_emt.service.application.impl;

import com.example.lab_emt.model.dto.BookingActivityResponseDto;
import com.example.lab_emt.service.application.BookingActivityAppService;
import com.example.lab_emt.service.domain.BookingActivityService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class BookingActivityActivityAppServiceImpl implements BookingActivityAppService {

    private final BookingActivityService bookingActivityService;

    public BookingActivityActivityAppServiceImpl(BookingActivityService bookingActivityService) {
        this.bookingActivityService = bookingActivityService;
    }

    @Override
    public Page<BookingActivityResponseDto> findAll(int page, int size, String sortBy) {
        return bookingActivityService.findAll(page, size, sortBy)
                .map(BookingActivityResponseDto::from);
    }
}
