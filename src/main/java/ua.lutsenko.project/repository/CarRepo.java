package ua.lutsenko.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.lutsenko.project.model.Car;

import java.util.List;

public interface CarRepo extends JpaRepository<Car, Long> {

    List<Car> findAllByUserId(Long id);
}
