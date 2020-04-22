package com.airline.demo.validation;

import com.airline.demo.model.Reservation;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ReservationValidation implements Validator<Reservation> {

    public List<String> validate(Reservation reservation){
        List<String> errors = new ArrayList<>();
        if(reservation.getPrice() == null
                || reservation.getPrice().compareTo(BigDecimal.ZERO) <= 0){
            errors.add("Reservation price must be greater than 0");
        }
        if(reservation.getFlight() == null
                || reservation.getFlight().getOrigin() == null){
            errors.add("Reservation must contain a valid origin");
        }
        if(reservation.getFlight() == null
            || reservation.getFlight().getDestination() == null){
            errors.add("Reservation must contain a valid destination");
        }
        return errors;
    }
}
