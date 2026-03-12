package com.porado.LogistiQ.backend.controller;

import com.porado.LogistiQ.backend.model.User;
import com.porado.LogistiQ.backend.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:3000")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    public record RegisterRequest(String username, String password, String role) {
    }

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody RegisterRequest request) {
        User user = userService.registerUser(request.username(), request.password(),
                request.role() != null ? request.role() : "USER");
        return ResponseEntity.ok(user);
    }
}

