package com.porado.LogistiQ.backend.service;

import com.porado.LogistiQ.backend.model.User;

import java.util.List;

public interface UserService {
    User registerUser(String username, String password);

    User getUser(Long id);
    List<User> getAllUsers();
    User createUser(User employee);
    User updateUser(User employee);
    void deleteUser(User employee);
}

