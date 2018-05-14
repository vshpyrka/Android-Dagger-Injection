package com.goodvin1709.currency.ui;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;

import com.goodvin1709.currency.di.ViewModelKey;
import com.goodvin1709.currency.ui.currency.CurrencyFragment;
import com.goodvin1709.currency.ui.currency.CurrencyViewModel;
import com.goodvin1709.currency.ui.history.CurrencyHistoryFragment;
import com.goodvin1709.currency.ui.history.CurrencyHistoryViewModel;
import com.goodvin1709.currency.utils.ViewModelFactory;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import dagger.multibindings.IntoMap;

@Module
public abstract class MainActivityModule {

    @ContributesAndroidInjector
    abstract CurrencyFragment contributesCurrencyFragment();

    @ContributesAndroidInjector
    abstract CurrencyHistoryFragment contributesCurrencyHistoryFragment();

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel.class)
    abstract ViewModel providesMainViewModel(final MainViewModel viewModel);

    @Binds
    @IntoMap
    @ViewModelKey(CurrencyViewModel.class)
    abstract ViewModel providesCurrencyViewModel(final CurrencyViewModel viewModel);

    @Binds
    @IntoMap
    @ViewModelKey(CurrencyHistoryViewModel.class)
    abstract ViewModel providesCurrencyHistoryViewModel(final CurrencyHistoryViewModel viewModel);

    @Binds
    abstract ViewModelProvider.Factory providesViewModelFactory(final ViewModelFactory factory);

}
