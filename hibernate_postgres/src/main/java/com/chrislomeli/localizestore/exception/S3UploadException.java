package com.chrislomeli.localizestore.exception;

/**
 *  Thrown when uploading a file to S3
 * Created by echase 03/08/2019
 */
public class S3UploadException extends RuntimeException {
    public S3UploadException(String message) {
        super(message);
    }
}
