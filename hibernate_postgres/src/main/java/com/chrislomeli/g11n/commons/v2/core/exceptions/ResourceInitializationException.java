package com.chrislomeli.g11n.commons.v2.core.exceptions;

/**
 * Thrown when initializing a resource fails, such as retrieving secret keys for vendors from Cerberus.
 *
 * Created by msnid1 on 8/4/17.
 */
public class ResourceInitializationException extends RuntimeException {
    public ResourceInitializationException(String message) {
        super(message);
    }

    public ResourceInitializationException(String message, Exception e) {
        super(message, e);
    }
}
