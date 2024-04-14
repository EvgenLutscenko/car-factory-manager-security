package ua.lutsenko.project.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ua.lutsenko.project.dto.factory.CreateFactoryRequestDto;
import ua.lutsenko.project.mapper.FactoryMapper;
import ua.lutsenko.project.model.Factory;
import ua.lutsenko.project.repository.FactoryRepo;
import ua.lutsenko.project.service.FactoryService;

import java.util.List;

@Service
@AllArgsConstructor
public class FactoryServiceImpl implements FactoryService {
    private final FactoryRepo factoryRepo;
    private final FactoryMapper mapper;

    @Override
    public List<Factory> findAll() {
        return factoryRepo.findAll();
    }

    @Override
    public Factory create(CreateFactoryRequestDto factoryRequest) {
        return factoryRepo.save(mapper.toModel(factoryRequest));
    }
}
