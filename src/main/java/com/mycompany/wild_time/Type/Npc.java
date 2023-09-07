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
public class Npc extends Character{
    private boolean isEnemy = false;
    private boolean isTalking = false;
    private Item reward = null;         // se nemico è l'oggetto ricompensa
    private String description;
    private String talk;
    private List<Conversation> conversation = new ArrayList<>();
    
    public void setReward(Item reward) {
        this.reward = reward;
    }      
    
    public void setDescription(String description) {
        this.description = description;
    }  
    
    public void setTalk(String talk) {
        this.talk = talk;
    }
    
    public void setIsEnemy(boolean isEnemy) {
        this.isEnemy = isEnemy;
    }
    
    public void setConversation(List<Conversation> conversation) {
        this.conversation = conversation;
    }
    
    public void setIsTalking(boolean isTalking) {
        this.isTalking = isTalking;
    }
    
    public Item getReward() {
        return reward;
    }    
    
    public String getTalk() {
        return talk;
    }
    
    public String getDescription() {
        return description;
    }
    
    public boolean getIsEnemy() {
        return isEnemy;
    }
    
    public List<Conversation> getConversation() {
        return conversation;
    }
    
    public boolean getIsTalking() {
        return isTalking;
    }
}
