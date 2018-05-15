package com.goodvin1709.currency.di;

import android.app.Application;
import android.arch.persistence.room.Room;
import android.content.Context;

import com.goodvin1709.currency.collector.CurrencyCollector;
import com.goodvin1709.currency.collector.impl.CurrencyCollectorImpl;
import com.goodvin1709.currency.db.AppDatabase;
import com.goodvin1709.currency.network.ApiService;
import com.goodvin1709.currency.repository.CurrencyRepository;
import com.goodvin1709.currency.repository.impl.CurrencyRepositoryImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.jackson.JacksonConverterFactory;

@Module
public class AppModule {

    private final Application application;

    public AppModule(final Application application) {
        this.application = application;
    }

    @Provides
    @Singleton
    public Context provideAppContext() {
        return application;
    }

    @Provides
    @Singleton
    public AppDatabase initDatabase(final Context context) {
        return Room.databaseBuilder(context, AppDatabase.class, AppDatabase.DATABASE_NAME)
                .fallbackToDestructiveMigration()
                .build();
    }

    @Provides
    @Singleton
    public ApiService initApiService() {
        return new Retrofit.Builder()
                .baseUrl(ApiService.BASE_URL)
                .addConverterFactory(JacksonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.createAsync())
                .build()
                .create(ApiService.class);
    }

    @Provides
    @Singleton
    public CurrencyRepository initCurrencyRepository(final AppDatabase appDatabase) {
        return new CurrencyRepositoryImpl(appDatabase);
    }

    @Provides
    @Singleton
    public CurrencyCollector initCurrencyController(final CurrencyRepository currencyRepository, final ApiService apiService) {
        return new CurrencyCollectorImpl(currencyRepository, apiService);
    }
}
