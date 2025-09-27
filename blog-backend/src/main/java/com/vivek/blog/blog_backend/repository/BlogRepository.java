package com.vivek.blog.blog_backend.repository;

import com.vivek.blog.blog_backend.entity.Blog;
import com.vivek.blog.blog_backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogRepository extends JpaRepository<Blog, Long> {
    // findAll(Pageable) is already inherited from JpaRepository

    // Find blogs by author with pagination
    Page<Blog> findByAuthor(User author, Pageable pageable);

    // Find blogs by author email
    Page<Blog> findByAuthorEmail(String email, Pageable pageable);

    // Optional: Find blogs by title containing (for search functionality)
    Page<Blog> findByTitleContainingIgnoreCase(String title, Pageable pageable);
}