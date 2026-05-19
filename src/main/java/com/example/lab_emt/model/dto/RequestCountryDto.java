package com.example.lab_emt.model.dto;

import com.example.lab_emt.model.domain.Country;
import jakarta.validation.constraints.NotBlank;


public record RequestCountryDto(
        @NotBlank(message = "Please enter a real name")
        String name,
        String continent
) {
    public Country toCountry() {
        return new Country(name, continent);
    }
}
