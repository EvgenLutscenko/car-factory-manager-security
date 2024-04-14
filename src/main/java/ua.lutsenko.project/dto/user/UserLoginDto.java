package ua.lutsenko.project.dto.user;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserLoginDto {

    @NotEmpty
    @Size(min = 4)
    String username;

    @NotEmpty
    @Size(min = 4)
    String password;

    public UserLoginDto(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
