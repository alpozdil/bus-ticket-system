package com.example.demo.Services;

import com.example.demo.Entity.Bus;
import com.example.demo.Entity.Route;
import com.example.demo.Entity.Trip;
import com.example.demo.Repository.BusRepository;
import com.example.demo.Repository.RouteRepository;
import com.example.demo.Repository.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Service
public class TripGenerationService {

    @Autowired
    private TripRepository tripRepository;

    @Autowired
    private RouteRepository routeRepository;

    @Autowired
    private BusRepository busRepository;

    private final Random random = new Random();

    @Scheduled(cron = "0 12 14 * * THU")
    public void deleteTripsForWeek() {
        LocalDate today = LocalDate.now();
        LocalDate endDate = today.plusDays(7);
        List<Trip> tripsToDelete = tripRepository.findByDepartureTimeBetween(
                LocalDateTime.of(today, LocalTime.MIN),
                LocalDateTime.of(endDate, LocalTime.MAX)
        );

        tripRepository.deleteAll(tripsToDelete);
    }

    @Scheduled(cron = "0 13 14 * * THU")
    public void generateTripsForWeek() {
        LocalDate startDate = LocalDate.now();
        LocalDate endDate = startDate.plusDays(7);

        List<Route> routes = routeRepository.findAll();
        List<Bus> buses = busRepository.findAll();

        List<LocalTime> tripTimes = Arrays.asList(
                LocalTime.of(8, 0),
                LocalTime.of(13, 0),
                LocalTime.of(18, 0)
        );

        for (LocalDate date = startDate; !date.isAfter(endDate); date = date.plusDays(1)) {
            for (Route route : routes) {
                for (LocalTime time : tripTimes) {
                    Trip trip = new Trip();
                    trip.setRoute(route);
                    trip.setDepartureTime(LocalDateTime.of(date, time));


                    if (!buses.isEmpty()) {
                        Bus randomBus = buses.get(random.nextInt(buses.size()));
                        trip.setBus(randomBus);
                    } else {
                        throw new IllegalStateException("Sefer'e atanacak otobüs bulunamadı.");
                    }

                    tripRepository.save(trip);
                }
            }
        }
    }


}
