package edu.washington.vicky37.quizdroid3;

import android.support.v7.app.ActionBarActivity;

import java.util.ArrayList;

/**
 * Created by victoriajuan on 2/13/17.
 */

public class Quiz {
    public String question;
    public ArrayList<String> choices;
    public int answerSpot;

    public Quiz(String question, ArrayList<String> choices, String answer){
        this.question = question;
        this.choices = choices;
        this.answerSpot = choices.indexOf(answer);
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String target(){
        return choices.get(answerSpot);
    }

}
