package com.goodvin1709.reactivedb;

import android.content.Context;

import dagger.android.AndroidInjector;
import dagger.android.support.DaggerApplication;

public class ReactiveDB extends DaggerApplication {

    @Override
    protected void attachBaseContext(final Context base) {
        super.attachBaseContext(base);
    }

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        return null;
    }
}
