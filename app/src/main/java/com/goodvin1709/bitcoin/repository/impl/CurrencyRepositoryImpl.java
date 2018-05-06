package com.goodvin1709.bitcoin.repository.impl;

import android.arch.lifecycle.LiveData;

import com.goodvin1709.bitcoin.db.AppDatabase;
import com.goodvin1709.bitcoin.entity.CurrencyEntity;
import com.goodvin1709.bitcoin.repository.CurrencyRepository;

import javax.inject.Inject;

import io.reactivex.Completable;

public class CurrencyRepositoryImpl implements CurrencyRepository {

    private final AppDatabase database;

    @Inject
    CurrencyRepositoryImpl(final AppDatabase database) {
        this.database = database;
    }

    @Override
    public LiveData<CurrencyEntity> getCurrency() {
        return database.getCurrencyDao().getCurrency();
    }

    @Override
    public Completable addCurrency(final CurrencyEntity entity) {
        return Completable.create(emitter -> database.getCurrencyDao().addCurrency(entity));
    }
}
