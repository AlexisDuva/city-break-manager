package com.example.city_break_manager.repository;

import com.example.city_break_manager.domain.City;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class CityRepository {
    private Map<Integer, City> cities;

    public CityRepository(Map<Integer, City> cities) {
        this.cities = cities;
    }

    public City save(City city){
        cities.put(city.getId(),city);
        return city;
    }

    public City update(City city){
        if (this.cities.containsKey(city.getId())){
            this.cities.put(city.getId(),city);
        }
        return city;
    }

    public void delete(int id){
        this.cities.remove(id);
    }

    public City findById(int id){
        return cities.get(id);
    }

    public Iterable<City> findAll(){
        return cities.values();
    }
}
