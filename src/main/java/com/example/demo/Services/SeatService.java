package com.example.demo.Services;

import com.example.demo.Entity.Seat;
import com.example.demo.Repository.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeatService {
    @Autowired
    private SeatRepository seatRepository;

    public List<Seat> findAll() {
        return seatRepository.findAll();
    }

    public Seat findById(Long id) {
        return seatRepository.findById(id).orElse(null);
    }

    public Seat save(Seat seat) {
        return seatRepository.save(seat);
    }

    public void deleteById(Long id) {
        seatRepository.deleteById(id);
    }
}