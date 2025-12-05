package com.mycompany.wild_time.Game;

import com.mycompany.wild_time.Shared.Type.Player;

public class GameState {
    private String currentRoomID;
    private Player player;

    public GameState() {
        this.player = new Player("hero", 100);
        this.currentRoomID = "room1";
    }

    public Player getPlayer() {
        return player;
    }

    public void setCurrentRoomID(String roomID) {
        this.currentRoomID = roomID;
    }

    public String getCurrentRoomID() {
        return currentRoomID;
    }
}
