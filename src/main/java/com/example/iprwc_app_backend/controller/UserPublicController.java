package com.example.iprwc_app_backend.controller;

import com.example.iprwc_app_backend.controller.vo.UserResult;
import com.example.iprwc_app_backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/public/user")
public class UserPublicController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/my", method = RequestMethod.GET)
    public UserResult myCredentials(){
        try {
            return UserResult.create(this.userService.myCredentials());
        } catch (Exception idontcare) {
            return null;
        }
    }

}
