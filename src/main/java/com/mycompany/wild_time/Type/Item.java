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
public class Item implements Serializable{
    private int id;
    private String name;
    private int value;          // in moneta del gioco
    private boolean takeable = false;   // indica se un oggetto di puo raccogliere
    private boolean useable = false;    // indica se un oggetto si puo usare
    private boolean isHeal = false;     // indica se un'oggetto è tipo curativo -> comando usa
    private boolean isWeapon = false;   // indica se un'oggetto è un'arma -> comando equipaggia
    private int bonusHP = 0;
    private int attackDamage = 0;   
    private int defenseBonus = 0;
    private String description;
    
    // constructors
    public Item() {
        this.id = 0;
        this.name = "";
        this.value = 0;
        this.takeable = false;
        this.useable = false;
        this.description = "";
    }
    
    public Item(int id){
        this.id = id;
    }
    
    public Item(int id, String name){
        this.id = id;
        this.name = name;
    }
    
    // methods
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }

    public boolean isTakeable() {
        return takeable;
    }

    public boolean isUseable() {
        return useable;
    }
    
    public boolean IsHeal() {
        return isHeal;
    }
    
    public boolean IsWeapon() {
        return isWeapon;
    }
    
    public int getBonusHP() {
        return bonusHP;
    }
    
    public int getAttackDamage() {
        return attackDamage;
    }
    
    public int getDefenseBonus() {
        return defenseBonus;
    }

    public String getDescription() {
        return description;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setTakeable(boolean takeable) {
        this.takeable = takeable;
    }

    public void setUseable(boolean useable) {
        this.useable = useable;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    public void setIsHeal(boolean isHeal) {
        this.isHeal = isHeal;
    }
    
    public void setIsWeapon(boolean isWeapon) {
        this.isWeapon = isWeapon;
    }
    
    public void setBonusHP(int bonusHP) {
        this.bonusHP = bonusHP;
    }
    
    public void setAttackDamage(int attackDamage) {
        this.attackDamage = attackDamage;
    }
    
    public void setDefenseBonus(int defenseBonus) {
        this.defenseBonus = defenseBonus;
    }
}
