package com.mycompany.wild_time.Engine.GUI;

import javax.swing.*;

public class GUIManager {
    private MainMenuFrame mainMenuFrame;

    public void showMainMenu() {
        if (this.mainMenuFrame != null) this.mainMenuFrame.setVisible(true);
    }

    public void showMainMenu(MainMenuListener listener) {
        SwingUtilities.invokeLater(() -> {
            if (this.mainMenuFrame == null) this.mainMenuFrame = new MainMenuFrame(listener);

            this.mainMenuFrame.setVisible(true);
        });
    }

    public void hideMainMenu() {
        if (this.mainMenuFrame != null) this.mainMenuFrame.setVisible(false);
    }

    public void disposeMainMenu() {
        SwingUtilities.invokeLater(() -> {
            if (this.mainMenuFrame != null) {
                this.mainMenuFrame.dispose();
                this.mainMenuFrame = null;
            }
        });
    }

}
