package com.goodvin1709.currency.ui.history;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.goodvin1709.currency.ReactiveCurrency;
import com.goodvin1709.currency.entity.CurrencyEntity;
import com.goodvin1709.currency.repository.CurrencyRepository;

import java.util.List;

public class CurrencyHistoryViewModel extends ViewModel {

    private final LiveData<List<CurrencyEntity>> currencies;
    private final CurrencyRepository repository;

    public CurrencyHistoryViewModel() {
        repository = ReactiveCurrency.getAppProvider().getCurrencyRepository();
        currencies = repository.getAllCurrencies();
    }

    public LiveData<List<CurrencyEntity>> getCurrencies() {
        return currencies;
    }
}
