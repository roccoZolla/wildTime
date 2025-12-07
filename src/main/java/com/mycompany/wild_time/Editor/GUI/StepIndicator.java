package com.mycompany.wild_time.Editor.GUI;

import javax.swing.*;
import java.awt.*;

public class StepIndicator extends JPanel {
    private int step;
    private final int total;

    public StepIndicator(int step, int total) {
        this.step = step;
        this.total = total;
    }

    public void setStep(int step) {
        this.step = step;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int diameter = 18;
        int spacing = 40;

        int startX = (getWidth() - ((total - 1) * spacing)) / 2;
        int y = getHeight() / 2 - diameter / 2;

        for (int i = 0; i < total; i++) {
            if (i == step)
                g.setColor(new Color(33, 150, 243));
            else
                g.setColor(Color.LIGHT_GRAY);

            g.fillOval(startX + i * spacing, y, diameter, diameter);
        }
    }
}