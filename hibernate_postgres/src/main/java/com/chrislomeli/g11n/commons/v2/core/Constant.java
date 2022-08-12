package com.chrislomeli.g11n.commons.v2.core;

import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

/**
 * Constants for the localization cloud services.
 *
 * @author eadjei
 */
public final class Constant {
    private Constant() {
    }

    // Date time
    public static final ZoneId UTC_ZONE_ID = ZoneId.of("UTC");
    public static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ISO_INSTANT
            .withZone(Constant.UTC_ZONE_ID);

    // Content types
    public static final String CONTENT_TYPE_XLIFF = "mylocalize/xliff2+xml";
    public static final String CONTENT_TYPE_JSON = "mylocalize/json; charset=UTF-8";

    // MDC keys
    public static final String MDC_RETRY_KEY = "retryCount";
}
