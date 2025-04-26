package com.example.socialmediabackend.service;

import com.example.socialmediabackend.model.Comment;
import com.example.socialmediabackend.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Override
    public List<Comment> getAllComments() {
        return commentRepository.findAll();
    }

    @Override
    public Comment getCommentById(int id) {
        return commentRepository.findById(id);
    }

    @Override
    public void createComment(Comment comment) {
        commentRepository.save(comment);
    }

    @Override
    public void updateComment(int id, Comment comment) {
        commentRepository.update(id, comment);
    }

    @Override
    public void deleteComment(int id) {
        commentRepository.delete(id);
    }
}
