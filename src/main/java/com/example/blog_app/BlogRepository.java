package com.example.blog_app;

import java.util.List;

import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

@Repository
public class BlogRepository {
    private final JdbcClient jdbcClient;

    public BlogRepository(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }

    public List<Blog> findAll(){
     return jdbcClient.sql("SELECT * FROM blog")
        .query(Blog.class)
        .list();
    }

    public void save(Blog blog) {
        jdbcClient.sql("INSERT INTO blog (title, text) VALUES (:title, :text)")
        .param("title", blog.getTitle())
        .param("text", blog.getText())
        .update();

    } 

    
    public Blog findById(Long id) {
        return jdbcClient.sql("SELECT * FROM blog WHERE id = :id")
                .param("id", id)
                .query(Blog.class)
                .single(); //  1件だけ取得して返す
    }
}
