package com.example.lab_emt.events;

import java.time.LocalDateTime;

public record BookEvent(String accName, LocalDateTime bookTime, Boolean successful, Boolean full) {
}
