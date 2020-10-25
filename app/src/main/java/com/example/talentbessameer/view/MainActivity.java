package com.example.talentbessameer.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.NumberPicker;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.talentbessameer.R;
import com.example.talentbessameer.model.Currency;
import com.example.talentbessameer.presenter.MainActivityPresenter;

public class MainActivity extends AppCompatActivity implements MainActivityContract.View, NumberPicker.OnValueChangeListener {
    TextView txt_price;
    NumberPicker nbr_price;
    private String[] pickerVals;
    Currency.Bpi bpi;
    private ProgressBar pbLoading;
    MainActivityPresenter mainActivityPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        initUI();
        mainActivityPresenter = new MainActivityPresenter(this);
        mainActivityPresenter.requestDataFromServer();

        nbr_price.setOnValueChangedListener(this);

    }

    private void initUI(){

        txt_price = findViewById(R.id.txt_price);
        nbr_price = findViewById(R.id.nbr_price);
        nbr_price.setMaxValue(4);
        nbr_price.setMinValue(0);
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void setDataToNumberPicker(Currency currency) {
        bpi = currency.getBpi();
        pickerVals  = new String[] {"turtle",bpi.getUSD().getCode(), bpi.getGBP().getCode(), bpi.getEUR().getCode(),  "axolotl"};
        nbr_price.setDisplayedValues(pickerVals);
        Log.e("Result",bpi.toString());


    }

    @Override
    public void onResponseFailure(Throwable throwable) {

    }

    @Override
    public void onValueChange(NumberPicker numberPicker, int i, int i1) {
        int pos  = nbr_price.getValue();

        if (pickerVals[pos].equals("GBP")){
            txt_price.setText(bpi.getGBP().getRate());
        }else if (pickerVals[pos].equals("EUR")){
            txt_price.setText(bpi.getEUR().getRate());
        }else if (pickerVals[pos].equals("USD")){
            txt_price.setText(bpi.getUSD().getRate());
        }else {
            txt_price.setText("Price");
        }


    }
}