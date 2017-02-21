package edu.washington.vicky37.quizdroid4;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by victoriajuan on 2/17/17.
 */

public class TopicOverview extends AppCompatActivity {
    String topicName;
    String description;
    int questionCounter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topic_overview);
        Intent intent = getIntent();
        topicName = intent.getStringExtra("topicName");
        description = intent.getStringExtra("description");
        questionCounter = intent.getIntExtra("questionCounter", 0);

        TextView viewName = (TextView) findViewById(R.id.topic);
        viewName.setText(topicName);
        TextView viewDesc = (TextView) findViewById(R.id.desc);
        viewDesc.setText(description);
        TextView viewCounter = (TextView) findViewById(R.id.questionCount);
        viewCounter.setText(questionCounter + "questions");
    }

}
