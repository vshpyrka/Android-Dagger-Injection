package com.goodvin1709.bitcoin.collector.impl;

import com.goodvin1709.bitcoin.collector.CurrencyCollector;
import com.goodvin1709.bitcoin.entity.CurrencyEntity;
import com.goodvin1709.bitcoin.network.ApiService;
import com.goodvin1709.bitcoin.repository.CurrencyRepository;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import io.reactivex.Observable;

public class CurrencyCollectorImpl implements CurrencyCollector {

    private static final int UPDATE_TIME_MS = 5000;
    private final CurrencyRepository repository;
    private final ApiService service;

    @Inject
    CurrencyCollectorImpl(final CurrencyRepository repository,
                          final ApiService service) {
        this.repository = repository;
        this.service = service;
    }

    @Override
    public void start() {
        Observable.interval(UPDATE_TIME_MS, TimeUnit.MILLISECONDS)
                .flatMap(tick -> service.getCurrency().toObservable())
                .distinctUntilChanged()
                .map(CurrencyEntity::new)
                .flatMapCompletable(repository::addCurrency)
                .retry()
                .subscribe();
    }
}
