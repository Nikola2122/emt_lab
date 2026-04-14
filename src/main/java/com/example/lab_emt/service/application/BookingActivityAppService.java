package com.example.lab_emt.service.application;

import com.example.lab_emt.model.dto.BookingActivityResponseDto;
import org.springframework.data.domain.Page;

public interface BookingActivityAppService {
    Page<BookingActivityResponseDto> findAll(int page, int size, String sortBy);
}
