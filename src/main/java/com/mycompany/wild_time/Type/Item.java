package com.mycompany.wild_time.Type;

import java.io.Serializable;

public class Item extends GameObject implements Serializable {
    private boolean takeable = false;
    private boolean useable = false;

    private boolean isHeal = false;
    private boolean isWeapon = false;
    private boolean isPowerUp = false;

    private int bonus = 0;
    private int attackDamage = 0;
    private int defenseBonus = 0;

    public Item() {
    }

    @Override
    public String toString() {
        return "Item{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", takeable=" + takeable +
                ", useable=" + useable +
                ", isHeal=" + isHeal +
                ", isWeapon=" + isWeapon +
                ", isPowerUp=" + isPowerUp +
                ", bonus=" + bonus +
                ", attackDamage=" + attackDamage +
                ", defenseBonus=" + defenseBonus +
                '}';
    }
}
