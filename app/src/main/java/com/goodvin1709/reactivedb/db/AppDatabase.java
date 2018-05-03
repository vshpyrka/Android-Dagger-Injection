package com.goodvin1709.reactivedb.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;

import com.mobichord.db.dao.AccountDAO;
import com.mobichord.db.dao.ConnectionInfoDAO;
import com.mobichord.db.dao.DataUsageDAO;
import com.mobichord.db.dao.DebugDAO;
import com.mobichord.db.dao.FeaturesDAO;
import com.mobichord.db.dao.LocationDAO;
import com.mobichord.db.dao.PlansDAO;
import com.mobichord.db.dao.RequestsDAO;
import com.mobichord.db.dao.RoamingFeaturesDAO;
import com.mobichord.db.dao.SimCardsDAO;
import com.mobichord.entity.AccountEntity;
import com.mobichord.entity.ConnectionInfoEntity;
import com.mobichord.entity.DataUsageEntity;
import com.mobichord.entity.FeatureEntity;
import com.mobichord.entity.FeatureLimitEntity;
import com.mobichord.entity.LocationInfoEntity;
import com.mobichord.entity.PlanEntity;
import com.mobichord.entity.PlansLimitEntity;
import com.mobichord.entity.RequestEntity;
import com.mobichord.entity.RoamingFeatureEntity;
import com.mobichord.entity.RoamingFeatureLimitEntity;
import com.mobichord.entity.SimCardEntity;

@Database(version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    public static final String DATABASE_NAME = "app_database.db";
}
