package com.airline.demo.service;

import com.airline.demo.exception.ReservationNotFoundException;
import com.airline.demo.model.Reservation;
import com.airline.demo.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    public Reservation makeReservation(Reservation reservation) {
        reservation.setReservationId(UUID.randomUUID().toString());
        reservationRepository.save(reservation);
        return reservation;
    }

    public Reservation findById(String id) {
        Optional<Reservation> reservation = reservationRepository.findById(id);
        if (reservation.isPresent()) {
            return reservation.get();
        }
        throw  new ReservationNotFoundException("No reservation found for id: " + id);
    }
}