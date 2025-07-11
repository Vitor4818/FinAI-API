package com.finai.DTOs.Goal;

import com.finai.Model.User;

import java.util.Date;

public record GoalRequestDTO(
         User userId,
         Long statusId,
         String description,
         double goalValue,
         double accumulatedValue,
         Date startDate,
         Date endDate
) {
}
