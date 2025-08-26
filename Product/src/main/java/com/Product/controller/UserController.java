package com.Product.controller;

import com.Product.entity.User;
import com.Product.repository.UserRepository;
import com.Product.service.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private MyUserDetailsService myUserDetailsService;

    // Register new user
    @PostMapping("/register")
    public User registerUser(@RequestBody User user){
        return myUserDetailsService.createUser(user);
    }
}
