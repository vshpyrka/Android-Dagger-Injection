package com.goodvin1709.reactivedb.di;

import android.app.Application;

import com.goodvin1709.reactivedb.ReactiveDB;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(modules = {
        AndroidSupportInjectionModule.class,})
public interface AppComponent extends AndroidInjector<ReactiveDB> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        AppComponent.Builder application(Application application);

        AppComponent build();
    }
}
