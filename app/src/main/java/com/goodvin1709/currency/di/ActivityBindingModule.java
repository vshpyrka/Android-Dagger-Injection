package com.goodvin1709.currency.di;

import com.goodvin1709.currency.ui.MainActivity;
import com.goodvin1709.currency.ui.MainActivityModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
abstract class ActivityBindingModule {

    @ContributesAndroidInjector(modules = MainActivityModule.class)
    abstract MainActivity contributesMainActivity();
}
