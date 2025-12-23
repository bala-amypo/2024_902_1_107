package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/auth")
@Tag(name = "Authentication")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    // Register API
    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody User user) {
        return ResponseEntity.ok(userService.register(user));
    }

    // Login API (NO JWT)
    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@RequestBody User user) {

        User dbUser = userService.findByEmail(user.getEmail());

        if (dbUser == null) {
            return ResponseEntity.status(401)
                    .body(Map.of("message", "User not found"));
        }

        if (!dbUser.getPassword().equals(user.getPassword())) {
            return ResponseEntity.status(401)
                    .body(Map.of("message", "Invalid password"));
        }

        return ResponseEntity.ok(
                Map.of("message", "Login successful")
        );
    }
}
