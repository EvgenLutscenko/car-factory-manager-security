package ua.lutsenko.project.service;

import ua.lutsenko.project.dto.user.UserRequestDto;
import ua.lutsenko.project.dto.user.UserResponseDto;
import ua.lutsenko.project.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    UserResponseDto register(UserRequestDto requestDto);

    List<UserResponseDto> findAll();

    Optional<User> getUserByUsername(String username);

}
