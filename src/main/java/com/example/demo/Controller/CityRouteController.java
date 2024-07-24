package com.example.demo.Controller;

import com.example.demo.Entity.City;
import com.example.demo.Entity.Route;
import com.example.demo.Repository.CityRepository;
import com.example.demo.Repository.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class CityRouteController {

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private RouteRepository routeRepository;

    @GetMapping("/routes/destinations/{startCityId}")
    public List<City> getDestinations(@PathVariable long startCityId) {
        List<Route> routes = routeRepository.findByStartCityId(startCityId);
        return routes.stream()
                .map(Route::getEndCity)
                .collect(Collectors.toList());
    }
}
