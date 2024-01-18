package com.example.responsebuilder.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.List;

@Entity
public class Prueba {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private int age;

    public Prueba(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Prueba() {}

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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
