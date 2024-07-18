package com.example.demo.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.security.Timestamp;
import java.util.Date;

@Setter
@Getter
@Entity
public class Payment {
    // Getters and Setters
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ticket_id", nullable = false)
    private Ticket ticket;

    @Column(nullable = false)
    private String creditCardNumber;

    @Column(nullable = false)
    private String creditCardExpiry;

    @Column(nullable = false)
    private String creditCardCvv;

    @Column(nullable = false)
    private Date paymentTime;

    // getters and setters
    // Default constructor
    public Payment() {}

    // Parameterized constructor
    public Payment(Ticket ticket, String creditCardNumber, String creditCardExpiry, String creditCardCvv, Date paymentTime) {
        this.ticket = ticket;
        this.creditCardNumber = creditCardNumber;
        this.creditCardExpiry = creditCardExpiry;
        this.creditCardCvv = creditCardCvv;
        this.paymentTime = paymentTime;
    }

}
