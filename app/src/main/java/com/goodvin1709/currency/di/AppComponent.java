package com.goodvin1709.currency.di;

import android.app.Application;

import com.goodvin1709.currency.ReactiveCurrency;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(modules = {
        AndroidSupportInjectionModule.class,
        AppModule.class,
        ActivityBindingModule.class})
public interface AppComponent extends AndroidInjector<ReactiveCurrency> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        AppComponent.Builder application(Application application);

        AppComponent build();
    }
}
