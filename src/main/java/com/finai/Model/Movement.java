package com.finai.Model;

import com.finai.DTOs.movement.MovementRequestDTO;
import com.finai.DTOs.movement.MovementResponseDto;
import com.finai.DTOs.movement.UpdateMovementDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "FINAI_MOVEMENT")
public class Movement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movement_id")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", unique = true)
    private User user;
    private Long categoryId;
    private Long paymentMethodId;
    private Long movementTypeId;
    private double value;
    private String description;
    private String movementDate;
    private Long recurringId;

    public Movement(MovementRequestDTO dto) {
        this.user = dto.user();
        this.recurringId = dto.recurringId();
        this.description = dto.description();
        this.movementDate = dto.movementDate();
        this.value = dto.value();
        this.movementTypeId = dto.movementTypeId();;
        this.paymentMethodId = dto.paymentMethodId();
        this.categoryId = dto.categoryId();
    }

    public void update(UpdateMovementDTO dto) {
        if (dto.categoryId() != null) this.categoryId = dto.categoryId();
        if (dto.paymentMethodId() != null) this.paymentMethodId = dto.paymentMethodId();
        if (dto.movementTypeId() != null) this.movementTypeId = dto.movementTypeId();
        if (dto.value() != null) this.value = dto.value();
        if (dto.description() != null) this.description = dto.description();
        if (dto.movementDate() != null) this.movementDate = dto.movementDate();
        if (dto.recurringId() != null) this.recurringId = dto.recurringId();
    }
}
