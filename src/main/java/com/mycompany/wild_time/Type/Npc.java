/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.wild_time.Type;

/**
 *
 * @author rocco
 */
public class Npc extends Character{
    private boolean isEnemy = false;
    private Item reward = null;         // se nemico è l'oggetto ricompensa
    private String description;
    private String talk;
    private Conversation conversation;
    
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
    
    public void setConversation(Conversation conversation) {
        this.conversation = conversation;
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
    
    public Conversation getConversation() {
        return conversation;
    }
}
