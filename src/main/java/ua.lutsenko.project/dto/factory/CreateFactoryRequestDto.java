package ua.lutsenko.project.dto.factory;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CreateFactoryRequestDto {
    @NotBlank
    private String name;

    @NotBlank
    private String location;
}
