package com.mycompany.wild_time.Engine;

import com.mycompany.wild_time.Cartridge.CartridgeManager;
import com.mycompany.wild_time.SaveManager.SaveManager;
import com.mycompany.wild_time.Game.GameManager;
import com.mycompany.wild_time.Gui.GUIManager;
import com.mycompany.wild_time.Parser.Parser;
import com.mycompany.wild_time.Parser.ParsedCommand;

public class Engine {

    private EngineState state = EngineState.MAIN_MENU;

    private final CartridgeManager cartridgeManager;
    private final GameManager gameManager;
    private final GUIManager guiManager;
    private final Parser parser;


    public Engine() {
        this.cartridgeManager = new CartridgeManager();
        this.gameManager = new GameManager();
        this.guiManager = new GUIManager();

        this.parser = new Parser();
    }

    public void start() {
        this.guiManager.showMainMenu(action -> {
            switch (action) {
                case NEW_GAME:
                    guiManager.hideMainMenu();

                    cartridgeManager.loadCartridge();

                    gameManager.newGame(cartridgeManager.getCartridge());

                    guiManager.showGame();

                    new Thread(() -> {
                        state = EngineState.RUNNING;
                        execute();
                    }).start();
                    break;

                case CONTINUE:
                    cartridgeManager.loadCartridge();

                    gameManager.loadGame(cartridgeManager.getCartridge());

                    guiManager.hideMainMenu();

                    guiManager.showGame();

                    new Thread(() -> {
                        state = EngineState.RUNNING;
                        execute();
                    }).start();
                    break;

                case EXIT:
                    state = EngineState.EXIT;
                    break;
            }
        });
    }

    public void execute() {
        System.out.println("execute engine");
        while (state == EngineState.RUNNING) {
            String userInput = guiManager.fetchUserInput();

            guiManager.update(userInput);

            ParsedCommand parsedCommand = parser.parse(userInput,
                    cartridgeManager.getCartridge().getCommands());

            String result = gameManager.execute(parsedCommand);

            guiManager.update(result);
        }
    }
}
