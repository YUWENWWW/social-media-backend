package com.example.socialmediabackend.repository;

import com.example.socialmediabackend.model.Post;
import java.util.List;

public interface PostRepository {
    List<Post> findAll();
    Post findById(int id);
    void save(Post post);
    void update(int id, Post post);
    void delete(int id);
}
