/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.wild_time.Parser;

import com.mycompany.wild_time.Type.Chest;
import com.mycompany.wild_time.Type.Command;
import com.mycompany.wild_time.Type.Conversation;
import com.mycompany.wild_time.Type.Item;
import com.mycompany.wild_time.Type.Npc;


/**
 *
 * @author rocco
 */
public class ParserOutput {
    private Command command;
    private Item object;
    private Chest chestObject;
    private Npc npc;
    private Conversation conversation;
    
    public ParserOutput(){}
    
    public ParserOutput(Command command) {
        this.command = command;
    }

    public ParserOutput(Command command, Item object) {
        this.command = command;
        this.object = object;
    }

    public ParserOutput(Command command, Item object, Chest chestObject, Npc npc) {
        this.command = command;
        this.object = object;
        this.chestObject = chestObject;
        this.npc = npc;
    }

    public Command getCommand() {
        return command;
    }

    public void setCommand(Command command) {
        this.command = command;
    }

    public Item getObject() {
        return object;
    }

    public void setObject(Item object) {
        this.object = object;
    }

    public Chest getChestObject() {
        return chestObject;
    }

    public void setInvObject(Chest chestObject) {
        this.chestObject = chestObject;
    }
    
    public Npc getNpc() {
        return npc;
    }
    
    public void setNpc(Npc npc) {
        this.npc = npc;
    }
    
    public Conversation getConversation() {
        return conversation;
    }
    
    public void setConversation(Conversation conversation) {
        this.conversation = conversation;
    }

}
