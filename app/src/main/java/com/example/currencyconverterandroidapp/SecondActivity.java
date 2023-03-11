package com.example.currencyconverterandroidapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.Objects;

public class SecondActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        //
        TextView editTextConvertedMoney = findViewById(R.id.textViewConvertedMoney);
        Intent intent = getIntent();
        editTextConvertedMoney.setText(
            getConvertedMoney(intent.getDoubleExtra("money", 0),
            intent.getStringExtra("currency")
        ));
    }

    private String getConvertedMoney(double money, String currency) {
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        String result = decimalFormat.format(money) + " MAD = ";
        if (Objects.equals(currency, "USD")) {
            result += decimalFormat.format(money * 0.097) + " " + currency;
        } else if (Objects.equals(currency, "EURO")) {
            result += decimalFormat.format(money * 0.091) + " " + currency;
        } else if (Objects.equals(currency, "RUB")) {
            result += decimalFormat.format(money * 7.38) + " " + currency;
        }
        return result;
    }
}