package dev.codeio.helloworld.repository;

import dev.codeio.helloworld.Models.Todo;
import dev.codeio.helloworld.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ToDoRepository extends JpaRepository<Todo, Long> {
    Optional<User> findByEmail(String email);
}
