package ua.lutsenko.project.dto.user;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserRequestDto {
    @NotBlank
    @Size(min = 4)
    private String username;
    @NotBlank
    @Size(min = 4)
    private String password;
}
