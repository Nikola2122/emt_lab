package com.example.lab_emt.service.application.impl;

import com.example.lab_emt.helpers.JwtHelper;
import com.example.lab_emt.model.domain.AuthLog;
import com.example.lab_emt.model.domain.User;
import com.example.lab_emt.model.dto.LoginUserRequestDto;
import com.example.lab_emt.model.dto.LoginUserResponseDto;
import com.example.lab_emt.model.dto.RegisterUserRequestDto;
import com.example.lab_emt.model.dto.RegisterUserResponseDto;
import com.example.lab_emt.repository.AuthLogRepository;
import com.example.lab_emt.service.application.UserApplicationService;
import com.example.lab_emt.service.domain.UserService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserApplicationServiceImpl implements UserApplicationService {
    private final UserService userService;
    private final JwtHelper jwtHelper;
    private final AuthLogRepository authLogRepository;

    public UserApplicationServiceImpl(UserService userService, JwtHelper jwtHelper, AuthLogRepository authLogRepository) {
        this.userService = userService;
        this.jwtHelper = jwtHelper;
        this.authLogRepository = authLogRepository;
    }

    @Override
    public Optional<RegisterUserResponseDto> register(RegisterUserRequestDto registerUserRequestDto) {
        User user = userService.register(registerUserRequestDto.toUser());
        RegisterUserResponseDto displayUserDto = RegisterUserResponseDto.from(user);
        return Optional.of(displayUserDto);
    }

    @Override
    public Optional<LoginUserResponseDto> login(LoginUserRequestDto loginUserRequestDto) {
        User user = userService.login(loginUserRequestDto.username(), loginUserRequestDto.password());

        String token = jwtHelper.generateToken(user);

        authLogRepository.save(new AuthLog(
                user.getUsername(), token, jwtHelper.extractIssuedAt(token), jwtHelper.extractExpiration(token)));

        return Optional.of(new LoginUserResponseDto(token));
    }

    @Override
    public Optional<RegisterUserResponseDto> findByUsername(String username) {
        return userService
            .findByUsername(username)
            .map(RegisterUserResponseDto::from);
    }
}

