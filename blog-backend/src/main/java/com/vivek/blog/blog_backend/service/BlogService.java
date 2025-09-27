package com.vivek.blog.blog_backend.service;

import com.vivek.blog.blog_backend.entity.Blog;
import com.vivek.blog.blog_backend.entity.User;
import com.vivek.blog.blog_backend.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class BlogService {

    @Autowired
    private BlogRepository blogRepository;

    public Blog createBlog(Blog blog) {
        // Set creation timestamp if your Blog entity has createdAt field
        // blog.setCreatedAt(LocalDateTime.now());
        return blogRepository.save(blog);
    }

    public Blog updateBlog(Long id, Blog updatedBlog) {
        Blog blog = blogRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Blog not found with id: " + id));

        blog.setTitle(updatedBlog.getTitle());
        blog.setContent(updatedBlog.getContent());
        // Set update timestamp if your Blog entity has updatedAt field
        // blog.setUpdatedAt(LocalDateTime.now());

        return blogRepository.save(blog);
    }

    public Page<Blog> getAllBlogs(Pageable pageable) {
        return blogRepository.findAll(pageable);
    }

    public Optional<Blog> getBlogById(Long id) {
        return blogRepository.findById(id);
    }

    public void deleteBlog(Long id) {
        if (!blogRepository.existsById(id)) {
            throw new RuntimeException("Blog not found with id: " + id);
        }
        blogRepository.deleteById(id);
    }

    // Get blogs by author with pagination
    public Page<Blog> getBlogsByAuthor(User author, Pageable pageable) {
        return blogRepository.findByAuthor(author, pageable);
    }

    // Get blogs by author email with pagination
    public Page<Blog> getBlogsByAuthorEmail(String email, Pageable pageable) {
        return blogRepository.findByAuthorEmail(email, pageable);
    }

    // Search blogs by title
    public Page<Blog> searchBlogsByTitle(String title, Pageable pageable) {
        return blogRepository.findByTitleContainingIgnoreCase(title, pageable);
    }
}