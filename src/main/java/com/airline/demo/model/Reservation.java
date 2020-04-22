package com.airline.demo.model;

import org.springframework.data.annotation.Id;

import java.math.BigDecimal;

public class Reservation {

    @Id
    private String reservationId;

    private Flight flight;
    private Passenger passenger;
    private BigDecimal price;
    private boolean isLuggageAllowed;

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public boolean isLuggageAllowed() {
        return isLuggageAllowed;
    }

    public void setLuggageAllowed(boolean luggageAllowed) {
        isLuggageAllowed = luggageAllowed;
    }

    public String getReservationId() {
        return reservationId;
    }

    public void setReservationId(String reservationId) {
        this.reservationId = reservationId;
    }
}
