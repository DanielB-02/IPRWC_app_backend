package com.example.iprwc_app_backend.controller;

import com.example.iprwc_app_backend.controller.vo.SignupRequest;
import com.example.iprwc_app_backend.controller.vo.UserResult;
import com.example.iprwc_app_backend.service.SignupService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/signup")
@RequiredArgsConstructor
public class SignupController {

    @Autowired
    private SignupService signupService;

    @RequestMapping(value = "", method = RequestMethod.POST)
    public UserResult signup(@RequestBody @Valid SignupRequest request) {
        return UserResult.create(signupService.signup(request));
    }

}
