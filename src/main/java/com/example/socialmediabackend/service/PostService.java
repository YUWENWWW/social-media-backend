package com.example.socialmediabackend.service;

import com.example.socialmediabackend.model.Post;
import java.util.List;

public interface PostService {
    List<Post> getAllPosts();
    Post getPostById(int id);
    void createPost(Post post);
    void updatePost(int id, Post post);
    void deletePost(int id);
}
