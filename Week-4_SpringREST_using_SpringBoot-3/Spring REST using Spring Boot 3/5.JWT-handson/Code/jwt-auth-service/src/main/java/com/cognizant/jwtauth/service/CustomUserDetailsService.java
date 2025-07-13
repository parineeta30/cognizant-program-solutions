package com.cognizant.jwtauth.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // For demo purposes, we're using a static user.
        // You can later replace this with DB lookup using JPA or JDBC.
        if ("user".equals(username)) {
            return new User("user", "password", Collections.emptyList());
        } else {
            throw new UsernameNotFoundException("User not found: " + username);
        }
    }
}
