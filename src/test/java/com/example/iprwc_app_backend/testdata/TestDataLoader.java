package com.example.iprwc_app_backend.testdata;

import com.example.iprwc_app_backend.model.Role;
import com.example.iprwc_app_backend.model.User;
import com.example.iprwc_app_backend.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Profile("testdata")
public class TestDataLoader {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @PostConstruct
    private void saveTestData() {
        createUser("Sebastiaan", "Landers", "admin@spine.com", "12345", Role.ADMIN);
        createUser("Shivane", "Frauenfelder", "ficter@spine.com", "12345", Role.FICTER);
        createUser("Floris", "Admiraal", "readonly@spine.com", "12345", Role.READONLY);
    }



    private void createUser(String firstName, String lastName, String email, String password, Role role) {
        var user = User.builder()
                .firstName(firstName)
                .lastName(lastName)
                .email(email)
                .password(passwordEncoder.encode(password))
                .role(role).build();
            userRepository.save(user);
    }
}
