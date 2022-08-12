package com.chrislomeli.localizestore.exception;

//import com.chrislomeli.phylon.rest.ErrorCode;

public enum ErrorCodeImpl  {

    DUPLICATE_FIELD_REQUEST_ERROR(null),
    TARGET_LANGUAGES_CONTAIN_SOURCE("Target language list contains the source language"),
    INVALID_TARGET_LANGUAGES("The list of target languages is invalid.");

    private String message;

    ErrorCodeImpl(String message) {
        this.message = message;
    }

    public String getValue() {
        return String.valueOf(this.ordinal());
    }


    public String getCode() {
        return this.name();
    }

    public String getMessage() {
        return message;
    }
}
