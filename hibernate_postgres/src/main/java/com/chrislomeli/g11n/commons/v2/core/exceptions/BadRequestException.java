package com.chrislomeli.g11n.commons.v2.core.exceptions;

/**
 * Thrown when a bad request is made.
 */
public class BadRequestException extends RuntimeException {
    public BadRequestException(String message) {
        super(message);
    }
}
