package edu.washington.vicky37.quizdroid3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AnswerOverall extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_overall_answer);

        Intent intent = getIntent();
        TextView textView = (TextView) findViewById(R.id.answerTopic);
        textView.setText(intent.getStringExtra("topicName"));
        textView = (TextView) findViewById(R.id.overallScore);
        QuestionGeneral questionGeneral = (QuestionGeneral) intent.getSerializableExtra("QuestionGeneral");
        textView.setText(questionGeneral.totalScore() + "total correct");
        Button button = (Button) findViewById(R.id.finishButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(AnswerOverall.this, MainActivity.class);
                startActivity(intent1);
                finish();
            }
        });
    }
}
