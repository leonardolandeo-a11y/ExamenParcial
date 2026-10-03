package com.example.parcialexam.exceptions;

public class TripNotFoundException extends RuntimeException {
    public TripNotFoundException(String message) {
        super(message);
    }
}
