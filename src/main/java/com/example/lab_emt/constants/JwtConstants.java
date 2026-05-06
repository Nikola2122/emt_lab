package com.example.lab_emt.constants;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JwtConstants {
    public static String SECRET_KEY;
    public static Long EXPIRATION_TIME;
    public static String HEADER;
    public static String TOKEN_PREFIX;

    @Value("${jwt.secret}")
    public void setSecretKey(String secretKey) {
        SECRET_KEY = secretKey;
    }

    @Value("${jwt.expiration}")
    public void setExpirationTime(Long expirationTime) {
        EXPIRATION_TIME = expirationTime;
    }

    @Value("${jwt.header}")
    public void setHeader(String header) {
        HEADER = header;
    }

    @Value("${jwt.token-prefix}")
    public void setTokenPrefix(String tokenPrefix) {
        TOKEN_PREFIX = tokenPrefix;
    }
}
