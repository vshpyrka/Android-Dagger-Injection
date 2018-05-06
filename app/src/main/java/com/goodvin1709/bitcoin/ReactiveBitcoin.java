package com.goodvin1709.bitcoin;

import com.goodvin1709.bitcoin.collector.CurrencyCollector;
import com.goodvin1709.bitcoin.di.DaggerAppComponent;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.support.DaggerApplication;

public class ReactiveBitcoin extends DaggerApplication {

    @Inject
    CurrencyCollector collector;

    @Override
    public void onCreate() {
        super.onCreate();
        collector.start();
    }

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        return DaggerAppComponent.builder().application(this).build();
    }
}
