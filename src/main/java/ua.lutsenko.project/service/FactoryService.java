package ua.lutsenko.project.service;

import ua.lutsenko.project.dto.factory.CreateFactoryRequestDto;
import ua.lutsenko.project.model.Factory;

import java.util.List;

public interface FactoryService {

    Factory create(CreateFactoryRequestDto factoryRequest);

    List<Factory> findAll();
}
