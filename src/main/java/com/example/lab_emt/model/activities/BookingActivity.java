package com.example.lab_emt.model.activities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "book_activities")
public class BookingActivity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    String accName;
    LocalDateTime bookTime;
    Boolean successful;
    Boolean fullRoom;

    public BookingActivity(String accName, LocalDateTime bookTime, Boolean successful, Boolean full) {
        this.accName = accName;
        this.bookTime = bookTime;
        this.successful = successful;
        this.fullRoom = full;
    }
}
