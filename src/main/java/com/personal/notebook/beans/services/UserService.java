package com.personal.notebook.beans.services;

import com.personal.notebook.beans.repositories.UserRepo;
import com.personal.notebook.entities.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepo userRepo;

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public Optional<User> readyByUserId(Integer userId) {
        return this.userRepo.findById(userId);
    }

    public List<User> readAll() {
        return this.userRepo.findAll();
    }

    public Optional<User> findByCredentials(String email, String password) {
        return this.userRepo.findByCredentials(email, password);
    }

    public User createUser(User user) {
        return this.userRepo.save(user);
    }

    public void deleteUser(Integer userId) {
        this.userRepo.deleteById(userId);
    }
}
