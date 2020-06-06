package org.example.alvin.util;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeUtils {

    private static final String DATE_TIME_SECOND_PATTERN = "yyyy-MM-dd HH:mm:ss";

    private DateTimeUtils() {}

    public static String safeToDateTimeString(final OffsetDateTime offsetDateTime) {
        String convertResult = "";
        if (offsetDateTime != null) {
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(DATE_TIME_SECOND_PATTERN);
            convertResult = dateTimeFormatter.format(offsetDateTime);
        }
        return convertResult;
    }
}
