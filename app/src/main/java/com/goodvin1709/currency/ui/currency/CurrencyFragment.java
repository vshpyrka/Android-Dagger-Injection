package com.goodvin1709.currency.ui.currency;


import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.goodvin1709.currency.databinding.FragmentCurrencyBinding;

import java.util.Objects;

import javax.inject.Inject;

import dagger.android.support.DaggerFragment;

public class CurrencyFragment extends DaggerFragment {

    public static final String TAG = "CurrencyFragment";

    @Inject
    ViewModelProvider.Factory factory;
    private CurrencyViewModel model;

    public static CurrencyFragment newInstance() {
        CurrencyFragment fragment = new CurrencyFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        model = ViewModelProviders.of(Objects.requireNonNull(getActivity()), factory)
                .get(CurrencyViewModel.class);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentCurrencyBinding binding =
                FragmentCurrencyBinding.inflate(inflater, container, false);
        binding.setLifecycleOwner(this);
        binding.setModel(model);
        return binding.getRoot();
    }
}
