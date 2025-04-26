package com.example.socialmediabackend.repository;

import com.example.socialmediabackend.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private final List<User> users = new ArrayList<>();
    private int idCounter = 1;

    @Override
    public List<User> findAll() {
        return users;
    }

    @Override
    public User findById(int id) {
        return users.stream()
                .filter(u -> u.getUserId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public User findByPhone(String phone) {
        return users.stream()
                .filter(u -> phone.equals(u.getPhone()))
                .findFirst()
                .orElse(null);
    }

    @Override
    public boolean existsByPhone(String phone) {
        return users.stream()
                .anyMatch(u -> phone.equals(u.getPhone()));
    }

    @Override
    public void save(User user) {
        user.setUserId(idCounter++);
        users.add(user);
    }

    @Override
    public void update(int id, User user) {
        User existing = findById(id);
        if (existing != null) {
            existing.setUserName(user.getUserName());
            existing.setPhone(user.getPhone());
            existing.setPassword(user.getPassword());
            existing.setBiography(user.getBiography());
            existing.setCoverImage(user.getCoverImage());
        }
    }

    @Override
    public void delete(int id) {
        users.removeIf(u -> u.getUserId() == id);
    }
}
