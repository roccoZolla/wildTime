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
public class Inventory implements Serializable{
    List<Item> list = new ArrayList<>();

    public List<Item> getList() {
        return list;
    }

    public void setList(List<Item> inventory) {
        this.list = inventory;
    }
}
