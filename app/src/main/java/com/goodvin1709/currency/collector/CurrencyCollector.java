package com.goodvin1709.currency.collector;


import io.reactivex.Completable;

@FunctionalInterface
public interface CurrencyCollector {

    Completable start();
}
