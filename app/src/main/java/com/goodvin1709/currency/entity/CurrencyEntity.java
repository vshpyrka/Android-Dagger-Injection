package com.goodvin1709.currency.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

import com.goodvin1709.currency.network.response.CurrencyResponse;

import org.joda.time.DateTime;

@Entity(tableName = "tblCurrency")
public class CurrencyEntity {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private long id;

    @ColumnInfo(name = "date")
    private DateTime date;

    @ColumnInfo(name = "sell")
    private float sell;

    @ColumnInfo(name = "buy")
    private float buy;

    public CurrencyEntity() {

    }

    @Ignore
    public CurrencyEntity(CurrencyResponse response) {
        date = new DateTime();
        sell = response.usd.sell;
        buy = response.usd.buy;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public DateTime getDate() {
        return date;
    }

    public void setDate(final DateTime date) {
        this.date = date;
    }

    public float getSell() {
        return sell;
    }

    public void setSell(float sell) {
        this.sell = sell;
    }

    public float getBuy() {
        return buy;
    }

    public void setBuy(float buy) {
        this.buy = buy;
    }
}
