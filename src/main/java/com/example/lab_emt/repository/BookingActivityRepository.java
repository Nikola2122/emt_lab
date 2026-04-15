package com.example.lab_emt.repository;

import com.example.lab_emt.model.activities.BookingActivity;
import com.example.lab_emt.model.dto.MostPopularAccProjection;
import com.example.lab_emt.model.dto.MostPopularHostProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingActivityRepository extends JpaRepository<BookingActivity, Long> {
    Page<BookingActivity> findAll(Pageable pageable);

    @Query(value = """
                SELECT a.name AS acc_name, COUNT(*) AS number_of_bookings
                FROM book_activities b
                JOIN accommodations a ON b.accommodation_id = a.id
                WHERE b.successful = true
                GROUP BY a.id, a.name
                ORDER BY COUNT(*) DESC
                LIMIT 1
            """, nativeQuery = true)
    MostPopularAccProjection mostPopularAcc();

    @Query(value = """
                SELECT h.name AS host_name, COUNT(*) AS number_of_bookings
                FROM book_activities b
                JOIN hosts h ON b.host_id = h.id
                WHERE b.successful = true
                GROUP BY h.id, h.name
                ORDER BY COUNT(*) DESC
                LIMIT 1
            """, nativeQuery = true)
    MostPopularHostProjection mostPopularHost();
}
