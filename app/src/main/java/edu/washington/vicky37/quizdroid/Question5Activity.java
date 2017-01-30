package edu.washington.vicky37.quizdroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class Question5Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question5);

        RadioButton marvelRadioButton1 = (RadioButton)findViewById(R.id.marvelRadioButton1);
        marvelRadioButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View summitButton = findViewById(R.id.marvelSummitButton);
                summitButton.setVisibility(View.VISIBLE);
            };
        });

        RadioButton marvelRadioButton2 = (RadioButton)findViewById(R.id.marvelRadioButton2);
        marvelRadioButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View summitButton = findViewById(R.id.marvelSummitButton);
                summitButton.setVisibility(View.VISIBLE);
            };
        });

        RadioButton marvelRadioButton3 = (RadioButton)findViewById(R.id.marvelRadioButton3);
        marvelRadioButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View summitButton = findViewById(R.id.marvelSummitButton);
                summitButton.setVisibility(View.VISIBLE);
            };
        });

        RadioButton marvelRadioButton4 = (RadioButton)findViewById(R.id.marvelRadioButton4);
        marvelRadioButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View summitButton = findViewById(R.id.marvelSummitButton);
                summitButton.setVisibility(View.VISIBLE);
            };
        });

        Button marvelSummitButton = (Button)findViewById(R.id.marvelSummitButton);
        marvelSummitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Question5Activity.this, Answer5Activity.class);
                startActivity(intent);};
        });
    }
}
