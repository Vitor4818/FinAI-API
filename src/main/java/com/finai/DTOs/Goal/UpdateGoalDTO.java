package com.finai.DTOs.Goal;

import com.finai.Model.User;

import java.util.Date;

public record UpdateGoalDTO(
        User userId,
        Long statusId,
        String description,
        Double goalValue,
        Double accumulatedValue,
        Date startDate,
        Date endDate
) {
}
