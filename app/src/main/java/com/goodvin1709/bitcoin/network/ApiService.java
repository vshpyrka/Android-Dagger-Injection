package com.goodvin1709.bitcoin.network;

import com.goodvin1709.bitcoin.network.response.CurrencyResponse;

import io.reactivex.Single;
import retrofit2.http.GET;

public interface ApiService {

    String BASE_URL = "https://blockchain.info/";

    @GET("ru/ticker")
    Single<CurrencyResponse> getCurrency();
}
