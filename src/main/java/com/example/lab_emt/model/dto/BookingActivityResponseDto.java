package com.example.lab_emt.model.dto;

import com.example.lab_emt.model.activities.BookingActivity;

import java.time.LocalDateTime;
import java.util.List;

public record BookingActivityResponseDto(
        String accName,
        LocalDateTime bookTime,
        Boolean successful,
        Boolean full
) {
    public static BookingActivityResponseDto from(BookingActivity bookingActivity) {
        return new BookingActivityResponseDto(
                bookingActivity.getAccName(),
                bookingActivity.getBookTime(),
                bookingActivity.getSuccessful(),
                bookingActivity.getFullRoom()
        );
    }

    public static List<BookingActivityResponseDto> from(List<BookingActivity> accommodationViews) {
        return accommodationViews
                .stream()
                .map(BookingActivityResponseDto::from)
                .toList();
    }
}
