package com.example.iprwc_app_backend.controller.vo;

import com.example.iprwc_app_backend.model.Role;
import com.example.iprwc_app_backend.model.User;

public class UserResult {
    public Long id;
    public String firstName;
    public String lastName;
    public String email;
    public Role role;

    public static UserResult create(User user) {
        if (user == null) {
            return null;
        }
        UserResult result = new UserResult();
        result.id = user.getId();
        result.email = user.getEmail();
        result.firstName = user.getFirstName();
        result.lastName = user.getLastName();
        result.role = user.getRole();
        return result;
    }
}
