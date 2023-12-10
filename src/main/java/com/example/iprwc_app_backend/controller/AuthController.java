package com.example.iprwc_app_backend.controller;

import com.example.iprwc_app_backend.controller.vo.JwtAuthenticationResponse;
import com.example.iprwc_app_backend.controller.vo.AuthenticationRequest;
import com.example.iprwc_app_backend.security.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authenticationService;

    @PostMapping("/signin")
    public ResponseEntity<JwtAuthenticationResponse> signin(@RequestBody AuthenticationRequest request) {
        return ResponseEntity.ok(authenticationService.signin(request));
    }
}
