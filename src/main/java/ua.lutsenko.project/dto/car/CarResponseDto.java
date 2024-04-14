package ua.lutsenko.project.dto.car;

import lombok.Data;

@Data
public class CarResponseDto {
    private Long id;

    private String model;

    private Long factoryId;

    private Long userId;
}
