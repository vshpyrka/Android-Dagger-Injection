package com.goodvin1709.currency;

import android.app.Application;

public class ReactiveCurrency extends Application {

    public static AppProvider appProvider;

    @Override
    public void onCreate() {
        super.onCreate();
        appProvider = new AppProvider(this);
    }

    public static AppProvider getAppProvider() {
        return appProvider;
    }
}
