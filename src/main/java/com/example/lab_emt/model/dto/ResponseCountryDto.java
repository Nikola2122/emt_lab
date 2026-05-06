package com.example.lab_emt.model.dto;

import com.example.lab_emt.model.domain.Country;

import java.util.List;

public record ResponseCountryDto (
        Long id,
        String name,
        String continent
){
    public static ResponseCountryDto from(Country country) {
        return new ResponseCountryDto(
                country.getId(),
                country.getName(),
                country.getContinent()
        );
    }

    public static List<ResponseCountryDto> from(List<Country> countries) {
        return countries
                .stream()
                .map(ResponseCountryDto::from)
                .toList();
    }
}
