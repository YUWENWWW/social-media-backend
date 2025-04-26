package com.example.socialmediabackend.repository;

import com.example.socialmediabackend.model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class CommentRepositoryImpl implements CommentRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private Comment mapRowToComment(ResultSet rs, int rowNum) throws SQLException {
        Comment comment = new Comment();
        comment.setCommentId(rs.getInt("comment_id"));
        comment.setPostId(rs.getInt("post_id"));
        comment.setUserId(rs.getInt("user_id"));
        comment.setContent(rs.getString("content"));
        comment.setCreatedAt(rs.getTimestamp("created_at").toLocalDateTime());
        return comment;
    }

    @Override
    public List<Comment> findAll() {
        String sql = "SELECT * FROM comment";
        return jdbcTemplate.query(sql, this::mapRowToComment);
    }

    @Override
    public Comment findById(int id) {
        String sql = "SELECT * FROM comment WHERE comment_id = ?";
        return jdbcTemplate.queryForObject(sql, this::mapRowToComment, id);
    }

    @Override
    public void save(Comment comment) {
        String sql = "INSERT INTO comment (post_id, user_id, content) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, comment.getPostId(), comment.getUserId(), comment.getContent());
    }

    @Override
    public void update(int id, Comment comment) {
        String sql = "UPDATE comment SET content = ? WHERE comment_id = ?";
        jdbcTemplate.update(sql, comment.getContent(), id);
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM comment WHERE comment_id = ?";
        jdbcTemplate.update(sql, id);
    }
}
