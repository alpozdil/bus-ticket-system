package com.example.demo.Entity;
import jakarta.persistence.*;

@Entity
public class Route {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "start_city_id", nullable = false)
    private City startCity;

    @ManyToOne
    @JoinColumn(name = "end_city_id", nullable = false)
    private City endCity;

    @Column(nullable = false)
    private Float distance;

    // Getters and Setters
    // Default constructor
    public Route() {}

    // Parameterized constructor
    public Route(City startCity, City endCity, Float distance) {
        this.startCity = startCity;
        this.endCity = endCity;
        this.distance = distance;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public City getStartCity() {
        return startCity;
    }

    public void setStartCity(City startCity) {
        this.startCity = startCity;
    }

    public City getEndCity() {
        return endCity;
    }

    public void setEndCity(City endCity) {
        this.endCity = endCity;
    }

    public Float getDistance() {
        return distance;
    }

    public void setDistance(Float distance) {
        this.distance = distance;
    }
}

