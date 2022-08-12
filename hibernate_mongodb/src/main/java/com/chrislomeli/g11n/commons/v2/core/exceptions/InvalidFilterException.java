package com.chrislomeli.g11n.commons.v2.core.exceptions;

/**
 * Thrown in the case of invalid or unsupported request filter.
 */
public class InvalidFilterException extends RuntimeException {
    public InvalidFilterException(String message) {
        super(message);
    }
}
