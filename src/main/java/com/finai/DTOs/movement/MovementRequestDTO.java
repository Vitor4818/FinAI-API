package com.finai.DTOs.movement;

import com.finai.Model.User;

public record MovementRequestDTO(
        User user,
        Long categoryId,
        Long paymentMethodId,
        Long movementTypeId,
        double value,
        String description,
        String movementDate,
        Long recurringId
) {
}
