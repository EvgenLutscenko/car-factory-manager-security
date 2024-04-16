package ua.lutsenko.project.service.impl;

import lombok.AllArgsConstructor;
import org.hibernate.context.internal.ThreadLocalSessionContext;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import ua.lutsenko.project.dto.car.CreateCarRequestDto;
import ua.lutsenko.project.dto.car.CarResponseDto;
import ua.lutsenko.project.exception.factory.FactoryNotFoundException;
import ua.lutsenko.project.exception.user.UserNotFoundException;
import ua.lutsenko.project.mapper.CarMapper;
import ua.lutsenko.project.model.Car;
import ua.lutsenko.project.model.Factory;
import ua.lutsenko.project.model.User;
import ua.lutsenko.project.repository.CarRepo;
import ua.lutsenko.project.repository.FactoryRepo;
import ua.lutsenko.project.repository.UserRepo;
import ua.lutsenko.project.service.CarService;
import ua.lutsenko.project.service.UserService;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CarServiceImpl implements CarService {
    private final UserService userService;
    private final CarRepo carRepo;
    private final FactoryRepo factoryRepo;
    private final UserRepo userRepo;
    private final CarMapper mapper;

    @Override
    public CarResponseDto create(CreateCarRequestDto requestDto) {
        Car car = new Car();
        car.setModel(requestDto.getModel());

        Optional<Factory> factoryById = factoryRepo.getFactoryById(requestDto.getFactoryId());
        Optional<User> userById = userRepo.getUserById(requestDto.getUserId());

        if(factoryById.isEmpty()){
            throw new FactoryNotFoundException("Factory with id: " + requestDto.getFactoryId() + " is not found");
        }

        if(userById.isEmpty()){
            throw new UserNotFoundException("User with id: " + requestDto.getUserId() + " is not found");
        }

        car.setFactory(factoryById.get());
        car.setUser(userById.get());

        Car savedCar = carRepo.save(car);
        return mapper.toDto(savedCar);
    }

    @Override
    public List<CarResponseDto> findAll(Authentication authentication) {
        User user = (User) authentication.getPrincipal();
        return carRepo.findAllByUserId(user.getId()).stream()
                .map(mapper::toDto)
                .toList();
    }
}
