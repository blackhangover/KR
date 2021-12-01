package ru.example.shelter.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "order_entity")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private Animal animal;
    @ManyToOne
    private User user;
    @Column(name = "order_date")
    private LocalDateTime orderDate;
    private boolean complete;

    public Order() {
    }

    public Order(Animal animal, User user) {
        this.animal = animal;
        this.user = user;
        this.complete = false;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }
}
