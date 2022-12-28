package com.personal.notebook.beans.services;

import com.personal.notebook.entities.User;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    private final UserService userService;

    public AuthService(UserService userService) {
        this.userService = userService;
    }

    public Optional<User> findByCredentials(String credentials, String password) {
        return userService.findByCredentials(credentials, password);
    }
}
