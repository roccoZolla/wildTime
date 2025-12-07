package com.mycompany.wild_time.Editor;

import com.mycompany.wild_time.Editor.GUI.EditorAction;
import com.mycompany.wild_time.Editor.GUI.EditorGUIManager;

import javax.swing.*;

public class Editor {

    private final EditorGUIManager editorGUIManager;

    private Runnable onExitCallback;

    public Editor() {
        this.editorGUIManager = new EditorGUIManager();
    }

    public void setOnExit(Runnable callback) {
        this.onExitCallback = callback;
    }

    public void start() {
        this.editorGUIManager.showEditorFrame(this::handleEditorAction);
    }

    private void handleEditorAction(EditorAction action) {
        switch (action) {
            case SAVE:
                if (editorGUIManager.showSaveDialog() == 0) {
                    stopEditor();
                }
                break;

            case CANCEL:
                editorGUIManager.showCancelDialog();

                if (editorGUIManager.showSaveDialog() == 0) {
                    stopEditor();
                }
                break;
        }
    }

    private void stopEditor() {
        editorGUIManager.disposeEditorFrame();

        if (onExitCallback != null) {
            onExitCallback.run();
        }
    }
}
