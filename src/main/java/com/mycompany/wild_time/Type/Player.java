/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.wild_time.Type;

/**
 *
 * @author rocco
 */
public class Player extends Character{
    private int maxHP;
    private Inventory inventario;
    private Room current_place;

    public Inventory getInventory() {
        return inventario;
    }
    
    public Room getCurrentPlace() {
        return current_place;
    }
    
    public int getMaxHP(){
        return maxHP;
    }

    public void setInventory(Inventory inventario) {
        this.inventario = inventario;
    }
    
    public void setCurrentPlace(Room current_place) {
        this.current_place = current_place;
    }
    
    public void setMaxHP(int maxHP) {
        this.maxHP = maxHP;
    }
}
