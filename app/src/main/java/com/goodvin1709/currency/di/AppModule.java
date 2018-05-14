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
class AppModule {

    @Provides
    @Singleton
    Context provideContext(final Application application) {
        return application;
    }

    @Provides
    @Singleton
    AppDatabase providesDatabase(final Context context) {
        return Room.databaseBuilder(context, AppDatabase.class, AppDatabase.DATABASE_NAME)
                .fallbackToDestructiveMigration()
                .build();
    }

    @Provides
    @Singleton
    CurrencyRepository providesRepository(final CurrencyRepositoryImpl repository) {
        return repository;
    }

    @Provides
    @Singleton
    ApiService providesApiService() {
        return new Retrofit.Builder()
                .baseUrl(ApiService.BASE_URL)
                .addConverterFactory(JacksonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.createAsync())
                .build()
                .create(ApiService.class);
    }

    @Provides
    @Singleton
    CurrencyCollector providesCurrencyCollector(CurrencyCollectorImpl collector) {
        return collector;
    }
}
