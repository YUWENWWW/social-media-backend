package com.example.socialmediabackend.service;

import com.example.socialmediabackend.model.Comment;
import java.util.List;

public interface CommentService {
    List<Comment> getAllComments();
    Comment getCommentById(int id);
    void createComment(Comment comment);
    void updateComment(int id, Comment comment);
    void deleteComment(int id);
}
