package com.example.demo.Services;

import com.example.demo.Entity.City;
import com.example.demo.Repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {
    @Autowired
    private CityRepository cityRepository;

    public List<City> findAll() {
        return cityRepository.findAll();
    }


    public City findById(Long id) {
        return cityRepository.findById(id).orElse(null);
    }

    public City save(City city) {
        return cityRepository.save(city);
    }

    public void deleteById(Long id) {
        cityRepository.deleteById(id);
    }
}
