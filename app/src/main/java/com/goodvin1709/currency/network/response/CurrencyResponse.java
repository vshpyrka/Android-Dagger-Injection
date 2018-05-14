package com.goodvin1709.currency.network.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({
        "USD"
})
@JsonIgnoreProperties(ignoreUnknown = true)
public class CurrencyResponse {

    @JsonProperty("USD")
    public USD usd;

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof CurrencyResponse) {
            return usd.equals(((CurrencyResponse) obj).usd);
        }
        return super.equals(obj);
    }
}
