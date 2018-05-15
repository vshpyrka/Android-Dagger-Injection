package com.goodvin1709.currency.ui;

import android.arch.lifecycle.ViewModel;

import com.goodvin1709.currency.ReactiveCurrency;
import com.goodvin1709.currency.collector.CurrencyCollector;

import javax.inject.Inject;

import io.reactivex.disposables.Disposable;

public class MainViewModel extends ViewModel {

    @Inject
    CurrencyCollector collector;

    private Disposable disposable;

    public MainViewModel() {
        ReactiveCurrency.getAppComponent().inject(this);
    }

    public void startCollecting() {
        disposable = collector.start().subscribe();
    }

    public void stopCollecting() {
        disposable.dispose();
    }
}
