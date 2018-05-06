package com.goodvin1709.bitcoin.db.dao;

import android.arch.persistence.room.TypeConverter;

import org.joda.time.DateTime;

public class DateTypeConverter {

    private DateTypeConverter() {
        throw new IllegalStateException("DateTypeConverter is Util class.");
    }

    @TypeConverter
    public static DateTime fromTimestamp(final Long value) {
        return value == null ? null : new DateTime(value);
    }

    @TypeConverter
    public static Long dateToTimestamp(final DateTime date) {
        return date == null ? null : date.getMillis();
    }
}
