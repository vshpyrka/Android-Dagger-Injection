package com.goodvin1709.currency.repository.impl;

import android.arch.lifecycle.LiveData;

import com.goodvin1709.currency.db.AppDatabase;
import com.goodvin1709.currency.entity.CurrencyEntity;
import com.goodvin1709.currency.repository.CurrencyRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Completable;

public class CurrencyRepositoryImpl implements CurrencyRepository {

    private final AppDatabase database;

    @Inject
    CurrencyRepositoryImpl(final AppDatabase database) {
        this.database = database;
    }

    @Override
    public LiveData<CurrencyEntity> getLastCurrency() {
        return database.getCurrencyDao().getCurrency();
    }

    @Override
    public LiveData<List<CurrencyEntity>> getAllCurrencies() {
        return database.getCurrencyDao().getAllCurrencies();
    }

    @Override
    public Completable addCurrency(final CurrencyEntity entity) {
        return Completable.create(emitter -> database.getCurrencyDao().addCurrency(entity));
    }
}
