package com.chrislomeli.g11n.commons.v2.core.conversion;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.chrislomeli.g11n.commons.v2.core.exceptions.DeserializationException;

import java.io.IOException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeParseException;

import static com.chrislomeli.g11n.commons.v2.core.Constant.DATE_TIME_FORMATTER;

/**
 * JSON deserializer into a UTC ZonedDateTime.
 */
public class ZonedDateTimeDeserializer extends StdDeserializer<ZonedDateTime> {
    protected ZonedDateTimeDeserializer() {
        super(ZonedDateTime.class);
    }

    @Override
    public ZonedDateTime deserialize(JsonParser parser, DeserializationContext ctxt) throws IOException {
        try {
            return ZonedDateTime.from(DATE_TIME_FORMATTER.parse(parser.getText()));
        } catch (DateTimeParseException e) {
            throw new DeserializationException("Failed to deserialize date, invalid date format provided");
        }
    }
}
