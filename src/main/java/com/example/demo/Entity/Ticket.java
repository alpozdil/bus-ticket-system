package com.example.demo.Entity;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.security.Timestamp;

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

    @Column(nullable = false, unique = true)
    private String pnr;

    @Column(nullable = false)
    private BigDecimal pricePaid;

    @Column(nullable = false)
    private Timestamp bookingTime;

    // getters and setters
    // Default constructor
    public Ticket() {}

    // Parameterized constructor
    public Ticket(Trip trip, Seat seat, Customer customer, String pnr, BigDecimal pricePaid, Timestamp bookingTime) {
        this.trip = trip;
        this.seat = seat;
        this.customer = customer;
        this.pnr = pnr;
        this.pricePaid = pricePaid;
        this.bookingTime = bookingTime;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Trip getTrip() {
        return trip;
    }

    public void setTrip(Trip trip) {
        this.trip = trip;
    }

    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getPnr() {
        return pnr;
    }

    public void setPnr(String pnr) {
        this.pnr = pnr;
    }

    public BigDecimal getPricePaid() {
        return pricePaid;
    }

    public void setPricePaid(BigDecimal pricePaid) {
        this.pricePaid = pricePaid;
    }

    public Timestamp getBookingTime() {
        return bookingTime;
    }

    public void setBookingTime(Timestamp bookingTime) {
        this.bookingTime = bookingTime;
    }
}
