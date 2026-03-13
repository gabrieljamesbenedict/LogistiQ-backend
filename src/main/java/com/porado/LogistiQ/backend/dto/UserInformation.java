package com.porado.LogistiQ.backend.dto;

import com.porado.LogistiQ.backend.model.User;
import com.porado.LogistiQ.backend.util.UserRole;
import lombok.Data;

@Data
public class UserInformation {
    private Long userId;
    private String username;
    private UserRole role;

    private UserInformation(Long userId, String username, UserRole role) {
        this.userId = userId;
        this.username = username;
        this.role = role;
    }

    public static UserInformation fromUser(User user) {
        return new UserInformation(
                user.getUserId(),
                user.getUsername(),
                user.getRole()
        );
    }
}
