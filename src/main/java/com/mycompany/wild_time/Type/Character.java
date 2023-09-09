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
public abstract class Character implements Serializable{
    protected int hp;
    protected String name;
    protected Item arma;    
    protected Item scudo;

    public int getHp() {
        return hp;
    }

    public String getName() {
        return name;
    }
    
    public Item getArma() {
        return arma;
    }
    
    public Item getScudo() {
        return scudo;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public void setArma(Item arma) {
        this.arma = arma;
    }
    
    public void setScudo(Item Scudo) {
        this.scudo = Scudo;
    }

}
