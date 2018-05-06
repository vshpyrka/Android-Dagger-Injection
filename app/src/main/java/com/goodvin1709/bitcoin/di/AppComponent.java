package com.goodvin1709.bitcoin.di;

import android.app.Application;

import com.goodvin1709.bitcoin.ReactiveBitcoin;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(modules = {
        AndroidSupportInjectionModule.class,
        AppModule.class,
        BitcoinModule.class})
public interface AppComponent extends AndroidInjector<ReactiveBitcoin> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        AppComponent.Builder application(Application application);

        AppComponent build();
    }
}
