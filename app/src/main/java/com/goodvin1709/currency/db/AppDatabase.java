package com.goodvin1709.currency.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;

import com.goodvin1709.currency.db.dao.CurrencyDao;
import com.goodvin1709.currency.db.dao.DateTypeConverter;
import com.goodvin1709.currency.entity.CurrencyEntity;

@Database(entities = {
        CurrencyEntity.class},
        version = 1,
        exportSchema = false)
@TypeConverters({DateTypeConverter.class})
public abstract class AppDatabase extends RoomDatabase {

    public static final String DATABASE_NAME = "app_database.db";

    public abstract CurrencyDao getCurrencyDao();
}
