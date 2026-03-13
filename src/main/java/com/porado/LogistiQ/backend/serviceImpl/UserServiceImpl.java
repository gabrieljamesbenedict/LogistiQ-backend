package com.porado.LogistiQ.backend.serviceImpl;

import com.porado.LogistiQ.backend.model.Employee;
import com.porado.LogistiQ.backend.model.User;
import com.porado.LogistiQ.backend.repository.UserRepository;
import com.porado.LogistiQ.backend.service.UserService;
import com.porado.LogistiQ.backend.util.UserRole;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public User registerUser(String username, String password) {
        if (userRepository.existsByUsername(username)) {
            throw new IllegalArgumentException("Username already exists");
        }
        String encodedPassword = passwordEncoder.encode(password);
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setRole(UserRole.ROLE_EMPLOYEE);
        return userRepository.save(user);
    }

    @Override
    public User getUser(Long id) {
        return userRepository
                .findById(id)
                .orElseThrow(() -> new IllegalStateException("Employee does not exist"));
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User createUser(User user) {
        if (user.getUserId() != null) throw new IllegalStateException("Cannot create a new User record");
        userRepository.save(user);
        return null;
    }

    @Override
    public User updateUser(User user) {
        if (user.getUserId() == null) throw new IllegalStateException("Cannot update on null ID");
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(User user) {
        userRepository.delete(user);
    }
}

