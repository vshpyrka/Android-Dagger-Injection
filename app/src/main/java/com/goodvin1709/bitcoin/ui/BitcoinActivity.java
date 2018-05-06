package com.goodvin1709.bitcoin.ui;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;

import com.goodvin1709.bitcoin.R;
import com.goodvin1709.bitcoin.databinding.ActivityBitcoinBinding;
import com.goodvin1709.bitcoin.utils.ViewModelFactory;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;

public class BitcoinActivity extends DaggerAppCompatActivity {

    @Inject
    ViewModelFactory factory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        BitcoinViewModel model = ViewModelProviders
                .of(this, factory).get(BitcoinViewModel.class);
        ActivityBitcoinBinding binding = DataBindingUtil
                .setContentView(this, R.layout.activity_bitcoin);
        binding.setLifecycleOwner(this);
        binding.setModel(model);
    }
}
