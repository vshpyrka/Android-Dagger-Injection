package com.goodvin1709.bitcoin.utils;


import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class DateUtils {

    static private final DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");

    private DateUtils() {
        throw new IllegalStateException("DateUtils is Util class.");
    }

    public static String formatDate(final DateTime date) {
        if (date != null) {
            return date.toString(formatter);
        }
        return null;
    }
}
