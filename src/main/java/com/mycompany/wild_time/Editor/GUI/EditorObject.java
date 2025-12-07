package com.mycompany.wild_time.Editor.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EditorObject extends JComponent {

    private int offsetX, offsetY;
    private boolean selected = false;

    private final int WIDTH = 140;
    private final int HEIGHT = 80;

    public EditorObject(int x, int y) {
        setBounds(x, y, WIDTH, HEIGHT);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                requestFocusInWindow();
                offsetX = e.getX();
                offsetY = e.getY();
                setSelected(true);
            }
        });

        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                int newX = getX() + e.getX() - offsetX;
                int newY = getY() + e.getY() - offsetY;
                setLocation(newX, newY);
            }
        });
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        g2.setColor(Color.WHITE);
        g2.fillRect(0, 0, getWidth(), getHeight());
        g2.setColor(Color.GRAY);
        g2.setStroke(new BasicStroke(4));

        if (selected) {
            g2.setColor(Color.BLACK);
            g2.setStroke(new BasicStroke(7));
        }

        g2.drawRect(0, 0, getWidth(), getHeight());
    }

}
