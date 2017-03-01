package edu.washington.vicky37.quizdroid5;

import java.util.ArrayList;

/**
 * Created by victoriajuan on 2/13/17.
 */

public class Topic{
    public String topicName;
    public String shortDesc;
    public String longDesc;
    public ArrayList<Quiz> questions;
    private int icon;
    private int index;
    private int correct;

    public Topic(String name, String desc, String description) {
        this.topicName = name;
        this.shortDesc = desc;
        this.longDesc = description;
        this.correct = 0;
        this.index = 0;
        this.questions = new ArrayList<Quiz>();
    }

    public void addQuestion(Quiz quiz){
        questions.add(quiz);
    }

    public Quiz currentQuestion(){
        return questions.get(index);
    }

    public void counter(){
        correct++;
    }

    public String score(){
        return correct + " ";
    }

    public boolean nextQuestion(){
        if(index + 1 < questions.size()){
            index++;
            return true;
        }
        return false;
    }

    public String getName() {
        return topicName;
    }

    public void setName(String topicName) {
        this.topicName = topicName;
    }

    public String getLongDescription() {
        return longDesc;
    }

    public void setLongDescription(String longDescription) {
        this.longDesc = longDescription;
    }

    public String getShortDescription() {
        return shortDesc;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDesc = shortDescription;
    }

    public ArrayList<Quiz> getQuestions() {
        return questions;
    }

    public void setQuestions(ArrayList<Quiz> questions) {
        this.questions = questions;
    }

    private int getIcon(){
        return icon;
    }

    private void setIcon(int icon){
        this.icon = icon;
    }

}
