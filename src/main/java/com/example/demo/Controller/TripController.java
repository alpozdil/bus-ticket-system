package com.example.demo.Controller;

import Requests.TripRequestModel;
import com.example.demo.Entity.Trip;
import com.example.demo.Services.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/trips")
public class TripController {
    @Autowired
    private TripService tripService;

    @GetMapping
    public List<Trip> getAllTrips() {
        return tripService.findAll();
    }

    @GetMapping("/{id}")
    public Trip getTripById(@PathVariable Long id) {
        return tripService.findById(id);
    }

    @PostMapping
    public Trip createTrip(@RequestBody Trip trip) {
        return tripService.save(trip);
    }

    @PostMapping("/search")
    public List<Trip> searchTrip(@RequestBody TripRequestModel tripRequest) {
        return tripService.searchTrip(tripRequest);
    }

    @DeleteMapping("/{id}")
    public void deleteTrip(@PathVariable Long id) {
        tripService.deleteById(id);
    }
}