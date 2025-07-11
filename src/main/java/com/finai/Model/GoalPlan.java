package com.finai.Model;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "FINAI_GOAL_PLAN")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class GoalPlan {
    private Long id;
    private Goal goalId;
    private Date period;
    private double suggested_value;
    private Date generationDate;
}
