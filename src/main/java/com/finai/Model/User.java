package com.finai.Model;

import com.finai.DTOs.UpdateUserDTO;
import com.finai.DTOs.UserRequestDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "FINAI_USERS")
public class User {
@Id
@GeneratedValue (strategy = GenerationType.IDENTITY)
private Long id;
private String name;
private String email;
private String password;
@Column(name = "user_create_date", updatable = false, insertable = false)
private LocalDateTime createDate;
private double balance;
private double OpeningBalance;
private double salary;
private boolean userNotifications;

    public User(UserRequestDTO userDto) {
        this.id = userDto.id();
        this.name = userDto.name();
        this.email = userDto.email();
        this.password = userDto.password();
        this.balance = userDto.balance();
        this.OpeningBalance = userDto.openingBalance();
        this.salary = userDto.salary();
        this.userNotifications = userDto.userNotifications();
    }

    public void update(UpdateUserDTO dto) {
        if (dto.name() != null) this.name = dto.name();
        if (dto.email() != null) this.email = dto.email();
        if (dto.password() != null) this.password = dto.password();
        if (dto.balance() != null) this.balance = dto.balance();
        if (dto.openingBalance() != null) this.OpeningBalance = dto.openingBalance();
        if (dto.salary() != null) this.salary = dto.salary();
        if (dto.userNotifications() != null) this.userNotifications = dto.userNotifications();
    }
}
