package edu.washington.vicky37.quizdroid3;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

/**
 * Created by victoriajuan on 2/18/17.
 */

public class AnswerSub extends AppCompatActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_answer);

        Intent intent = getIntent();
        QuestionGeneral questionGeneral = (QuestionGeneral) intent.getSerializableExtra("QuestionGeneral");
        int answerCheck = intent.getIntExtra("select", 0);
        TextView textView = (TextView) findViewById(R.id.questionDetail);
        textView.setText(intent.getStringExtra("question"));
        String topicName = intent.getStringExtra("topicName");
        String[] choices = questionGeneral.spot();
        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.QuestionLay);
        RadioButton radioButton = (RadioButton) findViewById(R.id.Radio1);
        radioButton.setText(choices[0]);
        radioButton = (RadioButton) findViewById(R.id.Radio2);
        radioButton.setText(choices[1]);
        radioButton = (RadioButton) findViewById(R.id.Radio3);
        radioButton.setText(choices[2]);
        radioButton = (RadioButton) findViewById(R.id.Radio4);
        radioButton.setText(choices[3]);
        radioButton = (RadioButton) findViewById(answerCheck);
        textView = (TextView) findViewById(R.id.answerDetail);
        if(answerCheck==findViewById(R.id.Radio1).getId()){
            textView.setText("Correct AnswerSub");
            questionGeneral.scoreCounter();
        }else {
            textView.setText("Incorrect AnswerSub");
        }
        TextView score = (TextView) findViewById(R.id.score);
        score.setText(questionGeneral.totalScore());
        Button next = (Button) findViewById(R.id.next);
        final Intent intent1;
        if((questionGeneral.questionSpot+1)<(questionGeneral.questionMap.size())){
            questionGeneral.questionSpot++;
            next.setText("Next");
            intent1 = new Intent(AnswerSub.this, QuestionDetail.class);
            intent1.putExtra("QuestionGeneral", questionGeneral);
            intent1.putExtra("topicName", topicName);
        }else {
            next.setText("Finish");
            intent1 = new Intent(AnswerSub.this, AnswerOverall.class);
            intent1.putExtra("QuestionGeneral", questionGeneral);
            intent1.putExtra("topicName", topicName);
        }
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent1);
                finish();
            }
        });
    }
}

