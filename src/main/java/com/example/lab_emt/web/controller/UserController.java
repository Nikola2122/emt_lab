package com.example.lab_emt.web.controller;

import com.example.lab_emt.model.domain.User;
import com.example.lab_emt.model.dto.*;
import com.example.lab_emt.service.application.AuthLogApplicationService;
import com.example.lab_emt.service.application.UserApplicationService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {
    private final UserApplicationService userApplicationService;
    private final AuthLogApplicationService authLogApplicationService;

    public UserController(UserApplicationService userApplicationService, AuthLogApplicationService authLogApplicationService) {
        this.userApplicationService = userApplicationService;
        this.authLogApplicationService = authLogApplicationService;
    }

    @GetMapping("/{username}")
    public ResponseEntity<RegisterUserResponseDto> findByUsername(@PathVariable String username) {
        return userApplicationService
            .findByUsername(username)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/me")
    public ResponseEntity<RegisterUserResponseDto> me(@AuthenticationPrincipal User user) {
        return userApplicationService
            .findByUsername(user.getUsername())
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.badRequest().build());
    }

    @PostMapping("/register")
    public ResponseEntity<RegisterUserResponseDto> register(@RequestBody RegisterUserRequestDto registerUserRequestDto) {
        return userApplicationService
            .register(registerUserRequestDto)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.badRequest().build());
    }

    @PostMapping("/login")
    public ResponseEntity<LoginUserResponseDto> login(@RequestBody LoginUserRequestDto loginUserRequestDto) {
        return userApplicationService
            .login(loginUserRequestDto)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.badRequest().build());
    }

    @GetMapping("auth-logs")
    public ResponseEntity<List<ResponseAuthLogDto>> findAllAuthLogs() {
        return ResponseEntity.ok(authLogApplicationService.findAll());
    }
}
