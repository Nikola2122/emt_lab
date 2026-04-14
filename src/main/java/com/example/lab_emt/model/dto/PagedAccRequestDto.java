package com.example.lab_emt.model.dto;

import com.example.lab_emt.model.enums.Category;

public record PagedAccRequestDto(
        Category category,
        Long hostId,
        Long countryId,
        Integer numRooms,
        Boolean booked,
        Integer pageNum,
        Integer pageSize
) {
}
