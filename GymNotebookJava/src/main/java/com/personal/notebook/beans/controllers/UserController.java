package com.personal.notebook.beans.controllers;

import com.personal.notebook.beans.services.UserService;
import com.personal.notebook.entities.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable Integer userId) {
        Optional<User> optionalUser = this.userService.readyByUserId(userId);
        try {
            optionalUser.isPresent();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok(optionalUser.get());
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(){
        return ResponseEntity.ok(this.userService.readAll());
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.userService.createUser(user));
    }

    @PutMapping
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.userService.createUser(user));
    }

    @DeleteMapping(value = "/{userId}")
    public void deleteUser(@PathVariable Integer userId) {
        this.userService.deleteUser(userId);
    }
}
