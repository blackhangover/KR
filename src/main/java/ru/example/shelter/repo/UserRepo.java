package ru.example.shelter.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.example.shelter.model.User;

public interface UserRepo extends JpaRepository<User, Long> {

    User findByUsername(String username);

}
