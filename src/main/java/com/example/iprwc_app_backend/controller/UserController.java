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
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id){
        this.userService.delete(id);
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<UserResult> findAll(){
        return this.userService.findAll().stream()
                .map(UserResult::create)
                .toList();
    }

}
