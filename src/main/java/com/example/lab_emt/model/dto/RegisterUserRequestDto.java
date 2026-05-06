package com.example.lab_emt.model.dto;


import com.example.lab_emt.model.domain.User;

public record RegisterUserRequestDto(
    String name,
    String surname,
    String email,
    String username,
    String password
) {
    public User toUser() {
        return new User(name, surname, email, username, password);
    }
}
