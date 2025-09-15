package com.afnan.yourbmi;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        EditText edtHeightFt = findViewById(R.id.edt_height_ft);
        EditText edtHeightIn = findViewById(R.id.edt_height_In);
        EditText edtWeight = findViewById(R.id.edt_weight);

        TextView txtAnswer = findViewById(R.id.txt_answer);
        Button btnCalculate = findViewById(R.id.btn_calculate);

        btnCalculate.setOnClickListener(view -> {
            int weight = Integer.parseInt(edtWeight.getText().toString());
            int heightFt = Integer.parseInt(edtHeightFt.getText().toString());
            int heightIn = Integer.parseInt(edtHeightIn.getText().toString());

            double height_in = heightFt * 12 + heightIn;
            double height_cm = height_in * 2.54;
            double height_m = height_cm / 100;
            double bmi = weight / (height_m * height_m);

            if (bmi > 25) {
                txtAnswer.setText(R.string.txt_overweight);
                txtAnswer.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.red));
            } else if (bmi < 18) {
                txtAnswer.setText(R.string.txt_underweight);
                txtAnswer.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.red));
            } else {
                txtAnswer.setText(R.string.txt_normal_weight);
                txtAnswer.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.green));
            }
        });
    }
}