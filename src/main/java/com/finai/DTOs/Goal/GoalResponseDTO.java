package com.finai.DTOs.Goal;

import com.finai.Model.Goal;
import com.finai.Model.User;

import java.util.Date;

public record GoalResponseDTO(
        Long id,
        User userId,
        Long statusId,
        String description,
        double goalValue,
        double accumulatedValue,
         Date startDate,
         Date endDate
) {
    public  GoalResponseDTO (Goal goal){
        this(
                goal.getId(),
                goal.getUserId(),
                goal.getStatusId(),
                goal.getDescription(),
                goal.getGoalValue(),
                goal.getAccumulatedValue(),
                goal.getStartDate(),
                goal.getEndDate()
        );
    }
}
