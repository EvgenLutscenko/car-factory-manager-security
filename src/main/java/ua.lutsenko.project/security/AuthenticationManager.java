package ua.lutsenko.project.security;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import ua.lutsenko.project.dto.user.UserLoginDto;

@Component
@AllArgsConstructor
public class AuthenticationManager {
    private final AuthenticationService authenticationService;

    public boolean isAuthenticated(Authentication authentication){
        if(authentication == null){
            return false;
        }

        UserLoginDto userLoginDto = new UserLoginDto(
                (String) authentication.getPrincipals(),
                (String) authentication.getCredentials());

        return authenticationService.authenticate(userLoginDto);
    }
}
