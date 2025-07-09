package com.finai.DTOs.movement;

import com.finai.Model.User;

public record UpdateMovementDTO(
        User user,
        Long categoryId,
        Long paymentMethodId,
        Long movementTypeId,
        Double value,
        String description,
        String movementDate,
        Long recurringId
) {
}
