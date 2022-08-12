package com.chrislomeli.g11n.commons.v2.core.exceptions;

public class GenericApplicationException extends RuntimeException {
    public GenericApplicationException(String message, Throwable cause) {
        super(message, cause);
    }

    public GenericApplicationException(String message) {
        super(message);
    }

    public GenericApplicationException(Exception exception) {
        super(exception);
    }
}
