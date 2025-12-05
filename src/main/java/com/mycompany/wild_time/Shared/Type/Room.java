package com.mycompany.wild_time.Shared.Type;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class Room implements Serializable {
    private String id;
    private String name;
    private String description;

    // avro una lista di id tramite cui accedere alle varie stanze
    // direzione, idStanza
    private Map<Direction, String> exits;
    private List<GameObject> gameObjects;

    private Boolean isExplored;
    private Boolean isBlocked;
    private Boolean isFinal;

    public Room() {
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Map<Direction, String> getExits() {
        return exits;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Room{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", exits=" + exits +
                ", gameObjects=" + gameObjects +
                ", isExplored=" + isExplored +
                ", isBlocked=" + isBlocked +
                ", isFinal=" + isFinal +
                '}';
    }
}
