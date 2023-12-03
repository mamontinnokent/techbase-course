package ru.security.demo.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.security.demo.demo.domain.user.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByEmail(String email);
}
