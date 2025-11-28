package com.example.city_break_manager.repository;

import com.example.city_break_manager.domain.Trip;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface TripRepository extends CrudRepository<Trip,Integer> {
}
