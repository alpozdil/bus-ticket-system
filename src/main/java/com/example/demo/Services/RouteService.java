package com.example.demo.Services;

import com.example.demo.Entity.Route;
import com.example.demo.Repository.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RouteService {
    @Autowired
    private RouteRepository routeRepository;

    @Cacheable(value = "routes")
    public List<Route> findAll() {
        return routeRepository.findAll();
    }

    @Cacheable(value = "route", key = "#id")
    public Route findById(Long id) {
        return routeRepository.findById(id).orElse(null);
    }

    @CachePut(value = "route", key = "#route.id")
    public Route save(Route route) {
        return routeRepository.save(route);
    }

    @CacheEvict(value = "route", key = "#id")
    public void deleteById(Long id) {
        routeRepository.deleteById(id);
    }
}
