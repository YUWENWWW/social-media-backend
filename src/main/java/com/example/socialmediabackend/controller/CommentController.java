package com.example.socialmediabackend.controller;

import com.example.socialmediabackend.model.Comment;
import com.example.socialmediabackend.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping("/comments")
    public String createComment(@RequestBody Comment comment) {
        commentService.createComment(comment);
        return "Comment created successfully!";
    }

    @GetMapping("/comments")
    public List<Comment> getAllComments() {
        return commentService.getAllComments();
    }

    @GetMapping("/comments/{id}")
    public Comment getCommentById(@PathVariable int id) {
        return commentService.getCommentById(id);
    }

    @PutMapping("/comments/{id}")
    public String updateComment(@PathVariable int id, @RequestBody Comment comment) {
        commentService.updateComment(id, comment);
        return "Comment updated successfully!";
    }

    @DeleteMapping("/comments/{id}")
    public String deleteComment(@PathVariable int id) {
        commentService.deleteComment(id);
        return "Comment deleted successfully!";
    }
}
