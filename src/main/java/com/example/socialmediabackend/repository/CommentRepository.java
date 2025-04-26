package com.example.socialmediabackend.repository;

import com.example.socialmediabackend.model.Comment;
import java.util.List;

public interface CommentRepository {
    List<Comment> findAll();
    Comment findById(int id);
    void save(Comment comment);
    void update(int id, Comment comment);
    void delete(int id);
}
