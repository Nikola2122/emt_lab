package com.example.lab_emt.service.application;


import com.example.lab_emt.model.dto.LoginUserRequestDto;
import com.example.lab_emt.model.dto.LoginUserResponseDto;
import com.example.lab_emt.model.dto.RegisterUserRequestDto;
import com.example.lab_emt.model.dto.RegisterUserResponseDto;

import java.util.Optional;

public interface UserApplicationService {
    Optional<RegisterUserResponseDto> register(RegisterUserRequestDto registerUserRequestDto);

    Optional<LoginUserResponseDto> login(LoginUserRequestDto loginUserRequestDto);

    Optional<RegisterUserResponseDto> findByUsername(String username);
}
