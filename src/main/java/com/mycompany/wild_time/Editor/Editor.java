package com.mycompany.wild_time.Editor;

import com.mycompany.wild_time.Editor.GUI.EditorGUIManager;

public class Editor {

    private final EditorGUIManager editorGUIManager;

    public Editor() {
        this.editorGUIManager = new EditorGUIManager();
    }

    public void start() {
        this.editorGUIManager.showEditorFrame();
    }
}
