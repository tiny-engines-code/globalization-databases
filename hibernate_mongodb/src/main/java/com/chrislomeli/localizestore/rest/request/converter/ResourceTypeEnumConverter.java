package com.chrislomeli.localizestore.rest.request.converter;

import com.chrislomeli.g11n.commons.v2.localization.core.model.enums.ResourceType;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.Locale;

/**
 * This was adapted from this Stack Overflow location: https://stackoverflow.com/a/53266048
 * It will adjust the lowercase coming from the API, to the uppercase that our enum is.
 */
@Component
public class ResourceTypeEnumConverter implements Converter<String, ResourceType> {
    @Override
    public ResourceType convert(String value) {
        try {
            return ResourceType.valueOf(value.toUpperCase(Locale.US));
        } catch (IllegalArgumentException e) {
            return ResourceType.UNKNOWN;
        }
    }
}
