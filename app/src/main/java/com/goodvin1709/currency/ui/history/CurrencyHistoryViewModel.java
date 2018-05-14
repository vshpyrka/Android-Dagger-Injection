package com.goodvin1709.currency.ui.history;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.goodvin1709.currency.entity.CurrencyEntity;
import com.goodvin1709.currency.repository.CurrencyRepository;

import java.util.List;

import javax.inject.Inject;

public class CurrencyHistoryViewModel extends ViewModel {

    private final LiveData<List<CurrencyEntity>> currencies;

    @Inject
    CurrencyHistoryViewModel(final CurrencyRepository repository) {
        currencies = repository.getAllCurrencies();
    }

    public LiveData<List<CurrencyEntity>> getCurrencies() {
        return currencies;
    }
}
