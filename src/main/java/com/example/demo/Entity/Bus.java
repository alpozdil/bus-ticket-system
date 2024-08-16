package com.example.demo.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Bus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Integer capacity;

    @Column(nullable = false)
    private String departure_platform;

    @Setter
    @Column(nullable = false)
    private String features;

    // Default constructor
    public Bus() {}

    // Parameterized constructor
    public Bus(Integer capacity, String departure_platform, String features) {
        this.capacity = capacity;
        this.departure_platform = departure_platform;
        this.features = features;
    }
}
