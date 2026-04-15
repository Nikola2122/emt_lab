package com.example.lab_emt.model.activities;

import com.example.lab_emt.model.domain.Accommodation;
import com.example.lab_emt.model.domain.Host;
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

    @ManyToOne
    Accommodation accommodation;

    @ManyToOne
    Host host;

    public BookingActivity(String accName, LocalDateTime bookTime, Boolean successful, Boolean full, Accommodation accommodation, Host host) {
        this.accName = accName;
        this.bookTime = bookTime;
        this.successful = successful;
        this.fullRoom = full;
        this.accommodation = accommodation;
        this.host = host;
    }
}
