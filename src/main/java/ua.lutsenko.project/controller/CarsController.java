package ua.lutsenko.project.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ua.lutsenko.project.dto.car.CreateCarRequestDto;
import ua.lutsenko.project.dto.car.CarResponseDto;
import ua.lutsenko.project.security.SecurityContextHolder;
import ua.lutsenko.project.service.CarService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/car")
public class CarsController {
    private final CarService carService;

    @PostMapping
    public CarResponseDto create(
            @RequestBody
            @Valid
            CreateCarRequestDto requestDto
    ){
        return carService.create(requestDto);
    }

    @GetMapping
    public List<CarResponseDto> findAll(){
        String username = (String) SecurityContextHolder.getSecurityContext().getAuthentication().getPrincipals();
        return carService.findAll(username);
    }
}
