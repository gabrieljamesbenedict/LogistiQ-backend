package com.porado.LogistiQ.backend.service;

import com.porado.LogistiQ.backend.dto.RegisterRequest;
import com.porado.LogistiQ.backend.model.User;

import java.util.List;

public interface UserService {
    User registerUser(RegisterRequest registerRequest);
    User getUser(Long id);
    List<User> getAllUsers();
    User createUser(User employee);
    User updateUser(User employee);
    void deleteUser(User employee);
}

