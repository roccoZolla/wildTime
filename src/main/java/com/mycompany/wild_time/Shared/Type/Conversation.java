package com.mycompany.wild_time.Shared.Type;

import java.io.Serializable;

public class Conversation implements Serializable{
    private String question = "";
    private String answer = "";

    
    public String getQuestion() {
        return question;
    }
    
    public String getAnswer() {
        return answer;
    }
    
    public void setQuestion(String question) {
        this.question = question;
    }
    
    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
