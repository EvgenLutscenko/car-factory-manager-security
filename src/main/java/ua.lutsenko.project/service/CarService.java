package ua.lutsenko.project.service;

import org.springframework.security.core.Authentication;
import ua.lutsenko.project.dto.car.CreateCarRequestDto;
import ua.lutsenko.project.dto.car.CarResponseDto;

import java.util.List;

public interface CarService {
    CarResponseDto create(CreateCarRequestDto requestDto);

    List<CarResponseDto> findAll(Authentication authentication);

}
