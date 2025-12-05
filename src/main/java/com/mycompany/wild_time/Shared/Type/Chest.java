package com.mycompany.wild_time.Shared.Type;

import java.util.ArrayList;
import java.util.List;

public class Chest extends GameObject {
    private boolean isLocked;
    private Item openWith;
    private List<Item> items = new ArrayList<>();

    public Chest() {
    }

    @Override
    public String toString() {
        return "Chest{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", isLocked=" + isLocked +
                ", openWith=" + openWith +
                ", items=" + items +
                '}';
    }
}
