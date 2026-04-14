package com.example.lab_emt.repository;

import com.example.lab_emt.model.activities.BookingActivity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingActivityRepository extends JpaRepository<BookingActivity, Long> {
    Page<BookingActivity> findAll(Pageable pageable);
}
