package edu.washington.vicky37.quizdroid4;

import android.app.Application;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by victoriajuan on 2/12/17.
 */

public class QuizApp extends Application implements TopicRepository{
    private static final String TAG = "QuizApp";
    private static final String TAG2 = "";
    private static QuizApp instance;
    public ArrayList<Topic> quizes;
    public int index;
    public static Topic currentTopic;

    public QuizApp () {
        this.quizes = new ArrayList<>();
        this.index = 0;

    }
    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        //this.quizes = new ArrayList<>();

        Log.i(TAG, "on onCreate event fired");
    }


    public static QuizApp instance(){
        return instance;
    }

    public Topic getTopic(String string){
        return quizes.get(TopicSpot(string));
    }

    public int TopicSpot(String s){
        for(Topic topic: quizes){
            if(topic.topicName.equals(s)){
                return quizes.indexOf(topic);
            }
        }
        return -1;
    }

    public String topicName(){
        return currentTopic.topicName;
    }

    public void addTopic(Topic topic){
        quizes.add(topic);
    }

    public void replaceTopic(int i, Topic j){
        quizes.add(i, j);
    }

    public void setTopic(String string){
        for(Topic topic: quizes){
            if(topic.topicName.equals(string)){
                currentTopic = topic;
                index = quizes.indexOf(topic);
                break;
            }
        }
    }


    public String getShortDesc(String string){
        for(Topic topic: quizes){
            if(topic.topicName.equals(string)){
                return topic.shortDesc;
            }
        }
        return null;
    }

    public ArrayList<String> radioButtonIndex(){
        return currentTopic.currentQuestion().choices;
    }

    public String getScore(){
        return currentTopic.score();
    }

    public boolean nextQuestion(){
        return currentTopic.nextQuestion();
    }

    public String currentQuestion(){
        return currentTopic.currentQuestion().question;
    }

    public String getLongDesc(){
        return currentTopic.longDesc;
    }

    public int questionCounter(){
        return currentTopic.questions.size();
    }

    public String currentAnswer(){
        return currentTopic.currentQuestion().target();
    }

    public void answerCounter(){
        currentTopic.counter();
    }

}
