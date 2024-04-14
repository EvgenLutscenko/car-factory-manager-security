package ua.lutsenko.project.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ua.lutsenko.project.config.MapperConfig;
import ua.lutsenko.project.dto.car.CarResponseDto;
import ua.lutsenko.project.model.Car;

@Mapper(config = MapperConfig.class, uses = {UserMapper.class, FactoryMapper.class})
public interface CarMapper {

//    @Mapping(target = "factory", source = "factoryId", qualifiedByName = "factoryById")
//    @Mapping(target = "user", source = "userId", qualifiedByName = "userById")
//    Car toModel(CreateCarRequestDto createCarRequestDto);

    @Mapping(target = "factoryId", source = "factory.id")
    @Mapping(target = "userId", source = "user.id")
    CarResponseDto toDto(Car car);
}
