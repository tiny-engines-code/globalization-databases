package com.chrislomeli.phylon.rest.validation.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Indicates a class can be validated using JSON Schema Validation.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface SchemaValidate {

    /**
     * The location on the classpath where the schema can be found.
     *
     * @return file
     */
    String file();
}