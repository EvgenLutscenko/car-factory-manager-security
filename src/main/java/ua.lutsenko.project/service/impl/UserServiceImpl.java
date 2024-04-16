package ua.lutsenko.project.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ua.lutsenko.project.dto.user.UserRequestDto;
import ua.lutsenko.project.dto.user.UserResponseDto;
import ua.lutsenko.project.exception.user.UserAlreadyExistException;
import ua.lutsenko.project.mapper.UserMapper;
import ua.lutsenko.project.model.User;
import ua.lutsenko.project.repository.UserRepo;
import ua.lutsenko.project.service.UserService;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepo userRepo;
    private final UserMapper mapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserResponseDto register(UserRequestDto requestDto) {
        if(userRepo.findByUsername(requestDto.getUsername()).isPresent()){
            throw new UserAlreadyExistException(
                    "User with username: " + requestDto.getUsername() + " already exist"
            );
        }
        User model = mapper.toModel(requestDto);
        model.setPassword(passwordEncoder.encode(model.getPassword()));
        User savedUser = userRepo.save(model);
        return mapper.toDto(savedUser);
    }


    @Override
    public List<UserResponseDto> findAll() {
        return userRepo.findAll().stream()
                .map(mapper::toDto)
                .toList();
    }

    @Override
    public Optional<User> getUserByUsername(String username) {
        return userRepo.findByUsername(username);
    }
}
