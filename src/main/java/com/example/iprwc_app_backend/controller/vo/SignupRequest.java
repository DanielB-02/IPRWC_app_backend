package com.example.iprwc_app_backend.controller.vo;

import com.example.iprwc_app_backend.entity.enums.UserRole;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SignupRequest {
    private String email;
    @Size(min = 8)
    private String password;
    private String name;
    private boolean adminRole;
}
