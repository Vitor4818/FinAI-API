package com.finai.DTOs;

import java.time.LocalDateTime;

public record UpdateUserDTO(
                            Long id,
                            String name,
                            String email,
                            String password,
                            Double balance,
                            Double openingBalance,
                            Double salary,
                            Boolean userNotifications) {
}
