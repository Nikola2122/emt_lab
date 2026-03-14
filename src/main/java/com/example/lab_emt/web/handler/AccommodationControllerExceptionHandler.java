package com.example.lab_emt.web.handler;

import com.example.lab_emt.model.exception.AccNotBookableException;
import com.example.lab_emt.model.exception.AccommodationNotDeletableException;
import com.example.lab_emt.model.exception.HostNotFoundException;
import com.example.lab_emt.web.controller.AccommodationController;
import com.example.lab_emt.web.dto.ApiError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(assignableTypes = AccommodationController.class)
public class AccommodationControllerExceptionHandler {

    @ExceptionHandler(HostNotFoundException.class)
    public ResponseEntity<ApiError> handleNotFound(HostNotFoundException exception) {
        return ResponseEntity
            .status(HttpStatus.NOT_FOUND)
            .body(ApiError.of(HttpStatus.NOT_FOUND, exception.getMessage()));
    }

    @ExceptionHandler(AccommodationNotDeletableException.class)
    public ResponseEntity<ApiError> handleCantDelete(AccommodationNotDeletableException exception) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(ApiError.of(HttpStatus.BAD_REQUEST, exception.getMessage()));
    }

    @ExceptionHandler(AccNotBookableException.class)
    public ResponseEntity<ApiError> handleNotBookable(AccNotBookableException exception) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(ApiError.of(HttpStatus.BAD_REQUEST, exception.getMessage()));
    }
}
