package com.finai.DTOs.user;

public record UserRequestDTO(Long id,
                             String name,
                             String email,
                             String password,
                             Double balance,
                             Double openingBalance,
                             Double salary,
                             Boolean userNotifications) {
}
