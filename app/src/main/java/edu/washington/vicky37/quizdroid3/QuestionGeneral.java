package edu.washington.vicky37.quizdroid3;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Random;

/**
 * Created by victoriajuan on 2/17/17.
 */

public class QuestionGeneral implements Serializable{
    public HashMap<String, String[]> questionMap;
    public int scoreCounter;
    public String topicName;
    public String description;
    public int questionSpot;
    public String[] userChoice;
    public String answer;

    public QuestionGeneral(){
        questionMap = new HashMap<String, String[]>();
        scoreCounter = 0;
        questionSpot = 0;
    }

    public void topic(String string){
        topicName = string;
    }

    public String getTopic(){
        return topicName;
    }

    public void setDescription(String desc){
        desc = description;
    }

    public String getDescription(){
        return description;
    }

    public int questionCounter(){
        return questionMap.size();
    }

    public void scoreCounter(){
        scoreCounter++;
    }

    public int totalScore(){
        return scoreCounter;
    }

    public String[] spot(){
        int counter = 0;
        for(String string: questionMap.keySet()){
            if(counter==questionSpot){
                userChoice=questionMap.get(string);
                answer=userChoice[0];
                userChoice = shuffleArray(questionMap.get(string));
                return userChoice;
            }
            counter++;
        }
        return null;
    }

    public String[] shuffleArray(String[] s){
        Random rnd = new Random();
        for (int i = s.length - 1; i > 0; i--) {
            int index = rnd.nextInt(i + 1);
            if (i == index) {
                ++i;
            } else {
                String a = s[index];
                s[index] = s[i];
                s[i] = a;
            }
        }
        return s;
    }

    public String[] questions(){
        return questionMap.keySet().toArray(new String[0]);
    }

    public String getQuestion(){
        String[] questions = questionMap.keySet().toArray(new String[0]);
        return questions[questionSpot];
    }

}
