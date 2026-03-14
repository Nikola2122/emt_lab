package com.example.lab_emt.model.exception;

public class AccommodationNotDeletableException extends RuntimeException {
    public AccommodationNotDeletableException(Long id) {
        super("Accommodation not deletable: " + id);
    }
}
