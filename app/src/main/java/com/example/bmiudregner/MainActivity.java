package com.example.bmiudregner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.math.*;
import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    Button udregning, intent;
    EditText height, weight;
    TextView resultat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        udregning = findViewById(R.id.button);
        height = findViewById(R.id.heightid);
        weight = findViewById(R.id.weightid);
        resultat = findViewById(R.id.textView);

        udregning.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                beregning b = new beregning();
                DecimalFormat bmii = new DecimalFormat("#.#");
                resultat.setText("Din BMI er: " + bmii.format(b.udregning(height,weight)));

            }
        });


    }

    public void share(View view) {
        Intent sendintent = new Intent();
        sendintent.setAction(Intent.ACTION_SEND);
        sendintent.putExtra(Intent.EXTRA_TEXT, resultat.getText().toString());
        sendintent.setType("text/plain");

        Intent shareIntent = Intent.createChooser(sendintent, null);
        startActivity(shareIntent);
    }

}
