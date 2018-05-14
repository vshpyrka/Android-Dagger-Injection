package com.goodvin1709.currency.ui.history;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.goodvin1709.currency.R;
import com.goodvin1709.currency.databinding.CurrencyHistoryItemBinding;
import com.goodvin1709.currency.entity.CurrencyEntity;

import java.util.ArrayList;
import java.util.List;

public class CurrencyHistoryAdapter extends RecyclerView.Adapter<CurrencyHistoryAdapter.CurrencyHolder> {

    private List<CurrencyEntity> currencies = new ArrayList<>();

    @NonNull
    @Override
    public CurrencyHolder onCreateViewHolder(@NonNull ViewGroup parent, final int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.currency_history_item, parent, false);
        return new CurrencyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CurrencyHolder holder, int position) {
        CurrencyEntity result = currencies.get(position);
        holder.bind(result);
    }

    public void setCurrencies(List<CurrencyEntity> currencies) {
        this.currencies = currencies;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return currencies == null ? 0 : currencies.size();
    }

    class CurrencyHolder extends RecyclerView.ViewHolder {
        private CurrencyHistoryItemBinding binding;

        CurrencyHolder(View view) {
            super(view);
            this.binding = DataBindingUtil.bind(view);
        }

        void bind(@NonNull CurrencyEntity entity) {
            binding.setItem(entity);
            binding.executePendingBindings();
        }
    }
}
