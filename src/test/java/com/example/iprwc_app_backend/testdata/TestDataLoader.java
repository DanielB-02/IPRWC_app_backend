package com.example.iprwc_app_backend.testdata;

import com.example.iprwc_app_backend.entity.User;
import com.example.iprwc_app_backend.entity.enums.UserRole;
import com.example.iprwc_app_backend.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import static com.example.iprwc_app_backend.entity.enums.UserRole.ADMIN;
import static com.example.iprwc_app_backend.entity.enums.UserRole.CUSTOMER;

@Component
@RequiredArgsConstructor
@Profile("testdata")
public class TestDataLoader {


    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @PostConstruct
    private void saveTestData() {
        createUser("admin@shop.com", "12345", "Daniel", ADMIN);
        createUser("readonly@shop.com", "12345", "Floris", CUSTOMER);
    }

    private void createUser(String email, String password, String name,  UserRole role) {
        User user = User.builder()
                .email(email)
                .password(passwordEncoder.encode(password))
                .name(name)
                .role(role).build();
            userRepository.save(user);
    }
}