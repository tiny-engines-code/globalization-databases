package com.chrislomeli.g11n.commons.v2.core.exceptions;

/**
 * Any internal server error.
 */
public class InternalErrorException extends GenericApplicationException {
    public InternalErrorException(String message) {
        super(message);
    }

    public InternalErrorException(String message, Throwable cause) {
        super(message, cause);
    }
}
