package com.mycompany.wild_time.Cartridge;

import com.mycompany.wild_time.Command.Command;
import com.mycompany.wild_time.Type.*;

import java.util.ArrayList;
import java.util.List;


// @todo prevedi l'uso di un builder
public class GameDescription {
    private String gameTitle;

    private final List<Room> rooms = new ArrayList<>();

    private final List<Item> items = new ArrayList<>();

    private final List<Chest> chests = new ArrayList<>();

    private final List<Npc> npcs = new ArrayList<>();

    private final List<Command> commands = new ArrayList<>();

    public List<Command> getCommands() {
        return commands;
    }

    public List<GameObject> getGameObjects() {
        List<GameObject> gameObjects = new ArrayList<>();

        gameObjects.addAll(items);
        gameObjects.addAll(chests);
        gameObjects.addAll(npcs);

        return gameObjects;
    }

    public Room getRoom(String roomID) {
        return rooms.stream()
                .filter(r -> r.getId().equals(roomID))
                .findFirst()
                .orElse(null);
    }

    @Override
    public String toString() {
        return "GameDescription{" +
                "gameTitle='" + gameTitle + '\'' +
                ", rooms=" + rooms +
                ", items=" + items +
                ", chests=" + chests +
                ", npcs=" + npcs +
                ", commands=" + commands +
                '}';
    }

}
