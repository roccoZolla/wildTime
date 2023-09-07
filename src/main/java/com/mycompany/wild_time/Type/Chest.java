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

// item container
public class Chest extends Item{
    private List<Item> chest = new ArrayList<>();
    private boolean isOpen;            // true aperta - false chiusa
    private Item openWith;              // oggetto che serve per aprire la chest
    
    // true -> puo essere aperta
    // false -> non puo essere aperta
    
    
//    public Chest() {
//        isOpen = false;
//    }
//    
//    public Chest(int id) {
//        super(id);
//    }
//
//    public Chest(int id, String name) {
//        super(id, name);
//    }
//
//    public Chest(int id, String name, String description) {
//        super(id, name, description);
//    }
//
//    public Chest(int id, String name, String description, Set<String> alias) {
//        super(id, name, description, alias);
//    }

    public List<Item> getList() {
        return chest;
    }
    
    public Item getKey() {
        return openWith;
    }

    public void setChest(List<Item> chest) {
        this.chest = chest;
    }
    
    public void setIsOpen(boolean isOpen) {
        this.isOpen = isOpen;
    }
    
    public void setOpenWith(Item key) {
        this.openWith = key;
    }

    public boolean getIsOpen() {
        return isOpen;
    }
    
    
//    public void add(Item o) {
//        this.chest.add(o);
//    }
//    
//    public void remove(Item o) {
//        this.chest.remove(o);
//    }
    
}
