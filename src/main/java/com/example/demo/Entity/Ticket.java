package com.example.demo.Entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Setter
@Getter
@Entity
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "trip_id", nullable = false)
    private Trip trip;

    @ManyToOne
    @JoinColumn(name = "seat_id", nullable = false)
    private Seat seat;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @Column(nullable = true, unique = true)
    private String pnr;

    @Column(nullable = false)
    private BigDecimal pricePaid;

    @Column(nullable = false)

    private LocalDateTime bookingTime;

    @PrePersist
    protected void onCreate() {
        this.pnr = UUID.randomUUID().toString();
        this.bookingTime = LocalDateTime.now();
    }


    public Ticket() {
        this.pnr = UUID.randomUUID().toString();
        this.bookingTime = LocalDateTime.now();

    }



}