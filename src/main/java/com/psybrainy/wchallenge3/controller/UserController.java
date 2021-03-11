package com.psybrainy.wchallenge3.controller;

import com.psybrainy.wchallenge3.dto.request.UserRequest;
import com.psybrainy.wchallenge3.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping
    public List<UserRequest> getAll(){
        return userService.getAll();
    }

    @GetMapping("/{id}")
    public UserRequest getById(@PathVariable("id") Long id){
        return userService.getById(id);
    }
}
