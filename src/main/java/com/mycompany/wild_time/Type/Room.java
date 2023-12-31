/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.wild_time.Type;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rocco
 */
public class Room implements Serializable{
    private String name;
    private int id;
    private Room est;
    private Room west;
    private Room nord;
    private Room south;
    private Chest chest = new Chest();        
    private List<Item> items = new ArrayList<>();
    private List<Npc> npcs = new ArrayList<>();
    private String description;         // cosa c'è
    private Boolean isExplored;         // è stata visitata? 
    private Boolean isBlocked;          // è bloccata?
    private Item openWith = null;       // strumento attraverso il quale sblocchi la stanza
    private Boolean isFinal = false;    // è la stanza finale?

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public Room getEst() {
        return est;
    }

    public Room getWest() {
        return west;
    }

    public Room getNord() {
        return nord;
    }

    public Room getSouth() {
        return south;
    }

    public String getDescription() {
        return description;
    }

    public Boolean getExplored() {
        return isExplored;
    }

    public Boolean getBlocked() {
        return isBlocked;
    }
    
    public List<Item> getItems () {
        return items;
    }
    
    public Chest getChest(){
        return chest;
    }
    
    public List<Npc> getNpcs() {
        return npcs;
    }
    
    public Boolean getFinal () {
        return isFinal;
    }
    
    public Item getOpenWith() {
        return openWith;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setEst(Room est) {
        this.est = est;
    }

    public void setOvest(Room west) {
        this.west = west;
    }

    public void setNord(Room nord) {
        this.nord = nord;
    }

    public void setSud(Room south) {
        this.south = south;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setExplored(Boolean explored) {
        this.isExplored = explored;
    }

    public void setBlocked(Boolean blocked) {
        this.isBlocked = blocked;
    }
            
    public void setItem(List<Item> items) {
        this.items = items;
    }
    
    public void setFinal(boolean isFinal) {
        this.isFinal = isFinal;
    }
    
    public void setOpenWith(Item item) {
        this.openWith = item;
    }   
}
