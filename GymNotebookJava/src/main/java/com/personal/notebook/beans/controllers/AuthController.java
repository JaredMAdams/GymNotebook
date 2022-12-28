package com.personal.notebook.beans.controllers;

import com.personal.notebook.beans.services.AuthService;
import com.personal.notebook.dtos.LoginRequest;
import com.personal.notebook.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody LoginRequest loginRequest) {
        Optional<User> optional = authService.findByCredentials(loginRequest.getCredentials(), loginRequest.getPassword());
        if(!optional.isPresent()) {
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(optional.get());
    }
}
