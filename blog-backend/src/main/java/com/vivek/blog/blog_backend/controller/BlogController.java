package com.vivek.blog.blog_backend.controller;

import com.vivek.blog.blog_backend.entity.Blog;
import com.vivek.blog.blog_backend.entity.User;
import com.vivek.blog.blog_backend.service.BlogService;
import com.vivek.blog.blog_backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/blogs")
@CrossOrigin(origins = "http://localhost:*")  // Allows any localhost port
public class BlogController {

    @Autowired
    private BlogService blogService;

    @Autowired
    private UserService userService;

    // Create blog (authenticated users only)
    @PostMapping
    public ResponseEntity<?> createBlog(@RequestBody Blog blog) {
        try {
            User currentUser = getCurrentUser();
            blog.setAuthor(currentUser);
            Blog createdBlog = blogService.createBlog(blog);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdBlog);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("User not authenticated: " + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error creating blog: " + e.getMessage());
        }
    }

    // List all blogs with pagination (public)
    @GetMapping
    public ResponseEntity<Page<Blog>> getAllBlogs(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "desc") String sortDirection) {

        Sort sort = sortDirection.equalsIgnoreCase("desc")
                ? Sort.by(sortBy).descending()
                : Sort.by(sortBy).ascending();

        Page<Blog> blogs = blogService.getAllBlogs(PageRequest.of(page, size, sort));
        return ResponseEntity.ok(blogs);
    }

    // Get current user's blogs with pagination (authenticated)
    @GetMapping("/my-blogs")
    public ResponseEntity<?> getMyBlogs(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size) {
        try {
            User currentUser = getCurrentUser();
            Page<Blog> userBlogs = blogService.getBlogsByAuthor(currentUser, PageRequest.of(page, size, Sort.by("id").descending()));
            return ResponseEntity.ok(userBlogs);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("User not authenticated: " + e.getMessage());
        }
    }

    // Search blogs by title (public)
    @GetMapping("/search")
    public ResponseEntity<Page<Blog>> searchBlogs(
            @RequestParam String title,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size) {

        Page<Blog> blogs = blogService.searchBlogsByTitle(title, PageRequest.of(page, size, Sort.by("id").descending()));
        return ResponseEntity.ok(blogs);
    }

    // Get blog details by ID (public)
    @GetMapping("/{id}")
    public ResponseEntity<?> getBlog(@PathVariable Long id) {
        Optional<Blog> blog = blogService.getBlogById(id);
        if (blog.isPresent()) {
            return ResponseEntity.ok(blog.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Blog not found with id: " + id);
        }
    }

    // Update blog (only author)
    @PutMapping("/{id}")
    public ResponseEntity<?> updateBlog(@PathVariable Long id, @RequestBody Blog blog) {
        try {
            User currentUser = getCurrentUser();
            Optional<Blog> existingBlog = blogService.getBlogById(id);

            if (existingBlog.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Blog not found with id: " + id);
            }

            if (!existingBlog.get().getAuthor().getId().equals(currentUser.getId())) {
                return ResponseEntity.status(HttpStatus.FORBIDDEN).body("You are not authorized to update this blog");
            }

            Blog updatedBlog = blogService.updateBlog(id, blog);
            return ResponseEntity.ok(updatedBlog);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("User not authenticated: " + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error updating blog: " + e.getMessage());
        }
    }

    // Delete blog (only author)
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBlog(@PathVariable Long id) {
        try {
            User currentUser = getCurrentUser();
            Optional<Blog> existingBlog = blogService.getBlogById(id);

            if (existingBlog.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Blog not found with id: " + id);
            }

            if (!existingBlog.get().getAuthor().getId().equals(currentUser.getId())) {
                return ResponseEntity.status(HttpStatus.FORBIDDEN).body("You are not authorized to delete this blog");
            }

            blogService.deleteBlog(id);
            return ResponseEntity.ok("Blog deleted successfully");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("User not authenticated: " + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error deleting blog: " + e.getMessage());
        }
    }

    // Helper method to get currently logged-in user
    private User getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null || !authentication.isAuthenticated()) {
            throw new RuntimeException("No authenticated user found");
        }

        String email;
        Object principal = authentication.getPrincipal();

        if (principal instanceof UserDetails) {
            email = ((UserDetails) principal).getUsername();
        } else {
            email = principal.toString();
        }

        return userService.getUserByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found with email: " + email));
    }
}