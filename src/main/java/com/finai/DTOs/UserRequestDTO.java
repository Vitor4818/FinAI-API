package com.finai.DTOs;

import java.time.LocalDateTime;

public record UserRequestDTO(Long id,
                             String name,
                             String email,
                             String password,
                             LocalDateTime createDate,
                             double balance,
                             double openingBalance,
                             double salary,
                             boolean userNotifications) {
}
