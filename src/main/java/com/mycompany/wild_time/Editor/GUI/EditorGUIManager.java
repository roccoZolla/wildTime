package com.mycompany.wild_time.Editor.GUI;

import javax.swing.*;

public class EditorGUIManager {

    private EditorFrame editorFrame;

    public void showEditorFrame(EditorListener listener) {
        SwingUtilities.invokeLater(() -> {
            if (this.editorFrame == null) {
                System.out.println("--- editor frame null, lo creo ---");
                this.editorFrame = new EditorFrame(listener);
            }

            this.editorFrame.setVisible(true);
        });
    }

    public void disposeEditorFrame() {
        SwingUtilities.invokeLater(() -> {
            if (this.editorFrame != null) {

                System.out.println("--- dispose editor frame ---");

                this.editorFrame.dispose();
                this.editorFrame = null;
            }
        });
    }

    public int showSaveDialog() {
        return JOptionPane.showConfirmDialog(
                null,
                "Do you want to save?",
                "Save",
                JOptionPane.OK_CANCEL_OPTION
        );

    }

    public int showCancelDialog() {
        return JOptionPane.showConfirmDialog(
                null,
                "Are you sure?",
                "Back to menu",
                JOptionPane.OK_CANCEL_OPTION
        );
    }
}
