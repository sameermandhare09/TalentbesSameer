package com.example.talentbessameer.network;

import com.example.talentbessameer.model.Currency;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIInterface {

    @GET("currentprice.json/")
    Call<Currency> getCurrency();

}
