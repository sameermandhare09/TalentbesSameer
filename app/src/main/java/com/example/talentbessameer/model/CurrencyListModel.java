package com.example.talentbessameer.model;

import com.example.talentbessameer.view.MainActivityContract;
import com.example.talentbessameer.network.APIInterface;
import com.example.talentbessameer.network.ApiClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CurrencyListModel implements MainActivityContract.Model {
    @Override
    public void getCurrencyList(final OnFinishedListener onFinishedListener) {

        APIInterface apiService =
                ApiClient.getClient().create(APIInterface.class);
        Call<Currency> call = apiService.getCurrency();
        call.enqueue(new Callback<Currency>() {
            @Override
            public void onResponse(Call<Currency> call, Response<Currency> response) {

                onFinishedListener.onFinished(response.body());
            }

            @Override
            public void onFailure(Call<Currency> call, Throwable t) {
                onFinishedListener.onFailure(t);

            }
        });

    }
}
