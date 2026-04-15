package com.example.lab_emt.service.application.impl;

import com.example.lab_emt.model.dto.MostPopularAccProjection;
import com.example.lab_emt.model.dto.MostPopularHostProjection;
import com.example.lab_emt.service.domain.BookingActivityService;
import com.example.lab_emt.service.application.MostPopularAppService;
import org.springframework.stereotype.Service;

@Service
public class MostPopularAppServiceImpl implements MostPopularAppService {
    private final BookingActivityService  bookingActivityService;

    public MostPopularAppServiceImpl(BookingActivityService bookingActivityService) {
        this.bookingActivityService = bookingActivityService;
    }

    @Override
    public MostPopularAccProjection getMostPopularAcc() {
        MostPopularAccProjection a = bookingActivityService.mostPopularAcc();
        return a;
    }

    @Override
    public MostPopularHostProjection getMostPopularHost() {
        return bookingActivityService.mostPopularHost();
    }
}
