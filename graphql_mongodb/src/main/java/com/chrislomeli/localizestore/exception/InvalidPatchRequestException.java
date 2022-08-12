package com.chrislomeli.localizestore.exception;

/**
 * Exception for handling invalid patch to metaData/imageSourceURL
 *
 * @author whough
 */
public class InvalidPatchRequestException extends RuntimeException {
    public InvalidPatchRequestException(Exception causedBy) {
        super(causedBy);
    }
}
