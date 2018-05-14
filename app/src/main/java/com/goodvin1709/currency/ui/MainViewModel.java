package com.goodvin1709.currency.ui;

import android.arch.lifecycle.ViewModel;

import com.goodvin1709.currency.collector.CurrencyCollector;

import javax.inject.Inject;

import io.reactivex.disposables.Disposable;

public class MainViewModel extends ViewModel {

    private final CurrencyCollector collector;
    private Disposable disposable;

    @Inject
    MainViewModel(final CurrencyCollector collector) {
        this.collector = collector;
    }

    public void startCollecting() {
        disposable = collector.start().subscribe();
    }

    public void stopCollecting() {
        disposable.dispose();
    }
}
