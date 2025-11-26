package com.example.city_break_manager.service;

import com.example.city_break_manager.domain.City;
import com.example.city_break_manager.domain.Trip;
import com.example.city_break_manager.repository.CityRepository;
import com.example.city_break_manager.repository.TripRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class CityBreakService {

    private CityRepository cityRepository;
    private TripRepository tripRepository;
    private AtomicInteger atomicInteger = new AtomicInteger();

    public CityBreakService(CityRepository cityRepository, TripRepository tripRepository) {
        this.cityRepository = cityRepository;
        this.tripRepository = tripRepository;
    }

    public City saveCity(String name, String country, String details){
        int id = atomicInteger.incrementAndGet();
        City city = new City(id, name, country, details);
        return cityRepository.save(city);
    }

    public City updateCity(City city){
        return cityRepository.findById(city.getId());
    }

    public void deleteCity(int id){
        cityRepository.delete(id);
    }

    public City findCityById(int id){
        return cityRepository.findById(id);
    }

    public Iterable<City> findAllCities(){
        return cityRepository.findAll();
    }

    public Trip saveTrip(Integer cityId, Date StartDate, Date endDate,int rating, String personalNotes){
        City city = cityRepository.findById(cityId);
        int id = atomicInteger.incrementAndGet();
        Trip trip = new Trip(id, city, StartDate,  endDate, rating,  personalNotes);
        return tripRepository.save(trip);
    }

    public Trip updateTrip(Trip trip){
        return tripRepository.findById(trip.getId());
    }

    public void deleteTrip(int id){
        tripRepository.delete(id);
    }

    public Trip findTripById(int id){
        return tripRepository.findById(id);
    }

    public Iterable<Trip> findAllTrips(){
        return tripRepository.findAll();
    }
    
}
