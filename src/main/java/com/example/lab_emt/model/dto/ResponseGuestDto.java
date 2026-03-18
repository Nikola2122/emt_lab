package com.example.lab_emt.model.dto;

import com.example.lab_emt.model.domain.Guest;
import java.util.List;

public record ResponseGuestDto(
        Long id,
        String name,
        String surname,
        List<ResponseHostDto> hosts
) {
    public static ResponseGuestDto from(Guest guest) {
        return new ResponseGuestDto(
                guest.getId(),
                guest.getName(),
                guest.getSurname(),
                ResponseHostDto.from(guest.getHosts())
        );
    }

    public static List<ResponseGuestDto> from(List<Guest> accommodations) {
        return accommodations
                .stream()
                .map(ResponseGuestDto::from)
                .toList();
    }
}
