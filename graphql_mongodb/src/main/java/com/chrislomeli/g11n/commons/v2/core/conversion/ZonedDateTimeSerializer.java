package com.chrislomeli.g11n.commons.v2.core.conversion;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;

/**
 * JSON deserializer into a UTC ZonedDateTime.
 */
public class ZonedDateTimeSerializer extends JsonSerializer<ZonedDateTime> {
    private static final int FRACTIONAL_DIGITS = 3;
    private static final DateTimeFormatter FORMATTER = new DateTimeFormatterBuilder()
            .appendInstant(FRACTIONAL_DIGITS).toFormatter();
    private static final ZoneId ZONE_UTC = ZoneId.of("UTC");

    @Override
    public void serialize(ZonedDateTime zonedDateTime, JsonGenerator generator, SerializerProvider serializers)
            throws IOException {
        generator.writeString(FORMATTER.format(zonedDateTime.withZoneSameInstant(ZONE_UTC)));
    }
}
