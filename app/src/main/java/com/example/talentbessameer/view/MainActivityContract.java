package com.example.talentbessameer.view;

import com.example.talentbessameer.model.Currency;

public class MainActivityContract {
    private Currency.Bpi bpi;
    private View view;
    private String[] pickerVals;

    public interface Cpresenter{

        void onDestroy();

        void onRefreshButtonClick();

        void requestDataFromServer();

    }

    public interface View {

        void showProgress();

        void hideProgress();

        void setDataToNumberPicker(Currency currency);

        void onResponseFailure(Throwable throwable);

    }
    public interface Model {

        interface OnFinishedListener {
            void onFinished(Currency currency);
            void onFailure(Throwable t);
        }

        void getCurrencyList(OnFinishedListener onFinishedListener);

    }
}
