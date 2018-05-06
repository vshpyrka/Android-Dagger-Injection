package com.goodvin1709.bitcoin.db.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.goodvin1709.bitcoin.entity.CurrencyEntity;

@Dao
public interface CurrencyDao {

    @Query("SELECT * FROM tblCurrency ORDER BY date DESC LIMIT 1")
    LiveData<CurrencyEntity> getCurrency();

    @Insert
    void addCurrency(CurrencyEntity entity);
}
