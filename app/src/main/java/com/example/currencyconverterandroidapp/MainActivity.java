package com.example.currencyconverterandroidapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //
        EditText editTextMoney = findViewById(R.id.editTextMoney);
        Spinner spinnerCurrency = findViewById(R.id.spinnerCurrency);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.currencies, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCurrency.setAdapter(adapter);
        Button buttonConvert = findViewById(R.id.buttonConvert);
        buttonConvert.setOnClickListener(view -> {
            if (editTextMoney.length() == 0) {
                Toast.makeText(getApplicationContext(), "Money is required!", Toast.LENGTH_SHORT).show();
                return;
            }
            Intent intent = new Intent(this, SecondActivity.class);
            intent.putExtra("money", Double.parseDouble(editTextMoney.getText().toString()));
            intent.putExtra("currency", spinnerCurrency.getSelectedItem().toString());
            startActivity(intent);
        });
    }
}