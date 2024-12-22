package com.example.demo.Repository;
import com.example.demo.Entity.Trip;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TripRepository extends JpaRepository<Trip, Long> {
    List<Trip> findByDepartureTimeBetween(LocalDateTime start, LocalDateTime end);

    @Query("SELECT t FROM Trip t WHERE t.route.startCity.name = :startCity AND t.route.endCity.name = :endCity")
    List<Trip> findByStartCityAndEndCity(@Param("startCity") String startCity, @Param("endCity") String endCity);
}

