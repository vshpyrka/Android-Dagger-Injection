package com.goodvin1709.currency.ui.currency;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.goodvin1709.currency.ReactiveCurrency;
import com.goodvin1709.currency.entity.CurrencyEntity;
import com.goodvin1709.currency.repository.CurrencyRepository;

public class CurrencyViewModel extends ViewModel {

    private final LiveData<CurrencyEntity> currency;
    private final CurrencyRepository repository;

    public CurrencyViewModel() {
        repository = ReactiveCurrency.getAppProvider().getCurrencyRepository();
        currency = repository.getLastCurrency();
    }

    public LiveData<CurrencyEntity> getCurrency() {
        return currency;
    }
}
