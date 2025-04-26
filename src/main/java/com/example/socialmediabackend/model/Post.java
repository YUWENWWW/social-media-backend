package com.example.socialmediabackend.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Post {
    private Integer postId;
    private Integer userId;
    private String content;
    private String image;
    private LocalDateTime createdAt;
}