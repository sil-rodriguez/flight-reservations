package com.airline.demo.resource;

import com.airline.demo.exception.InvalidFormatException;
import com.airline.demo.model.Reservation;
import com.airline.demo.service.ReservationService;
import com.airline.demo.validation.IDValidation;
import com.airline.demo.validation.ReservationValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
public class ReservationResource {

    @Autowired
    private ReservationService reservationService;

    private ReservationValidation reservationValidator = new ReservationValidation();
    private IDValidation idValidator = new IDValidation();


    @PostMapping("/reservations")
    public Reservation makeReservation(@RequestBody Reservation reservation) {
        List<String> errors = reservationValidator.validate(reservation);
        if (errors.isEmpty()) {
            return reservationService.makeReservation(reservation);
        } else {
            throw new InvalidFormatException(String.join(";", errors));
        }
    }

    @GetMapping("/reservations/{id}")
    public Reservation findById(@PathVariable String id) {
        List<String> errors = idValidator.validate(id);
        if (errors.isEmpty()) {
            return reservationService.findById(id);
        }
        throw new InvalidFormatException(String.join(";", errors));
    }

}
