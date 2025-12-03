package com.mycompany.wild_time.Gui;

import java.awt.*;
import javax.swing.*;

public class MenuFrame extends JFrame {

    private JButton buttonNewGame;
    private JButton buttonContinue;
    private JButton buttonExit;

    private MenuListener listener;

    public MenuFrame(MenuListener listener) {
        this.listener = listener;

        setTitle("Game Engine 2.0");
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

        buttonNewGame = new JButton("New Game");
        buttonContinue = new JButton("Continue");
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
        buttonNewGame.addActionListener(e -> listener.onMenuAction(MenuAction.NEW_GAME));
        buttonContinue.addActionListener(e -> listener.onMenuAction(MenuAction.CONTINUE));
        buttonExit.addActionListener(e -> listener.onMenuAction(MenuAction.EXIT));
    }

    private Component center(JComponent comp) {
        comp.setAlignmentX(Component.CENTER_ALIGNMENT);
        return comp;
    }
}