/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.wild_time.Type;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rocco
 */
public class Conversation {
    private List<String> question = new ArrayList<>(); 
    private List<String> answer = new ArrayList<>();
    
    public List<String> getQuestion() {
        return question;
    }
    
    public List<String> getAnswer() {
        return answer;
    }
    
//    public void setQuestion(List question) {
//        this.question = question;
//    }
//    
//    public void setAnswer(String answer) {
//        this.answer = answer;
//    }
}
