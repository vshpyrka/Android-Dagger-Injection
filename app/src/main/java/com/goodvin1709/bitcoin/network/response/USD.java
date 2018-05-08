package com.goodvin1709.bitcoin.network.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "buy",
        "sell",
})
@JsonIgnoreProperties(ignoreUnknown = true)
public class USD {

    @JsonProperty("buy")
    public Float buy;
    @JsonProperty("sell")
    public Float sell;

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof USD) {
            return buy.equals(((USD) obj).buy)
                    && sell.equals(((USD) obj).sell);
        }
        return super.equals(obj);
    }
}