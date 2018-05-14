package com.goodvin1709.currency.repository;

import android.arch.lifecycle.LiveData;

import com.goodvin1709.currency.entity.CurrencyEntity;

import java.util.List;

import io.reactivex.Completable;

public interface CurrencyRepository {

    LiveData<CurrencyEntity> getLastCurrency();

    LiveData<List<CurrencyEntity>> getAllCurrencies();

    Completable addCurrency(CurrencyEntity entity);
}
