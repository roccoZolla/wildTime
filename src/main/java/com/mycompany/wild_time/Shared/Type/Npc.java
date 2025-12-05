package com.mycompany.wild_time.Shared.Type;


import java.util.List;

public class Npc extends GameObject {
    private boolean isEnemy;
    private boolean isTalking;

//    private Item reward;
    private List<String> dialogues;

    public Npc() {
    }

    @Override
    public String toString() {
        return "Npc{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", isEnemy=" + isEnemy +
                ", isTalking=" + isTalking +
                ", dialogues=" + dialogues +
                '}';
    }
}
