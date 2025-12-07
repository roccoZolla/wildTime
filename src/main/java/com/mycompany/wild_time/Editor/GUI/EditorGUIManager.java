package com.mycompany.wild_time.Editor.GUI;

import javax.swing.*;

public class EditorGUIManager {

    private EditorFrame editorFrame;

    public void showEditorFrame() {
        SwingUtilities.invokeLater(() -> {
            if (this.editorFrame == null) {
                System.out.println("--- editor frame null, lo creo ---");
                this.editorFrame = new EditorFrame();
            }

            this.editorFrame.setVisible(true);
        });
    }

    public void disposeEditorFrame() {
        SwingUtilities.invokeLater(() -> {
            if(this.editorFrame != null) {

                System.out.println("--- dispose editor frame ---");

                this.editorFrame.dispose();
                this.editorFrame = null;
            }
        });
    }
}
