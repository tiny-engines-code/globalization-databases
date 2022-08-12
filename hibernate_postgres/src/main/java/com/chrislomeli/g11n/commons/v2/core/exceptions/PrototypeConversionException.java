package com.chrislomeli.g11n.commons.v2.core.exceptions;

/**
 * Thrown when a parsing error encountered from raw file to translation prototype
 *
 * @author rbro56
 */
public class PrototypeConversionException extends RuntimeException {
    public PrototypeConversionException(String message) {
        super(message);
    }

    public PrototypeConversionException(String message, Throwable cause) {
        super(message, cause);
    }
}
