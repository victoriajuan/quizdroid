package edu.washington.vicky37.quizdroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import android.widget.Button;
import android.widget.RadioButton;

public class Question2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question2);

        RadioButton mathRadioButton1 = (RadioButton)findViewById(R.id.mathRadioButton1);
        mathRadioButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View summitButton = (Button)findViewById(R.id.mathSummitButton);
                summitButton.setVisibility(View.VISIBLE);
            };
        });

        RadioButton mathRadioButton2 = (RadioButton)findViewById(R.id.mathRadioButton2);
        mathRadioButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View summitButton = (Button)findViewById(R.id.mathSummitButton);
                summitButton.setVisibility(View.VISIBLE);
            };
        });

        RadioButton mathRadioButton3 = (RadioButton)findViewById(R.id.mathRadioButton3);
        mathRadioButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View summitButton = (Button)findViewById(R.id.mathSummitButton);
                summitButton.setVisibility(View.VISIBLE);
            };
        });

        RadioButton mathRadioButton4 = (RadioButton)findViewById(R.id.mathRadioButton4);
        mathRadioButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View summitButton = (Button)findViewById(R.id.mathSummitButton);
                summitButton.setVisibility(View.VISIBLE);
            };
        });

        Button mathSummitButton = (Button)findViewById(R.id.mathSummitButton);
        mathSummitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Question2Activity.this, Answer2Activity.class);
                startActivity(intent);};
        });
    }
}
