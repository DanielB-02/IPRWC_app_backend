package com.example.iprwc_app_backend.controller.vo;

import com.example.iprwc_app_backend.entity.User;
import com.example.iprwc_app_backend.entity.enums.UserRole;

public class UserResult {
    public Long id;
    public String email;
    public String name;
    public UserRole role;

    public static UserResult create(User user) {
        UserResult result = new UserResult();
        result.id = user.getId();
        result.email = user.getEmail();
        result.name = user.getName();
        result.role = user.getRole();
        return result;
    }
}
