package com.goodvin1709.currency;

import android.app.Application;

import com.goodvin1709.currency.di.AppComponent;
import com.goodvin1709.currency.di.AppModule;
import com.goodvin1709.currency.di.DaggerAppComponent;

public class ReactiveCurrency extends Application {

    private static AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }

    public static AppComponent getAppComponent() {
        return appComponent;
    }
}
