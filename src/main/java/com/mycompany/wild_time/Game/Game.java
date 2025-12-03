package com.mycompany.wild_time.Game;

import com.mycompany.wild_time.Command.Command;
import com.mycompany.wild_time.Type.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

// @todo: classe che descrive il mondo di gioco da trasferire nella gameDescription
public abstract class Game implements Serializable {
    private String gameTitle;
    private final List<Room> rooms;
    private final List<Command> commands;
    private final List<Npc> npcs;
    private final List<Item> items;

    // player stat
    private Player player;
    private Room currentPlace;

    public Game() {
        this.rooms = new ArrayList<>();
        this.commands = new ArrayList<>();
        this.npcs = new ArrayList<>();
        this.items = new ArrayList<>();

        this.init();
    }

    public List<Command> getCommands() {
        return commands;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public List<Npc> getNpcs() {
        return npcs;
    }

    public List<Item> getItems() {
        return items;
    }

    public Room getCurrentPlace() {
        return currentPlace;
    }

    public void setCurrentPlace(Room room) {
        this.currentPlace = room;
    }

    public String getTitle() {
        return gameTitle;
    }

    public void setTitle(String title) {
        this.gameTitle = title;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public abstract void init();
}
