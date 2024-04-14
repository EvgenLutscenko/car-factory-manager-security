package ua.lutsenko.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.lutsenko.project.model.User;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Long> {
    Optional<User> getUserById(Long id);

    Optional<User> findByUsername(String username);

}
