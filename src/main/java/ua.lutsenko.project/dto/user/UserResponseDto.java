package ua.lutsenko.project.dto.user;

import jakarta.persistence.Column;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserResponseDto {
    private Long id;

    private String username;

    private LocalDateTime registrationDate;
}
