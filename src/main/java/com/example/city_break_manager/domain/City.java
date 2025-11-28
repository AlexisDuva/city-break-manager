package com.example.city_break_manager.domain;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;

@Getter
@Entity
public class City {
    @Id
    private final int id;
    private final String name;
    private final String country;
    private final String details;

    public City(int id, String name, String country, String details) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.details = details;
    }
}
