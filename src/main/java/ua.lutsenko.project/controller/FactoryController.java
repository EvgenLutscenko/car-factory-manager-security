package ua.lutsenko.project.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ua.lutsenko.project.dto.factory.CreateFactoryRequestDto;
import ua.lutsenko.project.model.Factory;
import ua.lutsenko.project.service.FactoryService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/factory")
public class FactoryController {
    private final FactoryService factoryService;

    @PostMapping
    public Factory create(@RequestBody @Valid CreateFactoryRequestDto factoryRequest){
        return factoryService.create(factoryRequest);
    }

    @GetMapping
    public List<Factory> findAll(){
        return factoryService.findAll();
    }
 }
