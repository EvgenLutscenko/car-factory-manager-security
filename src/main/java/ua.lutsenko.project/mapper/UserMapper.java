package ua.lutsenko.project.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Named;
import ua.lutsenko.project.config.MapperConfig;
import ua.lutsenko.project.dto.user.UserRequestDto;
import ua.lutsenko.project.dto.user.UserResponseDto;
import ua.lutsenko.project.model.User;

@Mapper(config = MapperConfig.class)
public interface UserMapper {
    User toModel(UserRequestDto requestDto);

    UserResponseDto toDto(User user);

    @Named("userById")
    default User userById(Long id){
        return new User(id);
    }
}
