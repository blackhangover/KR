package ru.example.shelter.service;

import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.example.shelter.model.Animal;
import ru.example.shelter.model.Order;
import ru.example.shelter.model.User;
import ru.example.shelter.repo.OrderRepo;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepo orderRepo;
    @Autowired
    private AnimalService animalService;
    @Autowired
    private UserService userService;

    public void order(Long userId, Long animalId) { //????????? ?????? ? ????????? ?? ? ??
        Animal animal = animalService.getById(animalId);
        User user = userService.getById(userId);

        if (!orderRepo.findAllByAnimalAndUser(animal, user).isEmpty()) { //???? ??? ?????????? ?????? ? ????? ????????? ? ????? ???????? ?? ?????? ?? ??????
            return;
        }
        
        Order order = new Order(animal, user);
        order.setOrderDate(LocalDateTime.now());

        orderRepo.save(order);
    }

    public void completeOrder(Long id) { //????????????? ?????? "????????" ??? ??????
        orderRepo.findById(id).ifPresent(order -> {
            order.setComplete(true);
            orderRepo.save(order);
        });
    }

    public void delete(Long id) {
        orderRepo.findById(id).ifPresent(orderRepo::delete);
    }

    public Order getById(Long id) {
        return orderRepo.getById(id);
    }

    public List<Order> getOrders() {
        return orderRepo.findAll();
    }

}
