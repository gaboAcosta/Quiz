package com.example.gabrielacosta.myquiz;

/**
 * Created by gabriel.acosta on 4/9/16.
 */
public class Question {
    private String mText;
    private Boolean mAnswer;

    public Question(String text, Boolean answer){
        mText = text;
        mAnswer = answer;
    }

    public Boolean getAnswer() {
        return mAnswer;
    }

    public void setAnswer(Boolean answer){
        mAnswer = answer;
    }

    public String getText(){
        return mText;
    }

    public void setText(String text){
        mText = text;
    }
}
