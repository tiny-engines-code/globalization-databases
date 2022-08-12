package com.chrislomeli.g11n.commons.v2.core.exceptions;

/**
 * Localization cloud error codes.
 */
public enum ErrorCodes {

    INTERNAL_ERROR,
    INTERNAL_SERVER_ERROR, // for lack of a better alternative, maintaining backwards compatibility
    VALIDATION_ERROR,
    RESOURCE_NOT_FOUND,
    RESOURCE_ALREADY_EXISTS,
    DATASTORE_ERROR,
    DEPENDENT_RESOURCE_NOT_FOUND,
    DATE_VALIDATION_ERROR,
    FIELD_VALIDATION_ERROR,
    UNSUPPORTED_REQUEST_FILTER_ERROR,
    INVALID_REQUEST_FILTER_ERROR,
    ACCESS_DENIED,
    BAD_REQUEST;

    public String getValue() {
        return String.valueOf(this.ordinal());
    }
}
