package com.chrislomeli.g11n.commons.v2.core.exceptions;

/**
 * Thrown when a requested resource was not found.
 */
public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
