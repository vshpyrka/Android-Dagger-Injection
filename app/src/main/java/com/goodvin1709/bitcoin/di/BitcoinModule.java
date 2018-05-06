package com.goodvin1709.bitcoin.di;

import android.arch.lifecycle.ViewModel;

import com.goodvin1709.bitcoin.ui.BitcoinActivity;
import com.goodvin1709.bitcoin.ui.BitcoinViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import dagger.multibindings.IntoMap;

@Module
abstract class BitcoinModule {

    @ContributesAndroidInjector
    abstract BitcoinActivity contributesHomeActivity();

    @Binds
    @IntoMap
    @ViewModelKey(BitcoinViewModel.class)
    abstract ViewModel providesHomeViewModel(BitcoinViewModel viewModel);
}
