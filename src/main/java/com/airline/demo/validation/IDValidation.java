package com.airline.demo.validation;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Class to validate reservation ID format
 */
public class IDValidation implements Validator<String> {

    @Override
    public List<String> validate(String id) {
        List<String> errors = new ArrayList<>();
        try {
            UUID.fromString(id);
        } catch (IllegalArgumentException exception) {
            errors.add("Reservation id must be a valid UUID");
        }
        return errors;
    }
}
