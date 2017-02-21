package edu.washington.vicky37.quizdroid4;

import java.util.ArrayList;

/**
 * Created by victoriajuan on 2/13/17.
 */

public class Question {
    String questionText;
    String answer1;
    String answer2;
    String answer3;
    String answer4;
    int correctAnswer;

    public Question(String questionText, String answer1, String answer2, String answer3, String answer4, int correctAnswer) {
                this.questionText = questionText;
                this.answer1 = answer1;
                this.answer2 = answer2;
                this.answer3 = answer3;
                this.answer4 = answer4;
                this.correctAnswer = correctAnswer;
            }

                public String getQuestionText() {
                return questionText;
            }

                public void setQuestionText(String questionText) {
                this.questionText = questionText;
            }

                public String getAnswer1() {
                return answer1;
            }

                public void setAnswer1(String answer1) {
                this.answer1 = answer1;
            }

                public String getAnswer2() {
                return answer2;
            }

                public void setAnswer2(String answer2) {
                this.answer2 = answer2;
            }

                public String getAnswer3() {
                return answer3;
            }

                public void setAnswer3(String answer3) {
                this.answer3 = answer3;
            }

                public String getAnswer4() {
                return answer4;
            }

                public void setAnswer4(String answer4) {
                this.answer4 = answer4;
            }

                public int getCorrectAnswer() {
                return correctAnswer;
            }

                public void setCorrectAnswer(int correctAnswer) {
                this.correctAnswer = correctAnswer;
            }

}
