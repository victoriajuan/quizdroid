package edu.washington.vicky37.quizdroid5;

import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Bundle;
import android.util.JsonReader;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.List;

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
    public  ArrayList<String> Topics;
    public  ArrayList<String> Descs;
    public BufferedInputStream fis;
    public ArrayList<String> MathQuestions;
    public ArrayList<String> PhysicsQuestions;
    public ArrayList<String> MarvelQuestions;
    public ArrayList<String> MathAnswers;
    public ArrayList<String> PhysicsAnswers;
    public ArrayList<String> MarvelAnswers;
    public ArrayList<String> MathCorrect;
    public ArrayList<String> PhysicsCorrect;
    public ArrayList<String> MarvelCorrect;


    public QuizApp () {
        this.quizes = new ArrayList<>();
        this.index = 0;
        this.Topics = new ArrayList<>();
        this.Descs = new ArrayList<>();
        this.MathQuestions = new ArrayList<>();
        this.PhysicsQuestions = new ArrayList<>();
        this.MarvelQuestions = new ArrayList<>();
        this.MarvelAnswers = new ArrayList<>();
        this.PhysicsAnswers = new ArrayList<>();
        this.MarvelAnswers = new ArrayList<>();
        this.MathCorrect = new ArrayList<>();
        this.PhysicsCorrect = new ArrayList<>();
        this.MarvelCorrect = new ArrayList<>();
    }


    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        //FileInputStream file = null;

        InputStream file = null;

        try {
            file = getApplicationContext().getAssets().open("data.json");

            file = openFileInput("data.json");
            String json = readJSON(file);
            JSONArray jsonTopics = new JSONArray(json);
            quizes = new ArrayList<>();
            for (int i=0; i<jsonTopics.length(); i++) {
                JSONObject topic = jsonTopics.getJSONObject(i);//get the topic object(included everything in the object)
                JSONArray qs = topic.getJSONArray("questions");//get the question array
                List<Question> questions = new ArrayList<>();
                for (int j=0; j< qs.length(); j++) {//going though the question array
                    Log.d("QuizApp", "Adding " + qs.getJSONObject(j).getString("text"));// question text
                    questions.add(new Question(qs.getJSONObject(j).getString("text"),//question text
                            qs.getJSONObject(j).getJSONArray("answers").getString(0),//four choices
                            qs.getJSONObject(j).getJSONArray("answers").getString(1),
                            qs.getJSONObject(j).getJSONArray("answers").getString(2),
                            qs.getJSONObject(j).getJSONArray("answers").getString(3),
                            qs.getJSONObject(j).getInt("answer")));//right answer
                }
                quizes.add(new Topic(topic.getString("title"), topic.getString("desc"), topic.getString("desc")));
                Topics.add(topic.getString("title"));
                Descs.add(topic.getString("desc"));
            }
        }
        catch (JSONException jsonEx) {
            System.out.println("jsonException");
        }
        catch (IOException ioEx) {
            System.out.println("wrong file");
        }
        finally {
            try {
                if (file != null)
                    file.close();
            }
            catch (IOException ioEx) {}
        }
        Log.i(TAG, "on onCreate event fired");
    }

    public String readJSON(InputStream file) throws IOException{
        int size = file.available();
        byte[] buffer = new byte[size];
        file.read(buffer);

        return new String(buffer, "UTF-8");
    }


    public static QuizApp instance(){
        return instance;
    }

    public Topic getTopic(String string){
        return quizes.get(TopicSpot(string));
    }

    public ArrayList<String> getTopicList(){
        return Topics;
    }

    public ArrayList<String> getDesdList(){
        return Descs;
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

//    private Topic loadTopic(JSONObject topic) throws JSONException {
//        JSONArray JA = topic.getJSONArray("questions");
//        List<Question> questions = new ArrayList<Question>();
//        for (int i=0; i< JA.length(); i++) {
//            questions.add(loadQuestion(JA.getJSONObject(i)));
//        }
//        return new Topic(topic.getString("title"), topic.getString("desc"), topic.getString("desc"));
//    }
//
//    private Question loadQuestion(JSONObject q) throws JSONException {
//        return new Question(q.getString("text"),
//                q.getJSONArray("answers").getString(0),
//                q.getJSONArray("answers").getString(1),
//                q.getJSONArray("answers").getString(2),
//                q.getJSONArray("answers").getString(3),
//                q.getInt("answer"));
//    }


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