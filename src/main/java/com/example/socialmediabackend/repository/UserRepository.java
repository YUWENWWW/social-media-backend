package com.example.socialmediabackend.repository;

import com.example.socialmediabackend.model.User;
import java.util.List;

public interface UserRepository {
    List<User> findAll();
    User findById(int id);
    User findByPhone(String phone);
    boolean existsByPhone(String phone);
    void save(User user);
    void update(int id, User user);
    void delete(int id);
}
