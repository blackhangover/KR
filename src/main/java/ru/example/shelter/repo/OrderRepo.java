package ru.example.shelter.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.example.shelter.model.Animal;
import ru.example.shelter.model.Order;
import ru.example.shelter.model.User;

import java.util.List;

public interface OrderRepo extends JpaRepository<Order, Long> {

    List<Order> findAllByAnimalAndUser(Animal animal, User user);

}
