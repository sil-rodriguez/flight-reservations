package com.airline.demo.validation;

import com.airline.demo.model.Flight;
import com.airline.demo.model.Reservation;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Test class for the reservation validation
 */
public class TransactionValidationTest {

    @Test
    public void shouldReturnEmptyWhenValidReservation() {
        ReservationValidation validation = new ReservationValidation();
        Reservation reservation = new Reservation();
        reservation.setPrice(BigDecimal.ONE);
        Flight flight = new Flight();
        flight.setOrigin("BUE");
        flight.setDestination("COR");
        reservation.setFlight(flight);
        List<String> errors = validation.validate(reservation);
        assertTrue(errors.isEmpty());
    }

    @Test
    public void shouldFailWhenReservationDoesNotContainADestination() {
        ReservationValidation validation = new ReservationValidation();
        Reservation reservation = new Reservation();
        List<String> errors = validation.validate(reservation);
        assertTrue(errors.contains("Reservation must contain a valid destination"));
    }

    @Test
    public void shouldFailWhenReservationPriceIsZero() {
        ReservationValidation validation = new ReservationValidation();
        Reservation reservation = new Reservation();
        reservation.setPrice(BigDecimal.ZERO);
        List<String> errors = validation.validate(reservation);
        assertTrue(errors.contains("Reservation price must be greater than 0"));
    }

    @Test
    public void shouldFailWhenReservationPriceIsNegative() {
        ReservationValidation validation = new ReservationValidation();
        Reservation reservation = new Reservation();
        reservation.setPrice(BigDecimal.valueOf(-1.0));
        List<String> errors = validation.validate(reservation);
        assertTrue(errors.contains("Reservation price must be greater than 0"));
    }
}
