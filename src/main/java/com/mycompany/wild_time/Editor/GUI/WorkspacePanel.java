package com.mycompany.wild_time.Editor.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class WorkspacePanel extends JPanel {

    private List<EditorObject> objects = new ArrayList<>();
    private EditorObject selectedObject = null;

    public WorkspacePanel() {
        setLayout(null);
        setBackground(new Color(230, 230, 230));

        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                clearSelection();
                requestFocusInWindow();
            }
        });

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_C) {
                    deleteSelected();
                }
            }
        });
    }

    public void addObject(EditorObject obj) {
        objects.add(obj);

        obj.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                setSelected(obj);
                e.consume();
            }
        });

        add(obj);
        repaint();
    }

    public void setSelected(EditorObject obj) {
        clearSelection();
        selectedObject = obj;
        obj.setSelected(true);
    }

    public void clearSelection() {
        if (selectedObject != null) {
            selectedObject.setSelected(false);
            selectedObject = null;
            repaint();
        }
    }

    private void deleteSelected() {
        if (selectedObject != null) {
            objects.remove(selectedObject);
            remove(selectedObject);
            selectedObject = null;
            repaint();
            revalidate();
        }
    }
}
