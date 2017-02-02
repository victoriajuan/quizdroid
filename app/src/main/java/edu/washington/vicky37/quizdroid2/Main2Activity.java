package edu.washington.vicky37.quizdroid2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Main2Activity extends AppCompatActivity implements MathMainFragment.OnFragmentInteractionListener ,
        PhysicsMainFragment.OnFragmentInteractionListener, CSMainFragment.OnFragmentInteractionListener,
        MarvelMainFragment.OnFragmentInteractionListener, MathQuestionFragment.OnFragmentInteractionListener,
        PhysicsQuestionFragment.OnFragmentInteractionListener, CSQuestionFragment.OnFragmentInteractionListener,
        MarvelQuestionFragment.OnFragmentInteractionListener, OverallAnswerFragment.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        String value = getIntent().getStringExtra("value");
        System.out.println("the value is " +value);
        switch(value) {
            case "math":
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.overview_container, new MathMainFragment())
                        .commit();
                break;
            case "physics":
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.overview_container, new PhysicsMainFragment())
                        .commit();
                break;
            case "computer":
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.overview_container, new CSMainFragment())
                        .commit();
                break;
            case "marvel":
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.overview_container, new MarvelMainFragment())
                        .commit();
                break;
        }
    }

    @Override
    public void onFragmentInteraction(int button) {
        switch (button) {
            case R.id.mathToQuestionButton:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.overview_container, new MathQuestionFragment())
                        .commit();
                break;
            case R.id.physicsToQuestionButton:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.overview_container, new PhysicsQuestionFragment())
                        .commit();
                break;
            case R.id.CSToQuestionButton:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.overview_container, new CSQuestionFragment())
                        .commit();
                break;
            case R.id.marvelToQuestionButton:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.overview_container, new MarvelQuestionFragment())
                        .commit();
                break;
            case R.id.mathSummitButton:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.overview_container, new OverallAnswerFragment())
                        .commit();
                break;
            case R.id.physicsSummitButton:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.overview_container, new OverallAnswerFragment())
                        .commit();
                break;
            case R.id.CSSummitButton:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.overview_container, new OverallAnswerFragment())
                        .commit();
                break;
            case R.id.marvelSummitButton:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.overview_container, new OverallAnswerFragment())
                        .commit();
                break;
            case R.id.finishButton:
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                break;
        }
    }

}
