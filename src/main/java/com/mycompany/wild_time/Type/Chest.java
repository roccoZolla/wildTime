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
}
