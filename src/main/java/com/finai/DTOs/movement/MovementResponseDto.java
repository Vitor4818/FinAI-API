package com.finai.DTOs.movement;

import com.finai.Model.Movement;
import com.finai.Model.User;

public record MovementResponseDto(
        Long id,
        User user,
        Long categoryId,
        Long paymentMethodId,
        Long movementTypeId,
        double value,
        String description,
        String movementDate,
        Long recurringId
) {

    public MovementResponseDto(Movement movement){
        this(
                movement.getId(),
                movement.getUser(),
                movement.getCategoryId(),
                movement.getPaymentMethodId(),
                movement.getMovementTypeId(),
                movement.getValue(),
                movement.getDescription(),
                movement.getMovementDate(),
                movement.getRecurringId()
        );
    }
}
