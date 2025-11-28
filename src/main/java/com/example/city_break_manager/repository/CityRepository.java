package com.example.city_break_manager.repository;

import com.example.city_break_manager.domain.City;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface CityRepository extends CrudRepository<City, Integer> {
}
