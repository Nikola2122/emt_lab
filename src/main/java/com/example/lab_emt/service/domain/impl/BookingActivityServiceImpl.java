package com.example.lab_emt.service.domain.impl;

import com.example.lab_emt.model.activities.BookingActivity;
import com.example.lab_emt.repository.BookingActivityRepository;
import com.example.lab_emt.service.domain.BookingActivityService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class BookingActivityServiceImpl implements BookingActivityService {
    private final BookingActivityRepository bookingActivityRepository;

    public BookingActivityServiceImpl(BookingActivityRepository bookingActivityRepository) {
        this.bookingActivityRepository = bookingActivityRepository;
    }


    @Transactional
    @Override
    public void create(BookingActivity bookActivity) {
        bookingActivityRepository.save(bookActivity);
    }

    @Override
    public Page<BookingActivity> findAll(int page, int size, String sortBy) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        return bookingActivityRepository.findAll(pageable);
    }
}
