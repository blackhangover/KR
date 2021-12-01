package ru.example.shelter.model;

import javax.persistence.*;

@Entity //?????????, ??? ?????? ???????? ?????????????? ??????? ??
@Table(name = "animal") //????????? ???????? ???????
public class Animal {

    @Id //PrimaryKey
    @GeneratedValue(strategy = GenerationType.IDENTITY) //PrimaryKey ????? ?????????????? ?????????????
    private Long id;
    private String name;
    private String sex;
    private int age;
    private String breed;
    private String description;
    @Column(name = "image_url") //????????? ?????? ??? ??? ??????? ? ??, ???? ????? ?? ?????? ?? ???????? ????? ????? ? ???????? ????
    private String imageUrl;
    @Enumerated(EnumType.STRING)
    private AnimalType type;
    private boolean taken;

    public boolean isTaken() {
        return taken;
    }

    public void setTaken(boolean taken) {
        this.taken = taken;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public AnimalType getType() {
        return type;
    }

    public void setType(AnimalType type) {
        this.type = type;
    }
}
