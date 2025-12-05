package com.mycompany.wild_time.Game;

import com.mycompany.wild_time.Game.Cartridge.CartridgeManager;
import com.mycompany.wild_time.Game.GUI.GameGUIManager;
import com.mycompany.wild_time.Game.GUI.MenuAction;
import com.mycompany.wild_time.Game.Parser.ParsedCommand;
import com.mycompany.wild_time.Game.Parser.Parser;
import com.mycompany.wild_time.Game.SaveManager.SaveManager;

import com.mycompany.wild_time.Shared.Type.CommandResult;

public class Game {

    private volatile GameplayState state;

    private Runnable onExitCallback;

    private final CartridgeManager cartridgeManager;
    private final GameManager gameManager;
    private final GameGUIManager gameGuiManager;
    private final Parser parser;

    public Game() {
        this.cartridgeManager = new CartridgeManager();
        this.gameManager = new GameManager();
        this.gameGuiManager = new GameGUIManager();

        this.parser = new Parser();
    }

    public void setOnExit(Runnable callback) {
        this.onExitCallback = callback;
    }

    public void start() {
        state = GameplayState.MAIN_MENU;

        gameGuiManager.showMainMenu(this::handleMenuAction);
    }

    private void handleMenuAction(MenuAction action) {
        switch (action) {
            case NEW_GAME:
                gameGuiManager.hideMainMenu();

                cartridgeManager.loadCartridge();

                gameManager.newGame(cartridgeManager.getCartridge());
                gameGuiManager.showGame();

                state = GameplayState.RUNNING;
                runGameLoop();
                break;

            case CONTINUE:
                if (!SaveManager.saveExists()) {
                    gameGuiManager.showError("Nessun salvataggio trovato");
                    return;
                }

                cartridgeManager.loadCartridge();
                gameManager.loadGame(cartridgeManager.getCartridge());

                gameGuiManager.hideMainMenu();
                gameGuiManager.showGame();

                state = GameplayState.RUNNING;
                runGameLoop();
                break;

            case EXIT:
                gameGuiManager.disposeMainMenu();
                state = GameplayState.EXIT_TO_ENGINE;

                if (onExitCallback != null) {
                    onExitCallback.run();
                }
                break;
        }
    }

    private void runGameLoop() {
        System.out.println("--- run game loop ---");
        Thread loop = new Thread(this::execute, "game_loop");
        loop.start();
    }

    private void execute() {
        System.out.println("--- execute loop ---");
        while (state == GameplayState.RUNNING) {

            String userInput = gameGuiManager.fetchUserInput();

            System.out.println("--- fetch user input: " + userInput);

            gameGuiManager.update(userInput);

            ParsedCommand parsedCommand = parser.parse(userInput,
                    cartridgeManager.getCartridge().getCommands());

            CommandResult result = gameManager.execute(parsedCommand);

            gameGuiManager.update(result.getMessage());

            if (result.shouldExitEngine()) {
                state = GameplayState.MAIN_MENU;

                gameGuiManager.disposeGame();
                gameGuiManager.showMainMenu(this::handleMenuAction);
                break;
            }

        }
    }


}