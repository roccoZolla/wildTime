/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.wild_time;

import com.mycompany.wild_time.Engine.GameManager;

/**
 *
 * @author rocco
 */
public class GameFrame extends javax.swing.JFrame {
    /**
     * Creates new form GameFrame
     */
    public GameFrame() {
        initComponents();
        
        setSize(800, 500);
        setLocationRelativeTo(null); 
    }
    
    public GameFrame(String text) {
        initComponents();
        storyArea.append(text);
        
        setSize(800, 500);
        setLocationRelativeTo(null); 
    }
    
    public void setHpField(int playerHP){
        hpField.setText("HP: " + playerHP);
    }
    
    public void setAttackField(int playerAttack, String weaponName){
        attackField.setText(weaponName + ": " + playerAttack);
    }
        
    public void setArmorField(int playerArmor, String shieldName){
        armorField.setText(shieldName + ": " + playerArmor);
    }
            
    public void setPlaceArea(String playerPlace){
        placeArea.setText("Place: " + playerPlace);
    }
    
    public void updateStoryArea(String text) {
        storyArea.append(text);
        storyArea.append("\n");
    }
    
    public void cleanStoryArea() {
        storyArea.setText("");
    }
    
    public void setTitleFrame(String titleGame) {
        setTitle(titleGame);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jSplitPane1 = new javax.swing.JSplitPane();
        jPanel1 = new javax.swing.JPanel();
        armorField = new javax.swing.JTextField();
        attackField = new javax.swing.JTextField();
        hpField = new javax.swing.JTextField();
        placeArea = new javax.swing.JTextArea();
        equipLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        storyArea = new javax.swing.JTextArea();
        textField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Game frame");

        jSplitPane1.setDividerLocation(160);
        jSplitPane1.setEnabled(false);

        jPanel1.setLayout(new java.awt.GridBagLayout());

        armorField.setEditable(false);
        armorField.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        armorField.setText("Armor: ");
        armorField.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        jPanel1.add(armorField, gridBagConstraints);

        attackField.setEditable(false);
        attackField.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        attackField.setText("Attack: ");
        attackField.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        jPanel1.add(attackField, gridBagConstraints);

        hpField.setEditable(false);
        hpField.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        hpField.setText("HP:");
        hpField.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 1);
        jPanel1.add(hpField, gridBagConstraints);

        placeArea.setEditable(false);
        placeArea.setColumns(20);
        placeArea.setLineWrap(true);
        placeArea.setRows(5);
        placeArea.setText("lezzo");
        placeArea.setWrapStyleWord(true);
        placeArea.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 7;
        jPanel1.add(placeArea, gridBagConstraints);

        equipLabel.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        equipLabel.setText("Equipment");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(15, 0, 0, 0);
        jPanel1.add(equipLabel, gridBagConstraints);

        jSplitPane1.setLeftComponent(jPanel1);

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        storyArea.setEditable(false);
        storyArea.setLineWrap(true);
        storyArea.setWrapStyleWord(true);
        storyArea.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jScrollPane1.setViewportView(storyArea);

        jSplitPane1.setRightComponent(jScrollPane1);

        getContentPane().add(jSplitPane1, java.awt.BorderLayout.CENTER);

        textField.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        textField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldActionPerformed(evt);
            }
        });
        getContentPane().add(textField, java.awt.BorderLayout.PAGE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void textFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldActionPerformed
       storyArea.append(textField.getText());
       storyArea.append("\n");
       
       GameManager.readCommand(textField.getText());
       
       textField.setText("");
    }//GEN-LAST:event_textFieldActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField armorField;
    private javax.swing.JTextField attackField;
    private javax.swing.JLabel equipLabel;
    private javax.swing.JTextField hpField;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JTextArea placeArea;
    private javax.swing.JTextArea storyArea;
    private javax.swing.JTextField textField;
    // End of variables declaration//GEN-END:variables
}
