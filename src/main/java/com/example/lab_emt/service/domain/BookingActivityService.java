package com.example.lab_emt.service.domain;

import com.example.lab_emt.model.activities.BookingActivity;
import org.springframework.data.domain.Page;

public interface BookingActivityService {
    void create(BookingActivity bookActivity);

    Page<BookingActivity> findAll(int page, int size, String sortBy);
}
