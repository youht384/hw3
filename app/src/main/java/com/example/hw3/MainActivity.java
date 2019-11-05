package com.example.hw3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.math.BigDecimal;


public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private Button button;
    private TextView unitView;
    private EditText editText;

    private boolean change=true;
    private double tempC,tempF;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.change_button);
        textView = findViewById(R.id.textView);
        unitView = findViewById(R.id.unitText);
        editText = findViewById(R.id.editText);

        button.setOnClickListener(new View.OnClickListener(){
                            public void onClick(View v){

                                if(change==true)
                                {
                                    tempC = Double.parseDouble(editText.getText().toString());
                                    tempF= (1.8*tempC)+32;
                                    BigDecimal BD = new BigDecimal(tempF);
                                    unitView.setText("°F");
                                    textView.setText("華氏溫度");
                                    button.setText("攝氏<<華氏");
                                    editText.setText(String.valueOf(BD.setScale(2, BigDecimal.ROUND_HALF_UP).floatValue()));
                                    change=false;
                                }
                                else {
                                    tempF = Double.parseDouble(editText.getText().toString());
                                    tempC= (tempF-32)/1.8;
                                    BigDecimal BD = new BigDecimal(tempC);
                                    unitView.setText("°C");
                                    textView.setText("攝氏溫度");
                                    button.setText("攝氏>>華氏");
                                    editText.setText(String.valueOf(BD.setScale(2, BigDecimal.ROUND_HALF_UP).floatValue()));
                                    change=true;
                                }
                            }
                        }
                );


    }
}
