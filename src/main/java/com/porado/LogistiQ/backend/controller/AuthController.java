package com.porado.LogistiQ.backend.controller;

import com.porado.LogistiQ.backend.dto.RegisterRequest;
import com.porado.LogistiQ.backend.dto.UserInformation;
import com.porado.LogistiQ.backend.model.User;
import com.porado.LogistiQ.backend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<UserInformation> register(@RequestBody RegisterRequest request) {
        User user = userService.registerUser(request);
        UserInformation userInfo = UserInformation.fromUser(user);
        return ResponseEntity.ok(userInfo);
    }

    @GetMapping("/me")
    public ResponseEntity<UserInformation> me() {
        return null;
    }
}

