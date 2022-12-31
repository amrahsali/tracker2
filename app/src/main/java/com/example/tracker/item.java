package com.example.tracker;

public class item {
     String Question;
     String Answer;

    public item(String question, String answer) {
        this.Question = question;
        this.Answer = answer;
    }

    public String getQuestion() {
        return Question;
    }

    public void setQuestion(String question) {
        Question = question;
    }

    public String getAnswer() {
        return Answer;
    }

    public void setAnswer(String answer) {
        Answer = answer;
    }
}
