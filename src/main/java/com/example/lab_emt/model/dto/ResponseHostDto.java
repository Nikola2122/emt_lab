package com.example.lab_emt.model.dto;

import com.example.lab_emt.model.domain.Country;
import com.example.lab_emt.model.domain.Guest;
import com.example.lab_emt.model.domain.Host;

import java.util.List;

public record ResponseHostDto(
        Long id,
        String name,
        String surname,
        String countryName
) {
    public static ResponseHostDto from(Host host) {
        return new ResponseHostDto(
                host.getId(),
                host.getName(),
                host.getSurname(),
                host.getCountry().getName()
        );
    }

    public static List<ResponseHostDto> from(List<Host> hosts) {
        return hosts
                .stream()
                .map(ResponseHostDto::from)
                .toList();
    }
}
