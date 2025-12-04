package com.mycompany.wild_time.Gui;

import javax.swing.*;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class GUIManager {
    private MenuFrame menuFrame;
    private GameFrame gameFrame;

    private final BlockingQueue<String> inputQueue = new LinkedBlockingQueue<>();

    public void showMainMenu(MenuListener listener) {
        SwingUtilities.invokeLater(() -> {
            if (this.menuFrame != null) {
                this.menuFrame.dispose();
            }

            this.menuFrame = new MenuFrame(listener);
            this.menuFrame.setVisible(true);
        });
    }


    public void hideMainMenu() {
        if (this.menuFrame != null) {
            this.menuFrame.setVisible(false);
        }
    }

    public void showGame() {
        System.out.println("showGame");

        SwingUtilities.invokeLater(() -> {
            if (this.gameFrame != null) {
                this.gameFrame.dispose();
            }

            this.gameFrame = new GameFrame(this);
            this.gameFrame.setVisible(true);
        });
    }

    public void showError(String message) {
        JOptionPane.showMessageDialog(
                null,
                message,
                "Errore",
                JOptionPane.ERROR_MESSAGE
        );
    }


    public void onUserInput(String input) {
        System.out.println("input: " + input);
        inputQueue.offer(input);
    }

    public String fetchUserInput() {
        try {
            // blocca fino a nuovo input
            return inputQueue.take();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return null;
        }
    }

    public void update(String result) {
        if (this.gameFrame != null) {
            SwingUtilities.invokeLater(() -> {
                gameFrame.updateUIState(result);
            });
        }
    }
}
