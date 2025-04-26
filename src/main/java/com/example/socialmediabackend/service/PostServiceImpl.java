package com.example.socialmediabackend.service;

import com.example.socialmediabackend.model.Post;
import com.example.socialmediabackend.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Override
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    @Override
    public Post getPostById(int id) {
        return postRepository.findById(id);
    }

    @Override
    public void createPost(Post post) {
        postRepository.save(post);
    }

    @Override
    public void updatePost(int id, Post post) {
        postRepository.update(id, post);
    }

    @Override
    public void deletePost(int id) {
        postRepository.delete(id);
    }
}
