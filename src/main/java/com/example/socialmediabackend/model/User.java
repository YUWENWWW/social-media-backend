package com.example.socialmediabackend.model;

import lombok.Data;

@Data
public class User {
    private Integer userId;
    private String userName;
    private String phone;      // 用 phone 註冊、登入
    private String password;
    private String biography;
    private String coverImage;
}
