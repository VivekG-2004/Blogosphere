package com.vivek.blog.blog_backend.controller;

import com.vivek.blog.blog_backend.entity.User;
import com.vivek.blog.blog_backend.service.UserService;
import com.vivek.blog.blog_backend.config.JwtUtil;
import com.vivek.blog.blog_backend.dto.LoginRequest;
import com.vivek.blog.blog_backend.dto.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:*")  // Allows any localhost port
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtUtil jwtUtil;

    // Signup API
    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody User user) {
        try {
            User savedUser = userService.registerUser(user);
            return ResponseEntity.ok(savedUser);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // Login API with JWT
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        try {
            System.out.println("Login attempt for email: " + loginRequest.getEmail());

            // 1. Find user by email
            User existingUser = userService.getUserByEmail(loginRequest.getEmail())
                    .orElseThrow(() -> new Exception("User not found"));
            System.out.println("User found: " + existingUser.getEmail());

            // 2. Check password
            boolean matches = userService.checkPassword(existingUser, loginRequest.getPassword());
            System.out.println("Password matches: " + matches);

            if (!matches) {
                System.out.println("Password mismatch, returning unauthorized");
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
            }

            // 3. Generate JWT
            String token = jwtUtil.generateToken(existingUser.getEmail());
            System.out.println("Generated token: " + token);

            
            LoginResponse.UserData userData = new LoginResponse.UserData(
                    existingUser.getId(),
                    existingUser.getName(),
                    existingUser.getEmail()
            );
            LoginResponse response = new LoginResponse(token, userData);

            System.out.println("Returning response with token and user data");
            return ResponseEntity.ok(response);

        } catch (Exception e) {
            System.out.println("Login error: " + e.getMessage());
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}