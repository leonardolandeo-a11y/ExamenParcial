package com.example.parcialexam.exceptions;

public class AlreadyRequestedException extends RuntimeException {
    public AlreadyRequestedException(String message) {
        super(message);
    }
}
