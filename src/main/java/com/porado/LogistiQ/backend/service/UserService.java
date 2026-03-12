package com.porado.LogistiQ.backend.service;

import com.porado.LogistiQ.backend.model.User;

public interface UserService {

    User registerUser(String username, String rawPassword, String role);
}

