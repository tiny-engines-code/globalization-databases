package com.chrislomeli.localizestore.exception;

public class PublishFailedException extends RuntimeException {
    private static final long serialVersionUID = -2782083399850103337L;

    public PublishFailedException(String s) {
        super(s);
    }
}
