package com.goodvin1709.bitcoin.ui;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.goodvin1709.bitcoin.entity.CurrencyEntity;
import com.goodvin1709.bitcoin.repository.CurrencyRepository;

import javax.inject.Inject;

public class BitcoinViewModel extends ViewModel {

    private final LiveData<CurrencyEntity> currency;

    @Inject
    BitcoinViewModel(final CurrencyRepository repository) {
        currency = repository.getCurrency();
    }

    public LiveData<CurrencyEntity> getCurrency() {
        return currency;
    }
}
