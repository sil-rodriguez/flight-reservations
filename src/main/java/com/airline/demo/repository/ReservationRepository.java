package com.airline.demo.repository;

import com.airline.demo.model.Reservation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends MongoRepository<Reservation, String> {

    Reservation save(Reservation reservation);

    Reservation findByReservationId(String reservationId);
}