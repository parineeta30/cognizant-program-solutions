package com.cognizant.jwtauth.controller;

import com.cognizant.jwtauth.model.JwtRequest;
import com.cognizant.jwtauth.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public String login(@RequestBody JwtRequest jwtRequest) {
        try {
            authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                    jwtRequest.getUsername(),
                    jwtRequest.getPassword()
                )
            );
        } catch (AuthenticationException e) {
            return "Invalid username or password";
        }

        return jwtUtil.generateToken(jwtRequest.getUsername());
    }
}
