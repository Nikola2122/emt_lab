package com.example.lab_emt.model.dto;

import com.example.lab_emt.model.domain.Accommodation;
import com.example.lab_emt.model.domain.Host;
import com.example.lab_emt.model.enums.Category;
import com.example.lab_emt.model.enums.State;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public record RequestAccommodationDto(
        @NotBlank(message = "Please enter a real name")
        String name,
        Category category,
        Long hostId,
        State state,
        @Positive
        Integer numRooms,
        Boolean booked
) {
    public Accommodation toAccommodation(Host host) {
        return new Accommodation(name, category, host, state, numRooms, booked);
    }
}
