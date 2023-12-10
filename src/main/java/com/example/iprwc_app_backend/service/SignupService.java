package com.example.iprwc_app_backend.service;

import com.example.iprwc_app_backend.controller.vo.AuthenticationRequest;
import com.example.iprwc_app_backend.controller.vo.SignupRequest;
import com.example.iprwc_app_backend.entity.User;
import com.example.iprwc_app_backend.entity.enums.UserRole;
import com.example.iprwc_app_backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SignupService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public User signup(SignupRequest request) {
        User user = User.builder()
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .name(request.getName())
                .role(request.isAdminRole() ? UserRole.ADMIN : UserRole.CUSTOMER)
                .build();
        return userRepository.save(user);
    }
}
