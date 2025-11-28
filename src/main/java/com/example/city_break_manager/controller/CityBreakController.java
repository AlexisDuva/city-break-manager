package com.example.city_break_manager.controller;


import com.example.city_break_manager.domain.City;
import com.example.city_break_manager.domain.Trip;
import com.example.city_break_manager.service.CityBreakService;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/api")
public class CityBreakController {

    private final CityBreakService cityBreakService;

    public CityBreakController(CityBreakService cityBreakService) {
        this.cityBreakService = cityBreakService;
    }

// ----------- City Endpoints ------------

    @PostMapping("/cities")
    public City createCity(@RequestParam String name, @RequestParam String country, @RequestParam String details) {
        return cityBreakService.saveCity(name, country, details);
    }

    @GetMapping("/cities/{id}")
    public City getCity(@PathVariable int id) {
        return cityBreakService.findCityById(id);
    }

    @GetMapping("/cities")
    public Iterable<City> getAllCities() {
        return cityBreakService.findAllCities();
    }

//    @PutMapping("/cities")
//    public City updateCity(@RequestBody City city) {
//        return cityBreakService.updateCity(city);
//    }

    @DeleteMapping("/cities/{id}")
    public void deleteCity(@RequestBody City city) {
        cityBreakService.deleteCity(city);
    }


// ----------- Trip Endpoints ------------

    @PostMapping("/trips")
    public Trip createTrip(@RequestParam Integer cityId, @RequestParam Date startDate, @RequestParam Date endDate, @RequestParam int rating, @RequestParam String personalNotes) {
        return cityBreakService.saveTrip(cityId, startDate, endDate, rating, personalNotes);
    }

    @GetMapping("/trips/{id}")
    public Trip getTrip(@PathVariable int id) {
        return cityBreakService.findTripById(id);
    }

    @GetMapping("/trips")
    public Iterable<Trip> getAllTrips() {
        return cityBreakService.findAllTrips();
    }

//    @PutMapping("/trips")
//    public Trip updateTrip(@RequestBody Trip trip) {
//        return cityBreakService.updateTrip(trip);
//    }

    @DeleteMapping("/trips/{id}")
    public void deleteTrip(@RequestBody Trip trip) {
        cityBreakService.deleteTrip(trip);
    }

}
