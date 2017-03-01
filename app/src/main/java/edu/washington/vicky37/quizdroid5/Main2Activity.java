package edu.washington.vicky37.quizdroid5;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {
    public static Intent intent;
    public static int select;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        intent = getIntent();
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new OverviewFragment())
                    .commit();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main_activity2, menu);
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

    public static class OverviewFragment extends Fragment {

        public OverviewFragment(){}

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View page = inflater.inflate(R.layout.activity_quiz_fragment, container, false);
            QuizApp quizApp = QuizApp.instance();
            TextView textView = (TextView) page.findViewById(R.id.questionTopic);
            textView.setText(quizApp.topicName());
            textView = (TextView) page.findViewById(R.id.question);
            textView.setText(quizApp.getLongDesc());
            textView = (TextView) page.findViewById(R.id.counter);
            textView.setText(quizApp.questionCounter() + " Total Questions");
            Button button = (Button) page.findViewById(R.id.fragmentButton);
            button.setText("Begin");
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    getFragmentManager().beginTransaction()
                            .replace(R.id.container, new questionFragment())
                            .commit();
                }
            });
            return page;
        }
    }

        public static class questionFragment extends Fragment {
            public questionFragment(){}

            @Override
            public View onCreateView(LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState) {
                final View page = inflater.inflate(R. layout.activity_question_detail, container, false);
                final QuizApp quizApp = QuizApp.instance();
                TextView  textView = (TextView) page.findViewById(R.id.questionTopic2);
                textView.setText(quizApp.topicName());
                textView = (TextView) page.findViewById(R.id.question2);
                textView.setText(quizApp.currentQuestion());
                textView = (TextView) page.findViewById(R.id.counter2);
                textView.setText(quizApp.questionCounter() + " Total Questions");
//                Button button = (Button) page.findViewById(R.id.SummitButton);
//                button.setText("Next");
                final RadioGroup radioGroup = (RadioGroup) page.findViewById(R.id.QuestionLayout);
                radioGroup.setAlpha((float) 1.0);
                ArrayList<String> choices = quizApp.radioButtonIndex();
                RadioButton radioButton = (RadioButton) page.findViewById(R.id.RadioButton1);
                radioButton.setText(choices.get(0));
                radioButton = (RadioButton) page.findViewById(R.id.RadioButton2);
                radioButton.setText(choices.get(1));
                radioButton = (RadioButton) page.findViewById(R.id.RadioButton3);
                radioButton.setText(choices.get(2));
                radioButton = (RadioButton) page.findViewById(R.id.RadioButton4);
                radioButton.setText(choices.get(3));
                //Button button1 = (Button) page.findViewById(R.id.fragmentButton);
                Button buttonNext = (Button) page.findViewById(R.id.SummitButton);
                final boolean isFinished;
                if(quizApp.nextQuestion()){
                    buttonNext.setText("Next");
                    isFinished = false;
                }else {
                    buttonNext.setText("Finish");
                    isFinished = true;
                }
                buttonNext.setOnClickListener( new View.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        int selected = radioGroup.getCheckedRadioButtonId();
                        RadioButton radioButton1 = (RadioButton) page.findViewById(selected);
                        if(isFinished){
                            if(selected == -1){
                                Toast.makeText(container.getContext(), "Please select an option", Toast.LENGTH_SHORT).show();
                            }else {
                                select = selected;
                                if(radioButton1.getText().equals(quizApp.currentAnswer())){
                                    quizApp.answerCounter();
                                }else {
                                    Log.i("Answer Counter", "Wrong Answer");
                                }
                                getFragmentManager().beginTransaction()
                                        .replace(R.id.container, new finalResults())
                                        .commit();
                            }
                        } else {
                            if(selected == -1){
                                Toast.makeText(container.getContext(), "Please select an option", Toast.LENGTH_SHORT).show();
                            }else {
                                select = selected;
                                System.out.println("Checking current answer" + quizApp.currentQuestion());
                                if(radioButton1.getText().equals(quizApp.currentAnswer())){
                                    quizApp.answerCounter();
                                }else {
                                    Log.i("Answer Counter", "Wrong Answer");
                                }
                                getFragmentManager().beginTransaction()
                                        .replace(R.id.container, new questionFragment())
                                        .commit();
                            }
                        }
                    }
                });
                return page;
            }
        }

        public static class finalResults extends Fragment{
            public finalResults(){}

            @Override
            public View onCreateView(LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState) {
                View page = inflater.inflate(R. layout.activity_quiz_fragment, container, false);
                QuizApp quizApp = QuizApp.instance();
                TextView  textView = (TextView) page.findViewById(R.id.questionTopic);
                textView.setText(quizApp.topicName());
                textView = (TextView) page.findViewById(R.id.question);
                textView.setText(" ");
                textView = (TextView) page.findViewById(R.id.counter);
                textView.setText(quizApp.getScore() + " correct");
                Button button = (Button) page.findViewById(R.id.fragmentButton);
                button.setText("Finish");
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(container.getContext(), MainActivity.class);
                        startActivity(intent);
                    }
                });
                return page;
            }
        }
}
