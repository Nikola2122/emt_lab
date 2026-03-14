package com.example.lab_emt.model.exception;

public class AccNotBookableException extends RuntimeException {
    public AccNotBookableException(Long id) {
        super("Accommodation with id " + id + " is not bookable");
    }
}
