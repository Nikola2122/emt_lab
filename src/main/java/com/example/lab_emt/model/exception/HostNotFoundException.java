package com.example.lab_emt.model.exception;

public class HostNotFoundException extends RuntimeException {
    public HostNotFoundException(Long id) {
        super("Could not find host with id: " + id);
    }
}
