package ua.lutsenko.project.service;

import ua.lutsenko.project.dto.car.CreateCarRequestDto;
import ua.lutsenko.project.dto.car.CarResponseDto;

import java.util.List;

public interface CarService {
    CarResponseDto create(CreateCarRequestDto requestDto);

    List<CarResponseDto> findAll(String username);

}
