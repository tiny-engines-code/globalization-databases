package com.chrislomeli.g11n.commons.v2.core.exceptions;

/**
 * Thrown when a database operation fails.
 */
public class DatastoreException extends RuntimeException {
    public DatastoreException(String message) {
        super(message);
    }

    public DatastoreException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
