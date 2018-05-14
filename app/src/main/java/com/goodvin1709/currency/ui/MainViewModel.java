package com.goodvin1709.currency.ui;

import android.arch.lifecycle.ViewModel;

import com.goodvin1709.currency.ReactiveCurrency;
import com.goodvin1709.currency.collector.CurrencyCollector;

import io.reactivex.disposables.Disposable;

public class MainViewModel extends ViewModel {

    private final CurrencyCollector collector;
    private Disposable disposable;

    public MainViewModel() {
        this.collector = ReactiveCurrency.getAppProvider().getCurrencyCollector();
    }

    public void startCollecting() {
        disposable = collector.start().subscribe();
    }

    public void stopCollecting() {
        disposable.dispose();
    }
}
