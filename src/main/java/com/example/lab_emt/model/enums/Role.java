package com.example.lab_emt.model.enums;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    ROLE_USER,
    ROLE_ADMINISTRATOR;

    @Override
    public String getAuthority() {
        return name();
    }
}