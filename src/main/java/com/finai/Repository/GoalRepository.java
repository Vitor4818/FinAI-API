package com.finai.Repository;

import com.finai.Model.Goal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GoalRepository extends JpaRepository <Goal, Long> {

}
