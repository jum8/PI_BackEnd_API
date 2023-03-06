package com.grupo6.apigestionreservas.util;

public class NotFoundException extends RuntimeException {
    public NotFoundException() {
    }
    public NotFoundException(String message) {
        super(message);
    }
}
