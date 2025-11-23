package com.pm.patientservice.exception;

public class PersonWasNotFoundException extends RuntimeException {
    public PersonWasNotFoundException(String message) {
        super(message);
    }
}
