package com.goodvin1709.currency.ui.currency;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.goodvin1709.currency.ReactiveCurrency;
import com.goodvin1709.currency.entity.CurrencyEntity;
import com.goodvin1709.currency.repository.CurrencyRepository;

import javax.inject.Inject;

public class CurrencyViewModel extends ViewModel {

    @Inject
    CurrencyRepository repository;

    private final LiveData<CurrencyEntity> currency;

    public CurrencyViewModel() {
        ReactiveCurrency.getAppComponent().inject(this);
        currency = repository.getLastCurrency();
    }

    public LiveData<CurrencyEntity> getCurrency() {
        return currency;
    }
}
