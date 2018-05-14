package com.goodvin1709.currency.ui.history;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.goodvin1709.currency.databinding.FragmentCurrencyHistoryBinding;

import java.util.Objects;

public class CurrencyHistoryFragment extends Fragment {

    public static final String TAG = "CurrencyHistoryFragment";

    private CurrencyHistoryViewModel model;
    private FragmentCurrencyHistoryBinding binding;
    private CurrencyHistoryAdapter adapter;

    public static CurrencyHistoryFragment newInstance() {
        CurrencyHistoryFragment fragment = new CurrencyHistoryFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        model = ViewModelProviders.of(Objects.requireNonNull(getActivity()))
                .get(CurrencyHistoryViewModel.class);
        adapter = new CurrencyHistoryAdapter();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentCurrencyHistoryBinding.inflate(inflater, container, false);
        binding.fragmentCurrencyHistoryList.setAdapter(adapter);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        model.getCurrencies().observe(this, currencies -> {
            if (currencies != null) {
                adapter.setCurrencies(currencies);
            }
        });
    }
}
