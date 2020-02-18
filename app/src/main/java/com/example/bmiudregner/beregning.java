package com.example.bmiudregner;

import android.widget.TextView;

import java.text.DecimalFormat;

public class beregning extends MainActivity{
    public double udregning(TextView h, TextView w){
        String intHeight = h.getText().toString();
        double heightInput = Double.valueOf(intHeight);

        String intWeight = w.getText().toString();
        double weightInput = Double.parseDouble(intWeight);
        double bmi = weightInput / Math.pow(heightInput,2);
        return bmi;
    }
}
