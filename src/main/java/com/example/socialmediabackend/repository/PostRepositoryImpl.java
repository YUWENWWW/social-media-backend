package com.example.socialmediabackend.repository;

import com.example.socialmediabackend.model.Post;
import com.example.socialmediabackend.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class PostRepositoryImpl implements PostRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private Post mapRowToPost(ResultSet rs, int rowNum) throws SQLException {
        Post post = new Post();
        post.setPostId(rs.getInt("post_id"));
        post.setUserId(rs.getInt("user_id"));
        post.setContent(rs.getString("content"));
        post.setImage(rs.getString("image"));
        post.setCreatedAt(rs.getTimestamp("created_at").toLocalDateTime());
        return post;
    }

    @Override
    public List<Post> findAll() {
        String sql = "SELECT * FROM post";
        return jdbcTemplate.query(sql, this::mapRowToPost);
    }

    @Override
    public Post findById(int id) {
        String sql = "SELECT * FROM post WHERE post_id = ?";
        return jdbcTemplate.queryForObject(sql, this::mapRowToPost, id);
    }

    @Override
    public void save(Post post) {
        String sql = "INSERT INTO post (user_id, content, image) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, post.getUserId(), post.getContent(), post.getImage());
    }

    @Override
    public void update(int id, Post post) {
        String sql = "UPDATE post SET content=?, image=? WHERE post_id=?";
        jdbcTemplate.update(sql, post.getContent(), post.getImage(), id);
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM post WHERE post_id=?";
        jdbcTemplate.update(sql, id);
    }
}
