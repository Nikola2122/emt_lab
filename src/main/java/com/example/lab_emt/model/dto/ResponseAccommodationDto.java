package com.example.lab_emt.model.dto;

import com.example.lab_emt.model.domain.Accommodation;
import com.example.lab_emt.model.enums.Category;
import com.example.lab_emt.model.enums.State;
import jakarta.validation.constraints.Positive;

import java.util.List;

public record ResponseAccommodationDto(
        Long id,
        String name,
        Category category,
        Long hostId,
        State state,
        Integer numRooms,
        Boolean booked
) {
    public static ResponseAccommodationDto from(Accommodation accommodation) {
        return new ResponseAccommodationDto(
                accommodation.getId(),
                accommodation.getName(),
                accommodation.getCategory(),
                accommodation.getHost().getId(),
                accommodation.getState(),
                accommodation.getNumRooms(),
                accommodation.getBooked()
        );
    }

    public static List<ResponseAccommodationDto> from(List<Accommodation> accommodations) {
        return accommodations
                .stream()
                .map(ResponseAccommodationDto::from)
                .toList();
    }
}
