package com.example.socialmediabackend.controller;

import com.example.socialmediabackend.model.Post;
import com.example.socialmediabackend.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping("/posts")
    public String createPost(@RequestBody Post post) {
        postService.createPost(post);
        return "Post created successfully!";
    }

    @GetMapping("/posts")
    public List<Post> getAllPosts() {
        return postService.getAllPosts();
    }

    @GetMapping("/posts/{id}")
    public Post getPostById(@PathVariable int id) {
        return postService.getPostById(id);
    }

    @PutMapping("/posts/{id}")
    public String updatePost(@PathVariable int id, @RequestBody Post post) {
        postService.updatePost(id, post);
        return "Post updated successfully!";
    }

    @DeleteMapping("/posts/{id}")
    public String deletePost(@PathVariable int id) {
        postService.deletePost(id);
        return "Post deleted successfully!";
    }
}
