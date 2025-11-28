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

//    public City updateCity(City city){
//        return cityRepository.findById(city.getId());
//    }

    public void deleteCity(City city){cityRepository.delete(city);}

    public City findCityById(int id){
        return cityRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("City not found with id " + id));
    }

    public Iterable<City> findAllCities(){
        return cityRepository.findAll();
    }

    public Trip saveTrip(Integer cityId, Date startDate, Date endDate, int rating, String personalNotes){
        City city = cityRepository.findById(cityId)
                .orElseThrow(() -> new RuntimeException("City not found with id " + cityId));

        int id = atomicInteger.incrementAndGet();
        Trip trip = new Trip(id, city, startDate, endDate, rating, personalNotes);
        return tripRepository.save(trip);
    }

//    public Trip updateTrip(Trip trip){
//        return tripRepository.findById(trip.getId());
//    }

    public void deleteTrip(Trip trip){
        tripRepository.delete(trip);
    }

    public Trip findTripById(int id){
        return tripRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Trip not found with id " + id));
    }

    public Iterable<Trip> findAllTrips(){
        return tripRepository.findAll();
    }
    
}
