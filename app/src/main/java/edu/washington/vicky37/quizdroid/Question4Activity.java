package edu.washington.vicky37.quizdroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class Question4Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question4);

        RadioButton CSRadioButton1 = (RadioButton)findViewById(R.id.CSRadioButton1);
        CSRadioButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View summitButton = findViewById(R.id.CSSummitButton);
                summitButton.setVisibility(View.VISIBLE);
            };
        });

        RadioButton CSRadioButton2 = (RadioButton)findViewById(R.id.CSRadioButton2);
        CSRadioButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View summitButton = findViewById(R.id.CSSummitButton);
                summitButton.setVisibility(View.VISIBLE);
            };
        });

        RadioButton CSRadioButton3 = (RadioButton)findViewById(R.id.CSRadioButton3);
        CSRadioButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View summitButton = findViewById(R.id.CSSummitButton);
                summitButton.setVisibility(View.VISIBLE);
            };
        });

        RadioButton CSRadioButton4 = (RadioButton)findViewById(R.id.CSRadioButton4);
        CSRadioButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View summitButton = findViewById(R.id.CSSummitButton);
                summitButton.setVisibility(View.VISIBLE);
            };
        });

        Button CSSummitButton = (Button)findViewById(R.id.CSSummitButton);
        CSSummitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Question4Activity.this, Answer4Activity.class);
                startActivity(intent);};
        });
    }
}
