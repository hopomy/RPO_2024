package ru.iu3.backend.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.iu3.backend.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByToken(String token);
    Optional<User> findByLogin(String login);
}
