package com.example.socialmediabackend.service;

import com.example.socialmediabackend.model.User;
import com.example.socialmediabackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void register(User user) {
        if (userRepository.existsByPhone(user.getPhone())) {
            throw new IllegalArgumentException("此電話已被註冊");
        }
        userRepository.save(user);
    }

    @Override
    public String login(String phone, String password) {
        User user = userRepository.findByPhone(phone);
        if (user == null) {
            throw new IllegalArgumentException("查無此電話");
        }
        if (!user.getPassword().equals(password)) {
            throw new IllegalArgumentException("密碼錯誤");
        }
        return "登入成功";
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(int id) {
        return userRepository.findById(id);
    }

    @Override
    public void updateUser(int id, User user) {
        userRepository.update(id, user);
    }

    @Override
    public void deleteUser(int id) {
        userRepository.delete(id);
    }
}
