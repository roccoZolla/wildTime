package com.mycompany.wild_time.Editor.GUI;

import javax.swing.*;
import java.awt.*;

public class EditorFrame extends JFrame {

    private CardLayout cardLayout;
    private JPanel cardPanel;
    private StepIndicator stepIndicator;

    private int currentStep = 0;
    private final int TOTAL_STEPS = 4;

    public EditorFrame() {
        setTitle("WT - Editor");
        setSize(900, 600);
        setLocationRelativeTo(null);

        initComponents();

        setVisible(true);
    }

    private void initComponents() {

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        stepIndicator = new StepIndicator(currentStep, TOTAL_STEPS);
        stepIndicator.setPreferredSize(new Dimension(900, 50));
        stepIndicator.setAlignmentX(Component.CENTER_ALIGNMENT);

        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);

        cardPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

        cardPanel.add(createStepPanel("STEP 1 - Map"), "0");
        cardPanel.add(createStepPanel("STEP 2 - Charaters"), "1");
        cardPanel.add(createStepPanel("STEP 3 - Items"), "2");
        cardPanel.add(createStepPanel("STEP 4 - Summary"), "3");

        JButton prevBtn = new JButton("Back");
        JButton nextBtn = new JButton("Next");

        prevBtn.addActionListener(e -> {
            if (currentStep > 0) {
                currentStep--;
                updateStep();
            }
        });

        nextBtn.addActionListener(e -> {
            if (currentStep < TOTAL_STEPS - 1) {
                currentStep++;
                updateStep();
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(prevBtn);
        buttonPanel.add(nextBtn);
        buttonPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel.add(stepIndicator);
        panel.add(cardPanel);
        panel.add(buttonPanel);

        add(panel);
    }

    private JPanel createStepPanel(String title) {

        JPanel stepPanel = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        // -------------------------
        // TITOLO
        // -------------------------
        JLabel titleLabel = new JLabel(title, SwingConstants.CENTER);
        titleLabel.setFont(titleLabel.getFont().deriveFont(Font.BOLD, 20f));

        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 2;
        c.insets = new Insets(10, 10, 20, 10);
        stepPanel.add(titleLabel, c);

        // -------------------------
        // WORKSPACE
        // -------------------------
        WorkspacePanel workspace = new WorkspacePanel();
        workspace.setFocusable(true);

        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 1;
        c.weightx = 1;
        c.weighty = 1;
        c.fill = GridBagConstraints.BOTH;
        stepPanel.add(workspace, c);

        // -------------------------
        // TOOLS
        // -------------------------
        JPanel tools = new JPanel();
        tools.setLayout(new BoxLayout(tools, BoxLayout.Y_AXIS));
        tools.setPreferredSize(new Dimension(120, 400));

        JButton b1 = new JButton("Quadrato");
        tools.add(b1);

        // Aggiungi comportamento tool → crea quadrato
        b1.addActionListener(e -> {
            EditorObject obj = new EditorObject(50, 50);
            workspace.addObject(obj);
        });

        c.gridx = 1;
        c.gridy = 1;
        c.weightx = 0;
        c.fill = GridBagConstraints.VERTICAL;
        stepPanel.add(tools, c);

        return stepPanel;
    }


    private void updateStep() {
        cardLayout.show(cardPanel, String.valueOf(currentStep));
        stepIndicator.setStep(currentStep);
    }
}
