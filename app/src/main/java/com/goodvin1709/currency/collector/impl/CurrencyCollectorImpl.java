package com.goodvin1709.currency.collector.impl;

import com.goodvin1709.currency.collector.CurrencyCollector;
import com.goodvin1709.currency.entity.CurrencyEntity;
import com.goodvin1709.currency.network.ApiService;
import com.goodvin1709.currency.repository.CurrencyRepository;

import java.util.concurrent.TimeUnit;

import io.reactivex.Completable;
import io.reactivex.Observable;

public class CurrencyCollectorImpl implements CurrencyCollector {

    private static final int UPDATE_TIME_MS = 5000;
    private final CurrencyRepository repository;
    private final ApiService service;

    public CurrencyCollectorImpl(final CurrencyRepository repository,
                          final ApiService service) {
        this.repository = repository;
        this.service = service;
    }

    @Override
    public Completable start() {
        return Observable.interval(UPDATE_TIME_MS, TimeUnit.MILLISECONDS)
                .flatMap(tick -> service.getCurrency().toObservable())
                .distinctUntilChanged()
                .map(CurrencyEntity::new)
                .flatMapCompletable(repository::addCurrency)
                .retry();
    }
}
