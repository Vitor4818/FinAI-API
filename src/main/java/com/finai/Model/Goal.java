package com.finai.Model;

import com.finai.DTOs.Goal.GoalRequestDTO;
import com.finai.DTOs.Goal.UpdateGoalDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "FINAI_GOAL")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Goal {

    private Long id;
    private User userId;
    private Long statusId;
    private String description;
    private double goalValue;
    private double accumulatedValue;
    private Date startDate;
    private Date endDate;


    public Goal(GoalRequestDTO dto) {
        this.userId = dto.userId();
        this.statusId = dto.statusId();
        this.description = dto.description();
        this.goalValue = dto.goalValue();
        this.accumulatedValue = dto.accumulatedValue();
        this.startDate = dto.startDate();
        this.endDate = dto.endDate();
    }

    public void update(UpdateGoalDTO dto) {
        if (dto.userId() != null) this.userId = dto.userId();
        if (dto.statusId() != null) this.statusId = dto.statusId();
        if (dto.description() != null) this.description = dto.description();
        if (dto.goalValue() != null) this.goalValue = dto.goalValue();
        if (dto.accumulatedValue() != null) this.accumulatedValue = dto.accumulatedValue();
        if (dto.startDate() != null) this.startDate = dto.startDate();
        if (dto.endDate() != null) this.endDate = dto.endDate();
    }

}
