/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.wild_time.Type;

import java.io.Serializable;

/**
 *
 * @author rocco
 */
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
