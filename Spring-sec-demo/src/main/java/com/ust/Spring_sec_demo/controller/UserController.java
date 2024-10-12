package com.ust.Spring_sec_demo.controller;

import com.ust.Spring_sec_demo.model.UserCred;
import com.ust.Spring_sec_demo.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

//import com.ust.Spring_sec_demo.model.User;
import com.ust.Spring_sec_demo.service.UserService;

@RestController
public class UserController {

    @Autowired
    private UserService service;

    @Autowired
    private JwtService jwtService;

    @Autowired
    AuthenticationManager authenticationManager;

    @PostMapping("register")
    public UserCred register(@RequestBody UserCred userCred) {
        return service.saveUser(userCred);
    }
    @PostMapping("login")
    public String login(@RequestBody UserCred userCred) {
        Authentication authentication=authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(userCred.getUsername(), userCred.getPassword()));

        if(authentication.isAuthenticated())
            return jwtService.generateToken(userCred.getUsername());
        else
            return "Login Failed";


    }
}
