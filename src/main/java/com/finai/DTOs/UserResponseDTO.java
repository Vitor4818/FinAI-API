package com.finai.DTOs;

import com.finai.Model.User;

public record UserResponseDTO(
        Long id,
        String name,
        String email,
        String password,
        double openingBalance,
        double salary,
        boolean userNotifications
) {
    public UserResponseDTO(User user) {
        this(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getPassword(),
                user.getOpeningBalance(),
                user.getSalary(),
                user.isUserNotifications()
        );
    }
}