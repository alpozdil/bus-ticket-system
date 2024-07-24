package com.example.demo.Services;

import Requests.TripRequestModel;
import com.example.demo.Entity.Trip;
import com.example.demo.Repository.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TripService {
    @Autowired
    private TripRepository tripRepository;

    public List<Trip> findAll() {
        return tripRepository.findAll();
    }

    public Trip findById(Long id) {
        return tripRepository.findById(id).orElse(null);
    }

    public Trip save(Trip trip) {
        return tripRepository.save(trip);
    }
    public List<Trip> searchTrip(TripRequestModel tripRequest) {
        List<Trip> trips = findAll();
        return null;
    }

    public void deleteById(Long id) {
        tripRepository.deleteById(id);
    }
}