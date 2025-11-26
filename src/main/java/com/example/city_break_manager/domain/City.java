package com.example.city_break_manager.domain;


import lombok.Getter;

@Getter
public class City {
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
