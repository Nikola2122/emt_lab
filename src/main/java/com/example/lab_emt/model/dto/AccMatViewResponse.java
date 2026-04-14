package com.example.lab_emt.model.dto;

import com.example.lab_emt.model.enums.Category;
import com.example.lab_emt.model.views.AccMatView;
import com.example.lab_emt.model.views.AccommodationView;

import java.math.BigDecimal;
import java.util.List;

public record AccMatViewResponse(
        Category category,
        Long totalAccommodations,
        Integer totalRooms,
        BigDecimal avgRooms
        ) {
    public static AccMatViewResponse from(AccMatView accMatView) {
        return new AccMatViewResponse(
                accMatView.getCategory(),
                accMatView.getTotalAccommodations(),
                accMatView.getTotalRooms(),
                accMatView.getAvgRooms()
        );
    }

    public static List<AccMatViewResponse> from(List<AccMatView> accommodationViews) {
        return accommodationViews
                .stream()
                .map(AccMatViewResponse::from)
                .toList();
    }
}
