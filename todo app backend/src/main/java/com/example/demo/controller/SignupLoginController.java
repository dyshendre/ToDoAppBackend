package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.InputLoginDto;
import com.example.demo.dto.InputSignupDto;
import com.example.demo.dto.OutputResponseDto;
import com.example.demo.serviceImpl.SignupLogin;
import jakarta.servlet.http.HttpServletRequest;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/signuplogin")
public class SignupLoginController {

    @Autowired
    private SignupLogin signupLogin;

    @PostMapping("/signup")
    public OutputResponseDto signUp(HttpServletRequest httpServletRequest,@RequestBody InputSignupDto inputSignupDto) {
        return signupLogin.signup(inputSignupDto);
    }

    @PostMapping("/login")
    public OutputResponseDto login(HttpServletRequest httpServletRequest,@RequestBody InputLoginDto inputLoginDto)
    {
        return signupLogin.login(inputLoginDto);
    }
}
