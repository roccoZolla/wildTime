/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.wild_time.Engine;

import com.mycompany.wild_time.Type.Command;
import com.mycompany.wild_time.Type.Item;
import com.mycompany.wild_time.Type.Npc;
import com.mycompany.wild_time.Type.Player;
import com.mycompany.wild_time.Type.Room;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rocco
 */

// classe per la gestione del mondo di gioco 
public abstract class GameDescription implements Serializable{
    private final List<Room> rooms = new ArrayList<>();
    private final List<Command> commands = new ArrayList<>();
    private final List<Npc> npcs = new ArrayList<>();
    private final List<Item> items = new ArrayList<>();
    private Player player = new Player();
    private String gameTitle = "";
    
    public List<Command> getCommands() {
        return commands;
    }
    
    public List<Room> getRooms() {
        return rooms;
    }
    
    public List<Npc> getNpcs() {
        return npcs;
    }
    
    public List<Item> getItems() {
        return items;
    }
    
    public Player getPlayer() {
        return player;
    }
    
    public String getTitle() {
        return gameTitle;
    }
    
    public void setPlayer(Player player) {
        this.player = player;
    }    
    
    public void setTitle(String title) {
        this.gameTitle = title;
    }
    
    public abstract void init() throws Exception;
}
