package com.example.lab_emt.model.dto;

import com.example.lab_emt.model.enums.Role;
import com.example.lab_emt.model.domain.User;

public record RegisterUserResponseDto(
    String username,
    String name,
    String surname,
    String email,
    Role role
) {
    public static RegisterUserResponseDto from(User user) {
        return new RegisterUserResponseDto(
            user.getUsername(),
            user.getName(),
            user.getSurname(),
            user.getEmail(),
            user.getRole()
        );
    }
}


