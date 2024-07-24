package com.example.demo.Entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Route {
    // Getters and Setters
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
}

