package ua.lutsenko.project.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ua.lutsenko.project.dto.user.UserLoginDto;
import ua.lutsenko.project.dto.user.UserRequestDto;
import ua.lutsenko.project.dto.user.UserResponseDto;
import ua.lutsenko.project.security.AuthenticationService;
import ua.lutsenko.project.service.UserService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/auth")
public class AuthController {
    private final UserService userService;
    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    public UserResponseDto register(
            @RequestBody @Valid UserRequestDto requestDto){
        return userService.register(requestDto);
    }

    @PostMapping("/login")
    public boolean login(@RequestBody @Valid UserLoginDto userLoginDto){
        return authenticationService.authenticate(userLoginDto);
    }

    @GetMapping
    public List<UserResponseDto> findAll(){
        return userService.findAll();
    }


}
