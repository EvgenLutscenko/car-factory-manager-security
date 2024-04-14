package ua.lutsenko.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.lutsenko.project.model.Factory;

import java.util.Optional;

public interface FactoryRepo extends JpaRepository<Factory, Long> {
    Optional<Factory> getFactoryById(Long id);
}
