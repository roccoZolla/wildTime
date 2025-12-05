package com.mycompany.wild_time.Engine;

import com.mycompany.wild_time.Cartridge.CartridgeManager;
import com.mycompany.wild_time.Game.GameManager;
import com.mycompany.wild_time.Gui.GUIManager;
import com.mycompany.wild_time.Gui.MenuAction;
import com.mycompany.wild_time.Parser.Parser;
import com.mycompany.wild_time.Parser.ParsedCommand;
import com.mycompany.wild_time.SaveManager.SaveManager;
import com.mycompany.wild_time.Type.CommandResult;


public class Engine {

    private volatile EngineState state;

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
        state = EngineState.MAIN_MENU;

        guiManager.showMainMenu(this::handleMenuAction);
    }

    private void handleMenuAction(MenuAction action) {
        switch (action) {
            case NEW_GAME:
                guiManager.hideMainMenu();

                cartridgeManager.loadCartridge();

                gameManager.newGame(cartridgeManager.getCartridge());
                guiManager.showGame();

                state = EngineState.RUNNING;
                runGameLoop();
                break;

            case CONTINUE:
                if (!SaveManager.saveExists()) {
                    guiManager.showError("Nessun salvataggio trovato");
                    return;
                }

                cartridgeManager.loadCartridge();
                gameManager.loadGame(cartridgeManager.getCartridge());

                guiManager.hideMainMenu();
                guiManager.showGame();

                state = EngineState.RUNNING;
                runGameLoop();
                break;

            case EXIT:
                guiManager.disposeMainMenu();
                state = EngineState.EXIT;
                break;
        }
    }

    private void runGameLoop() {
        System.out.println("--- run game loop ---");
        Thread loop = new Thread(this::execute, "game_loop");
        loop.setDaemon(true);
        loop.start();
    }

    private void execute() {
        System.out.println("--- execute loop ---");
        while (state == EngineState.RUNNING) {

            String userInput = guiManager.fetchUserInput();

            System.out.println("--- fetch user input: " + userInput);

            guiManager.update(userInput);

            ParsedCommand parsedCommand = parser.parse(userInput,
                    cartridgeManager.getCartridge().getCommands());

            CommandResult result = gameManager.execute(parsedCommand);

            guiManager.update(result.getMessage());

            if (result.shouldExitEngine()) {
                state = EngineState.MAIN_MENU;

                guiManager.disposeGame();
                guiManager.showMainMenu(this::handleMenuAction);
                break;
            }

        }
    }
}
