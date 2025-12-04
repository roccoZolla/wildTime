package com.mycompany.wild_time.Game;

import com.mycompany.wild_time.Cartridge.GameDescription;
import com.mycompany.wild_time.SaveManager.SaveManager;
import com.mycompany.wild_time.Parser.ParsedCommand;
import com.mycompany.wild_time.Type.Direction;
import com.mycompany.wild_time.Type.Room;
import com.mycompany.wild_time.Util.MessageKey;
import com.mycompany.wild_time.Util.Messages;

public class GameManager {
    private GameDescription gameDescription;
    private GameState gameState;

    public GameManager() {
    }

    public void setGame(GameDescription gameDescription) {
        this.gameDescription = gameDescription;
    }

    public void newGame(GameDescription gameDescription) {
        this.gameDescription = gameDescription;
        this.gameState = new GameState();
    }

    public void loadGame(GameDescription gameDescription) {
        this.gameDescription = gameDescription;
        this.gameState = SaveManager.loadSave();
    }

    public String execute(ParsedCommand parsedCommand) {
        String outputText = "";

        outputText = this.handleCommand(parsedCommand);

        return outputText;
    }

    private String handleCommand(ParsedCommand cmd) {
        String text = "";

        if (cmd.type() == null) {
            text = Messages.get(MessageKey.UNKNOWN_COMMAND);
        } else {
            Room current = gameDescription.getRoom(gameState.getCurrentRoomID());

            switch (cmd.type()) {
                case MOVE:
                    Direction direction = Direction.fromToken(cmd.target());

                    if (direction == null) {
                        text = Messages.get(MessageKey.UNKNOWN_COMMAND);
                        break;
                    }

                    if (!current.getExits().containsKey(direction)) {
                        text = Messages.get(MessageKey.CANT_GO_THERE, direction);
                        break;
                    }

                    String nextRoomID = current.getExits().get(direction);
                    Room nextRoom = gameDescription.getRoom(nextRoomID);

                    this.gameState.setCurrentRoomID(nextRoomID);
                    text = nextRoom.getName();
                    break;

                case LOOK_AT:
                    text = current.getDescription();
                    break;

                case WHERE_AM_I:
                    text = Messages.get(MessageKey.WHERE_AM_I, current.getName());
                    break;

                case SAVE:
                    if (SaveManager.save(gameState))
                        text = Messages.get(MessageKey.SUCCESS_SAVE);
                    else
                        text = Messages.get(MessageKey.ERROR_SAVE);
                    break;

                default:
                    text = Messages.get(MessageKey.UNKNOWN_COMMAND);
                    break;
            }
        }

        return text;
    }
}
