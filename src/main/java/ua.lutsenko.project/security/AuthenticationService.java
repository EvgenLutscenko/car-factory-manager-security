package ua.lutsenko.project.security;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ua.lutsenko.project.dto.user.UserLoginDto;
import ua.lutsenko.project.model.User;
import ua.lutsenko.project.repository.UserRepo;

import java.util.Optional;

@Service
@AllArgsConstructor
public class AuthenticationService {

    private final UserRepo userRepo;

    public boolean authenticate(UserLoginDto userLoginDto){
        Optional<User> user = userRepo.findByUsername(userLoginDto.getUsername());
        return user.isPresent() && user.get().getPassword().equals(userLoginDto.getPassword());
    }
}
