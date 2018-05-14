package com.goodvin1709.currency;


import android.arch.persistence.room.Room;
import android.content.Context;

import com.goodvin1709.currency.collector.CurrencyCollector;
import com.goodvin1709.currency.collector.impl.CurrencyCollectorImpl;
import com.goodvin1709.currency.db.AppDatabase;
import com.goodvin1709.currency.network.ApiService;
import com.goodvin1709.currency.repository.CurrencyRepository;
import com.goodvin1709.currency.repository.impl.CurrencyRepositoryImpl;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class AppProvider {

    private CurrencyRepository currencyRepository;
    private ApiService apiService;
    private CurrencyCollector currencyCollector;
    private AppDatabase appDatabase;

    AppProvider(final Context context) {
        initDatabase(context);
        initApiService();
        initCurrencyRepository();
        initCurrencyController();
    }

    private void initDatabase(final Context context) {
        appDatabase = Room.databaseBuilder(context, AppDatabase.class, AppDatabase.DATABASE_NAME)
                .fallbackToDestructiveMigration()
                .build();
    }

    private void initApiService() {
        apiService = new Retrofit.Builder()
                .baseUrl(ApiService.BASE_URL)
                .addConverterFactory(JacksonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.createAsync())
                .build()
                .create(ApiService.class);
    }

    private void initCurrencyRepository() {
        currencyRepository = new CurrencyRepositoryImpl(appDatabase);
    }

    private void initCurrencyController() {
        currencyCollector = new CurrencyCollectorImpl(currencyRepository, apiService);
    }

    public CurrencyRepository getCurrencyRepository() {
        return currencyRepository;
    }

    public CurrencyCollector getCurrencyCollector() {
        return currencyCollector;
    }
}
