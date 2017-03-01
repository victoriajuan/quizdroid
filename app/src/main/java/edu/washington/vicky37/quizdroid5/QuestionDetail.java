package edu.washington.vicky37.quizdroid5;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by victoriajuan on 2/18/17.
 */

public class QuestionDetail extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_detail);

        Intent intent = getIntent();
        final QuestionGeneral questionGeneral = (QuestionGeneral) intent.getSerializableExtra("QuestionGeneral");
        final String topicName = intent.getStringExtra("topicName");
        TextView textView = (TextView) findViewById(R.id.questionTopic);
        textView.setText(topicName);
        final String question = questionGeneral.getQuestion();
        textView = (TextView) findViewById(R.id.question);
        textView.setText(question);
        String[] choices = questionGeneral.spot();
        final RadioGroup radioGroup = (RadioGroup) findViewById(R.id.QuestionLayout);
        RadioButton radioButton1 = (RadioButton) findViewById(R.id.RadioButton1);
        radioButton1.setText(choices[0]);
        RadioButton radioButton2 = (RadioButton) findViewById(R.id.RadioButton2);
        radioButton2.setText(choices[1]);
        RadioButton radioButton3 = (RadioButton) findViewById(R.id.RadioButton3);
        radioButton3.setText(choices[2]);
        RadioButton radioButton4 = (RadioButton) findViewById(R.id.RadioButton4);
        radioButton4.setText(choices[3]);
        Button button = (Button) findViewById(R.id.SummitButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int select = radioGroup.getCheckedRadioButtonId();
                if(select==-1){
                    Toast.makeText(QuestionDetail.this, "select one answer", Toast.LENGTH_SHORT).show();
                }else {
                    Intent intent = new Intent(QuestionDetail.this, AnswerSub.class);
                    intent.putExtra("select", select);
                    intent.putExtra("topicName", topicName);
                    intent.putExtra("question", question);
                    intent.putExtra("QuestionGeneral", questionGeneral);

                    startActivity(intent);
                    finish();
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_question_detail, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
