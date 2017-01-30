package edu.washington.vicky37.quizdroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class Question3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question3);

        RadioButton physicsRadioButton1 = (RadioButton)findViewById(R.id.physicsRadioButton1);
        physicsRadioButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View summitButton = findViewById(R.id.mathSummitButton);
                summitButton.setVisibility(View.VISIBLE);
            };
        });

        RadioButton physicsRadioButton2 = (RadioButton)findViewById(R.id.physicsRadioButton2);
        physicsRadioButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View summitButton = findViewById(R.id.mathSummitButton);
                summitButton.setVisibility(View.VISIBLE);
            };
        });

        RadioButton physicsRadioButton3 = (RadioButton)findViewById(R.id.physicsRadioButton3);
        physicsRadioButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View summitButton = findViewById(R.id.mathSummitButton);
                summitButton.setVisibility(View.VISIBLE);
            };
        });

        RadioButton physicsRadioButton4 = (RadioButton)findViewById(R.id.physicsRadioButton3);
        physicsRadioButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View summitButton = (Button)findViewById(R.id.mathSummitButton);
                summitButton.setVisibility(View.VISIBLE);
            };
        });

        Button physicsSummitButton = (Button)findViewById(R.id.physicsSummitButton);
        physicsSummitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Question3Activity.this, Answer3Activity.class);
                startActivity(intent);};
        });
    }
}
