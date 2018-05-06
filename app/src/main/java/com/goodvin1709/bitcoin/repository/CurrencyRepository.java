package com.goodvin1709.bitcoin.repository;

import android.arch.lifecycle.LiveData;

import com.goodvin1709.bitcoin.entity.CurrencyEntity;

import io.reactivex.Completable;

public interface CurrencyRepository {

    LiveData<CurrencyEntity> getCurrency();

    Completable addCurrency(CurrencyEntity entity);
}
