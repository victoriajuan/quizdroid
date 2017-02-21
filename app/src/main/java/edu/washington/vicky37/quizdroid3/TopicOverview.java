package edu.washington.vicky37.quizdroid3;

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
//        Button button = (Button) findViewById(R.id.ToQuestionButton);
    }

//    public void onClick(View v) {
//        Intent intent = new Intent(TopicOverview.this, QuestionGeneral.class);
//        QuestionGeneral questionGeneral = new QuestionGeneral();
//        switch(topicName){
//            case "Math":
////                questionGeneral.questionMap.put("12 + 56 = ", new String[] {"67", "66", "69", "68"});
////                questionGeneral.questionMap.put("90 - 67 = ", new String[] {"23", "22", "24", "21"});
//                intent.putExtra("QuestionGeneral", questionGeneral);
//                break;
//            case "Physics":
////                questionGeneral.questionMap.put("Two identical cars collide head on. Each car is traveling at 100 km/h. The impact force on each car is the same as hitting a solid wall at: ", new String[]{"100 km/h ", "200 km/h ", "150 km/h ", "50 km/h "});
////                questionGeneral.questionMap.put("Which of the following is a physical quantity that has a magnitude but no direction?", new String[]{"Vector", "Frame of reference", "Resultant", "Scalar"});
//                intent.putExtra("QuestionGeneral", questionGeneral);
//                break;
//            case "Marvel Hero":
////                questionGeneral.questionMap.put("The Fantastic Four have the headquarters in what building?", new String[]{"Stark Tower", "Fantastic Headquarters", "Baxter Building", "Xavier Institute"});
////                questionGeneral.questionMap.put("Peter Parker works as a photographer for:", new String[]{"The Daily Planet", "The Daily Bugle", "The New York Times", "The Rolling Stone"});
//                intent.putExtra("QuestionGeneral", questionGeneral);
//                break;
//        }
//        intent.putExtra("topicName", topicName);
//        startActivity(intent);
//        finish();
//    }


}
