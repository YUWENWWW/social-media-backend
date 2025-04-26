package com.example.socialmediabackend.service;

import com.example.socialmediabackend.model.User;

import java.util.List;

public interface UserService {
    void register(User user);
    String login(String phone, String password);
    List<User> getAllUsers();
    User getUserById(int id);
    void updateUser(int id, User user);
    void deleteUser(int id);
}
