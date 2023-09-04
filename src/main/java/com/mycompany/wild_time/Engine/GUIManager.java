/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.wild_time.Engine;

import com.mycompany.wild_time.GameFrame;
import com.mycompany.wild_time.StartFrame;

/**
 *
 * @author rocco
 */

// classe per la gestione dell'interfaccia utente
public class GUIManager{
    private StartFrame initFrame;
    private GameFrame gameFrame;

    public GUIManager() {

    }

    public void openStartFrame(GameManager gm) {
        if(initFrame != null) {
            initFrame.dispose();
        }
        
        initFrame = new StartFrame(gm);
        initFrame.setVisible(true);
    }
    
    public void openGameFrame() {                       // apertura finestra da nuova partita
        if(gameFrame != null) {
            gameFrame.dispose();
        }
        
        gameFrame = new GameFrame(); 
        gameFrame.setVisible(true);
    }
    
    public void openGameFrame(String text) {                // apertura finestra con file di salvataggio
        if(gameFrame != null) {
            gameFrame.dispose();
        }
        
        gameFrame = new GameFrame(text);        
        gameFrame.setVisible(true);
    }
    
    public void setInformationGame(GameDescription game) {
        gameFrame.setHpField(game.getPlayer().getHp());                       
        gameFrame.setAttackField(game.getPlayer().getArma().getAttackDamage(), game.getPlayer().getArma().getName());
        gameFrame.setArmorField(game.getPlayer().getScudo().getDefenseBonus(), game.getPlayer().getScudo().getName());
        gameFrame.setPlaceArea(game.getPlayer().getCurrentPlace().getName());
        gameFrame.setTitleFrame(game.getTitle());
    }
    
    public void updateGameFrame(String text) {
        gameFrame.updateStoryArea(text);
    }
    
    public void cleanGameFrame() {
        gameFrame.cleanStoryArea();
    }
    
    public void closeGameFrame() {
        gameFrame.dispose();
    }
    
    public void setVisibleStartFrame() {
        initFrame.setVisible(true);
    }
}
