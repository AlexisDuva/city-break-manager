package com.example.city_break_manager.repository;

import com.example.city_break_manager.domain.Trip;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class TripRepository {
    private Map<Integer, Trip> trips;

    public Trip save(Trip trip){
        trips.put(trip.getId(),trip);
        return trip;
    }

    public Trip update(Trip trip){
        if (this.trips.containsKey(trip.getId())){
            this.trips.put(trip.getId(),trip);
        }
        return trip;
    }

    public void delete(int tripId){
        this.trips.remove(tripId);
    }

    public Trip findById(int id){
        return trips.get(id);
    }

    public Iterable<Trip> findAll(){
        return trips.values();
    }
}
