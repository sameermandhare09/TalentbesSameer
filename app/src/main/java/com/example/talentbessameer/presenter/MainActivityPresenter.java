package com.example.talentbessameer.presenter;

import com.example.talentbessameer.model.CurrencyListModel;
import com.example.talentbessameer.view.MainActivityContract;
import com.example.talentbessameer.model.Currency;

public class MainActivityPresenter implements MainActivityContract.Cpresenter,
        MainActivityContract.Model.OnFinishedListener {

    MainActivityContract.View view;
    CurrencyListModel model;

    public MainActivityPresenter(MainActivityContract.View view) {
        this.view = view;
        model = new CurrencyListModel();

    }

    @Override
    public void onDestroy() {
        this.view = null;

    }

    @Override
    public void onRefreshButtonClick() {

    }

    @Override
    public void requestDataFromServer() {

        if (view !=null){
            view.showProgress();
        }

        model.getCurrencyList(this);
    }

    @Override
    public void onFinished(Currency currency) {

        view.setDataToNumberPicker(currency);
        if (view !=null){
            view.hideProgress();
        }
    }

    @Override
    public void onFailure(Throwable t) {

        view.onResponseFailure(t);
        if (view !=null){
            view.hideProgress();
        }
    }
}
