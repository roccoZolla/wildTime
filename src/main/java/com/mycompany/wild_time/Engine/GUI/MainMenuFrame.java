package com.mycompany.wild_time.Engine.GUI;

import javax.swing.*;
import java.awt.*;

public class MainMenuFrame extends JFrame {
    private JButton buttonNewGame;
    private JButton buttonContinue;
    private JButton buttonExit;

    private MainMenuListener listener;

    public MainMenuFrame(MainMenuListener listener) {
        this.listener = listener;

        setTitle("WTEngine");
        setSize(900, 600);
        setLocationRelativeTo(null);
        setVisible(true);

        initComponents();
        initButtons();
    }

    private void initComponents() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        panel.setAlignmentX(Component.CENTER_ALIGNMENT);

        buttonNewGame = new JButton("Game");
        buttonContinue = new JButton("Editor");
        buttonExit = new JButton("Exit");

        Dimension btnSize = new Dimension(200, 40);
        buttonNewGame.setMaximumSize(btnSize);
        buttonContinue.setMaximumSize(btnSize);
        buttonExit.setMaximumSize(btnSize);

        panel.add(Box.createVerticalGlue());
        panel.add(center(buttonNewGame));
        panel.add(Box.createRigidArea(new Dimension(0, 15)));
        panel.add(center(buttonContinue));
        panel.add(Box.createRigidArea(new Dimension(0, 15)));
        panel.add(center(buttonExit));
        panel.add(Box.createVerticalGlue());

        add(panel);
    }

    private void initButtons() {
        buttonNewGame.addActionListener(e -> listener.onMainMenuAction(MainMenuAction.GAME));
        buttonContinue.addActionListener(e -> listener.onMainMenuAction(MainMenuAction.EDITOR));
        buttonExit.addActionListener(e -> listener.onMainMenuAction(MainMenuAction.EXIT));
    }

    private Component center(JComponent comp) {
        comp.setAlignmentX(Component.CENTER_ALIGNMENT);
        return comp;
    }
}
