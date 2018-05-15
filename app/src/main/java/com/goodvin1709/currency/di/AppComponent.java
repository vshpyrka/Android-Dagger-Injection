package com.goodvin1709.currency.di;

import com.goodvin1709.currency.ui.MainViewModel;
import com.goodvin1709.currency.ui.currency.CurrencyViewModel;
import com.goodvin1709.currency.ui.history.CurrencyHistoryViewModel;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {

    void inject(CurrencyHistoryViewModel currencyHistoryViewModel);

    void inject(CurrencyViewModel currencyViewModel);

    void inject(MainViewModel mainViewModel);
}
