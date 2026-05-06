package com.example.lab_emt.model.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "auth_logs")
public class AuthLog extends BaseEntity{
    String username;
    String token;
    Date issuedAt;
    Date expiresAt;

    public AuthLog(String username, String token, Date issuedAt, Date expiresAt) {
        this.username = username;
        this.token = token;
        this.issuedAt = issuedAt;
        this.expiresAt = expiresAt;
    }
}
