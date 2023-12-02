package ru.security.demo.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.security.demo.demo.domain.user.entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

  Optional<User> findByEmail(String email);

}
