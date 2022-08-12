package com.chrislomeli.localizestore.exception;


import java.util.List;

/**
 * @author cwinso
 */
public class JsonPatchParseException extends RuntimeException {

    private List<String> invalidPaths;

    public JsonPatchParseException(String message, List<String> paths) {
        super(message);
        this.invalidPaths = paths;
    }

    public List<String> getInvalidPaths() {
        return this.invalidPaths;
    }
}
