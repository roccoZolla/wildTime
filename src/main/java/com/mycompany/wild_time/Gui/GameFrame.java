package com.mycompany.wild_time.Gui;

import javax.swing.*;
import javax.swing.border.SoftBevelBorder;
import java.awt.*;

public class GameFrame extends JFrame {
    private JTextArea storyArea;
    private JTextField textField;

    private GUIManager guiManager;

    public GameFrame(GUIManager guiManager) {
        System.out.println("creo game frame");
        this.guiManager = guiManager;

        setTitle("Game Frame");
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 600);
        setLocationRelativeTo(null);
        initComponents();
        initListeners();

        setVisible(true);
        System.out.println("fine creazione game frame");
    }

    private void initComponents() {
        System.out.println("INIT: creo splitPane");
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        splitPane.setDividerLocation(250);
        splitPane.setResizeWeight(0.2);

        System.out.println("INIT: creo sidebar panel");
        JPanel sidebar = new JPanel();

        sidebar.setLayout(new BoxLayout(sidebar, BoxLayout.Y_AXIS));
        sidebar.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        System.out.println("INIT: creo campi");
        JTextField hpField = field("HP:");
        JTextField attackField = field("Attack:");
        JTextField armorField = field("Armor:");

        System.out.println("INIT: aggiungo componenti sidebar");
        sidebar.add(hpField);
        sidebar.add(attackField);
        sidebar.add(armorField);

        System.out.println("INIT: aggiungo sidebar a splitPane");
        splitPane.setLeftComponent(sidebar);

        System.out.println("INIT: creo storyArea");
        storyArea = new JTextArea("TEST STORY");
        JScrollPane scroll = new JScrollPane(storyArea);

        System.out.println("INIT: aggiungo storyArea");
        splitPane.setRightComponent(scroll);

        System.out.println("INIT: aggiungo splitPane al frame");
        add(splitPane, BorderLayout.CENTER);

        System.out.println("INIT: creo textField");
        textField = new JTextField();

        System.out.println("INIT: aggiungo textField al frame");
        add(textField, BorderLayout.SOUTH);

        System.out.println("INIT: FINE initComponents");
    }


    private JTextField field(String text) {
        JTextField tf = new JTextField(text);
        tf.setEditable(false);
        tf.setBorder(new SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tf.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));
        return tf;
    }

    private void initListeners() {
        System.out.println("init listener");
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
