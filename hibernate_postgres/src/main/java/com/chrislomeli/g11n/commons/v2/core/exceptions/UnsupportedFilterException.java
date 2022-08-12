package com.chrislomeli.g11n.commons.v2.core.exceptions;

/**
 * Thrown when a given request filter is unsupported.
 */
public class UnsupportedFilterException extends RuntimeException {
    public UnsupportedFilterException(String message) {
        super(message);
    }
}
