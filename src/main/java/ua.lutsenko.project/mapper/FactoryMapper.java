package ua.lutsenko.project.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Named;
import ua.lutsenko.project.config.MapperConfig;
import ua.lutsenko.project.dto.factory.CreateFactoryRequestDto;
import ua.lutsenko.project.model.Factory;

@Mapper(config = MapperConfig.class)
public interface FactoryMapper {
    Factory toModel(CreateFactoryRequestDto createFactoryRequest);

    @Named("factoryById")
    default Factory factoryById(Long id){
        return new Factory(id);
    }
}
