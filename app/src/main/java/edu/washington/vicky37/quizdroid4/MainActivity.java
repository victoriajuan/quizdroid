package edu.washington.vicky37.quizdroid4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    QuizApp quizApp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        quizApp = new QuizApp();
        quizApp.addTopic(new Topic("Math", "Math is a science", "Math is a the study of topics such as quantity, structure, space and change. "));
        quizApp.addTopic(new Topic("Physics", "Physics is a science", "Physics is the natural science that involves the study of matter and its motion and behavior through space and time"));
        quizApp.addTopic(new Topic("Marvel Hero", "Marvel Heroes are characters", "Marvel Heroes are characters from the movies made by marvel comic "));
        Button button = (Button) findViewById(R.id.mathToQuestion);
        button.setOnClickListener(this);
        TextView textView = (TextView) findViewById(R.id.mathDesc);
        textView.setText(quizApp.getShortDesc("Math"));
        button = (Button) findViewById(R.id.physicsToQuestion);
        button.setOnClickListener(this);
        textView = (TextView) findViewById(R.id.physicsDesc);
        textView.setText(quizApp.getShortDesc("Physics"));
        button = (Button) findViewById(R.id.marvelToQuestion);
        button.setOnClickListener(this);
        textView = (TextView) findViewById(R.id.marvelDesc);
        textView.setText(quizApp.getShortDesc("Marvel Hero"));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
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

    public void onClick(View view){
        Intent intent = new Intent(MainActivity.this, Main2Activity.class);
        ArrayList<String> choices = new ArrayList<String>();
        Topic topic;
        switch (view.getId()){
            case R.id.mathToQuestion:
                topic = quizApp.getTopic("Math");
                choices = new ArrayList<>();
                choices.add("67");
                choices.add("66");
                choices.add("69");
                choices.add("68");
                topic.addQuestion(new Quiz("12 + 56", choices, "68"));
                choices = new ArrayList<>();
                choices.add("23");
                choices.add("22");
                choices.add("24");
                choices.add("21");
                topic.addQuestion(new Quiz("90 - 67", choices, "23"));
                quizApp.replaceTopic(quizApp.TopicSpot("Math"), topic);
                quizApp.setTopic("Math");
                break;
            case R.id.physicsToQuestion:
                topic = quizApp.getTopic("Physics");
                choices = new ArrayList<>();
                choices.add("100 km/h ");
                choices.add("200 km/h ");
                choices.add("150 km/h ");
                choices.add("50 km/h ");
                topic.addQuestion(new Quiz("Two identical cars collide head on. Each car is traveling at 100 km/h. The impact force on each car is the same as hitting a solid wall at: ", choices, "100 km/h "));
                choices = new ArrayList<>();
                choices.add("Vector");
                choices.add("Frame of reference");
                choices.add("Resultant");
                choices.add("Scalar");
                topic.addQuestion(new Quiz("Which of the following is a physical quantity that has a magnitude but no direction?", choices, "Scalar"));
                quizApp.replaceTopic(quizApp.TopicSpot("Physics"), topic);
                quizApp.setTopic("Physics");
                break;
            case R.id.marvelToQuestion:
                topic = quizApp.getTopic("Marvel Hero");
                choices = new ArrayList<>();
                choices.add("Stark Tower");
                choices.add("Fantastic Headquarters");
                choices.add("Baxter Building");
                choices.add("Xavier Institute");
                choices = new ArrayList<>();
                topic.addQuestion(new Quiz("The Fantastic Four have the headquarters in what building?", choices, "Baxter Building"));
                choices.add("The Daily Planet");
                choices.add("The Daily Bugle");
                choices.add("The New York Times");
                choices.add("The Rolling Stone");
                topic.addQuestion(new Quiz("Peter Parker works as a photographer for:", choices, "The Daily Bugle"));
                quizApp.replaceTopic(quizApp.TopicSpot("Marvel Hero"), topic);
                quizApp.setTopic("Marvel Hero");
                break;
        }
        startActivity(intent);
        finish();
    }

}
