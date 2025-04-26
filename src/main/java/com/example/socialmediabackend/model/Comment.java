package com.example.socialmediabackend.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Comment {
    private Integer commentId;
    private Integer postId;
    private Integer userId;
    private String content;
    private LocalDateTime createdAt;
}