package com.mycompany.wild_time.Shared.Type;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private int hp;
    private List<Item> inventory = new ArrayList<>();

    public Player(String name, int hp) {
        this.name = name;
        this.hp = hp;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", hp=" + hp +
                ", inventory=" + inventory +
                '}';
    }
}
