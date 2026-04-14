package com.example.lab_emt.model.dto;

import com.example.lab_emt.model.enums.Category;
import com.example.lab_emt.model.views.AccommodationView;

import java.util.List;

public record AccommodationViewResponseDto (
        String name,
        Category category,
        Integer numRooms,
        String hostNameAndSurname,
        String countryName
){
    public static AccommodationViewResponseDto from(AccommodationView accommodationView) {
        return new AccommodationViewResponseDto(
                accommodationView.getName(),
                accommodationView.getCategory(),
                accommodationView.getNumRooms(),
                accommodationView.getHostNameAndSurname(),
                accommodationView.getCountryName()
        );
    }

    public static List<AccommodationViewResponseDto> from(List<AccommodationView> accommodationViews) {
        return accommodationViews
                .stream()
                .map(AccommodationViewResponseDto::from)
                .toList();
    }
}
