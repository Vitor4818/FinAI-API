package com.finai.DTOs;

import com.finai.Model.User;

public record UserResponseDTO(
        Long id,
        String name,
        String email,
        String password,
        Double balance,
        Double openingBalance,
        Double salary,
        Boolean userNotifications
) {
    public UserResponseDTO(User user) {
        this(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getPassword(),
                user.getBalance(),
                user.getOpeningBalance(),
                user.getSalary(),
                user.isUserNotifications()
        );
    }
}