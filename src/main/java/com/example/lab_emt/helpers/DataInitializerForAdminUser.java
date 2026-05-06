package com.example.lab_emt.helpers;

import com.example.lab_emt.model.domain.User;
import com.example.lab_emt.model.enums.Role;
import com.example.lab_emt.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataInitializerForAdminUser {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public DataInitializerForAdminUser(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostConstruct
    public void init(){
        if(userRepository.findByUsername("admin@admin.cm").isEmpty()){
            User admin = new User(
                    "Nikola",
                    "Koka",
                    "admin@admin.cm",
                    "admin",
                    passwordEncoder.encode("admin")
            );
            admin.setRole(Role.ROLE_ADMINISTRATOR);
            userRepository.save(admin);
        }
    }
}
