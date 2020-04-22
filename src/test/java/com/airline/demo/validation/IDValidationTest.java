package com.airline.demo.validation;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Test class for the reservation ID validation
 */
public class IDValidationTest {

    @Test
    public void shouldReturnEmptyWhenValidID() {
        IDValidation validation = new IDValidation();
        List<String> errors = validation.validate(UUID.randomUUID().toString());
        assertTrue(errors.isEmpty());
    }

    @Test
    public void shouldFailWhenInvalidID() {
        IDValidation validation = new IDValidation();
        List<String> errors = validation.validate("invalid id");
        assertTrue(errors.contains("Reservation id must be a valid UUID"));
    }
}
