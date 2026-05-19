package com.example.lab_emt.model.dto;

import com.example.lab_emt.model.domain.Country;
import com.example.lab_emt.model.domain.Host;
import jakarta.validation.constraints.NotBlank;

public record RequestHostDto(
        @NotBlank(message = "Please enter a real name")
        String name,
        String surname,
        Long countryId
) {
    public Host toHost(Country country) {
        return new Host(name, surname, country);
    }
}
