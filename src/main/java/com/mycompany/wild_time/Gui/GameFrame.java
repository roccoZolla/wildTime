package com.mycompany.wild_time.Gui;

import javax.swing.*;
import javax.swing.border.SoftBevelBorder;
import java.awt.*;

public class GameFrame extends JFrame {
    private JTextArea storyArea;
    private JTextField textField;

    private GUIManager guiManager;

    public GameFrame(GUIManager guiManager) {
        this.guiManager = guiManager;

        setTitle("Game Frame");
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 600);
        setLocationRelativeTo(null);

        initComponents();
        initListeners();

        setVisible(true);
    }

    private void initComponents() {
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        splitPane.setDividerLocation(250);
        splitPane.setResizeWeight(0.2);

        JPanel sidebar = new JPanel();

        sidebar.setLayout(new BoxLayout(sidebar, BoxLayout.Y_AXIS));
        sidebar.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JTextField hpField = field("HP:");
        JTextField attackField = field("Attack:");
        JTextField armorField = field("Armor:");

        sidebar.add(hpField);
        sidebar.add(attackField);
        sidebar.add(armorField);

        splitPane.setLeftComponent(sidebar);

        storyArea = new JTextArea("TEST STORY");
        JScrollPane scroll = new JScrollPane(storyArea);

        splitPane.setRightComponent(scroll);

        add(splitPane, BorderLayout.CENTER);

        textField = new JTextField();

        add(textField, BorderLayout.SOUTH);
    }


    private JTextField field(String text) {
        JTextField tf = new JTextField(text);
        tf.setEditable(false);
        tf.setBorder(new SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tf.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));
        return tf;
    }

    private void initListeners() {
        System.out.println("--- init text listener ---");
        textField.addActionListener(e -> {
            String text = textField.getText();
            textField.setText("");
            guiManager.onUserInput(text);
        });
    }


    public void updateUIState(String result) {
        storyArea.append("\n");
        storyArea.append(result);
    }

    public void cleanStoryArea() {
        storyArea.setText("");
    }
}
