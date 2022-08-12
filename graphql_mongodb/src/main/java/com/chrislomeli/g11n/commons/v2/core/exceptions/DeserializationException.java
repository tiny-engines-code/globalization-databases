package com.chrislomeli.g11n.commons.v2.core.exceptions;

/**
 * Custom exception thrown during deserialization.
 */
public class DeserializationException extends RuntimeException {

    public DeserializationException(String message) {
        super(message);
    }
}
