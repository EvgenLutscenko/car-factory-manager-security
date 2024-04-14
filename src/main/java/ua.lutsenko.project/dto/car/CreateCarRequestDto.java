package ua.lutsenko.project.dto.car;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CreateCarRequestDto {
    @NotBlank
    private String model;
    @NotNull
    @Min(value = 1)
    private Long factoryId;
    @NotNull
    @Min(value = 1)
    private Long userId;
}
