package com.mycompany.wild_time.Engine;

import com.mycompany.wild_time.Engine.GUI.GUIManager;
import com.mycompany.wild_time.Engine.GUI.MainMenuAction;
import com.mycompany.wild_time.Game.Game;

public class Engine {

    private final GUIManager guiManager;

    private Game game;
//    private Editor editor;

    public Engine() {
        this.guiManager = new GUIManager();
    }

    public void start() {
        guiManager.showMainMenu(this::handleMenuAction);
    }


    private void handleMenuAction(MainMenuAction action) {
        switch (action) {
            case GAME:
                guiManager.hideMainMenu();

                game = new Game();
                game.setOnExit(() -> {
                    guiManager.showMainMenu(this::handleMenuAction);
                });

                Thread t = new Thread(game::start, "GameThread");
                t.start();

                break;

            case EDITOR:
                System.out.println("--- editor ---");
                break;

            case EXIT:
                guiManager.disposeMainMenu();
                break;
        }
    }

}
