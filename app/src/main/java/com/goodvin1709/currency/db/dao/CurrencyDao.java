package com.goodvin1709.currency.db.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.goodvin1709.currency.entity.CurrencyEntity;

import java.util.List;

@Dao
public interface CurrencyDao {

    @Query("SELECT * FROM tblCurrency ORDER BY date DESC LIMIT 1")
    LiveData<CurrencyEntity> getCurrency();

    @Insert
    void addCurrency(CurrencyEntity entity);

    @Query("SELECT * FROM tblCurrency ORDER BY date")
    LiveData<List<CurrencyEntity>> getAllCurrencies();
}
