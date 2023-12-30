package com.example.iprwc_app_backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;

@SpringBootApplication
@EnableMethodSecurity(securedEnabled = true)
public class IprwcAppBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(IprwcAppBackendApplication.class, args);
    }

}
