package com.mycompany.wild_time.Engine;

import com.mycompany.wild_time.Cartridge.CartridgeManager;
import com.mycompany.wild_time.Game.GameManager;
import com.mycompany.wild_time.Gui.GUIManager;
import com.mycompany.wild_time.Parser.Parser;
import com.mycompany.wild_time.Parser.ParsedCommand;
import com.mycompany.wild_time.Type.CommandResult;

import java.util.concurrent.CountDownLatch;

public class Engine {

    private EngineState state;

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

        while (state != EngineState.EXIT) {

            switch (state) {
                case MAIN_MENU:
                    runMainMenu();
                    break;

                case RUNNING:
                    runGameLoop();
                    break;
            }

        }
    }

    private void runMainMenu() {
        CountDownLatch latch = new CountDownLatch(1);

        guiManager.showMainMenu(action -> {
            switch (action) {
                case NEW_GAME:
                    guiManager.hideMainMenu();

                    cartridgeManager.loadCartridge();

                    gameManager.newGame(cartridgeManager.getCartridge());

                    guiManager.showGame();

                    state = EngineState.RUNNING;
                    break;

                case CONTINUE:
                    cartridgeManager.loadCartridge();

                    gameManager.loadGame(cartridgeManager.getCartridge());

                    guiManager.hideMainMenu();

                    guiManager.showGame();

                    state = EngineState.RUNNING;
                    break;

                case EXIT:
                    state = EngineState.EXIT;
                    break;
            }

            latch.countDown();
        });

        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    private void runGameLoop() {
        Thread t = new Thread(this::execute);
        t.start();

        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void execute() {
        while (state == EngineState.RUNNING) {

            String userInput = guiManager.fetchUserInput();

            guiManager.update(userInput);

            ParsedCommand parsedCommand = parser.parse(userInput,
                    cartridgeManager.getCartridge().getCommands());

            CommandResult result = gameManager.execute(parsedCommand);

            guiManager.update(result.getMessage());

            if (result.shouldExitEngine()) {
                state = EngineState.MAIN_MENU;
                break;
            }

        }
    }
}
