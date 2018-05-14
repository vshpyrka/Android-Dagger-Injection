package com.goodvin1709.currency.ui;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.goodvin1709.currency.R;
import com.goodvin1709.currency.ui.currency.CurrencyFragment;
import com.goodvin1709.currency.ui.history.CurrencyHistoryFragment;
import com.goodvin1709.currency.utils.ViewModelFactory;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;

public class MainActivity extends DaggerAppCompatActivity {

    @Inject
    ViewModelFactory factory;

    private MainViewModel model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        model = ViewModelProviders.of(this, factory).get(MainViewModel.class);
        DataBindingUtil.setContentView(this, R.layout.activity_main);
        showCurrencyFragment();
        showCurrencyHistoryFragment();
    }

    @Override
    protected void onStart() {
        super.onStart();
        model.startCollecting();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        model.stopCollecting();
    }

    private void showCurrencyFragment() {
        Fragment fragment = getSupportFragmentManager().findFragmentByTag(CurrencyFragment.TAG);
        if (fragment == null) {
            fragment = CurrencyFragment.newInstance();
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.main_activity_upper_container, fragment, CurrencyFragment.TAG)
                    .commit();
        }
    }

    private void showCurrencyHistoryFragment() {
        Fragment fragment = getSupportFragmentManager().findFragmentByTag(CurrencyHistoryFragment.TAG);
        if (fragment == null) {
            fragment = CurrencyHistoryFragment.newInstance();
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.main_activity_bottom_container, fragment, CurrencyHistoryFragment.TAG)
                    .commit();
        }
    }
}
