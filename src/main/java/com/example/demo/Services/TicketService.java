package com.example.demo.Services;

import com.example.demo.Entity.Customer;
import com.example.demo.Entity.Seat;
import com.example.demo.Entity.Ticket;
import com.example.demo.Entity.Trip;
import com.example.demo.Repository.CustomerRepository;
import com.example.demo.Repository.SeatRepository;
import com.example.demo.Repository.TicketRepository;
import com.example.demo.Repository.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
public class TicketService {
    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private TripRepository tripRepository;

    @Autowired
    private SeatRepository seatRepository;

    @Autowired
    private CustomerRepository customerRepository;

    public List<Ticket> findAll() {
        return ticketRepository.findAll();
    }

    public Ticket findById(Long id) {
        return ticketRepository.findById(id).orElse(null);
    }

    public Ticket save(Ticket ticket) {
        // İlgili trip, seat ve customer bilgilerini yükle
        Trip trip = tripRepository.findById(ticket.getTrip().getId()).orElseThrow();
        Seat seat = seatRepository.findById(ticket.getSeat().getId()).orElseThrow();
        Customer customer = customerRepository.findById(ticket.getCustomer().getId()).orElseThrow();

        // Ticket nesnesine ilişkili entity'leri ekle
        ticket.setTrip(trip);
        ticket.setSeat(seat);
        ticket.setCustomer(customer);

        return ticketRepository.save(ticket);
    }

    public void deleteById(Long id) {
        ticketRepository.deleteById(id);
    }
}
