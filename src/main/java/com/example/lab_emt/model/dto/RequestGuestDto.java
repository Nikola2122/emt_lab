package com.example.lab_emt.model.dto;

import com.example.lab_emt.model.domain.Guest;

public record RequestGuestDto(
        String name,
        String surname
) {
    public Guest toGuest(){
        return new Guest(name, surname);
    }
}
