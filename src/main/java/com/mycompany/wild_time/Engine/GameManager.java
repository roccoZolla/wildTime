/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.wild_time.Engine;

import com.mycompany.wild_time.Parser.Parser;
import com.mycompany.wild_time.Parser.ParserOutput;
import com.mycompany.wild_time.Type.CommandType;
import java.awt.EventQueue;
import java.io.File;


/**
 *
 * @author rocco
 */
public class GameManager {
    private static final GUIManager guiManager = new GUIManager();
    private static GameDescription game;
    private static final Parser parser = new Parser();
    private static boolean isTalking = false;
    
    public GameManager(GameDescription game) {
        GameManager.game = game;
    }
    
    public static void setGame(GameDescription game) {
        GameManager.game = game;
    }
    
    public static boolean isTalking() {
        return isTalking;
    }
    
    public static void setIsTalking(boolean isTalking) {
        GameManager.isTalking = isTalking;
    }
    
    public void Start() {
        guiManager.openStartFrame();
    }
    
    public static void startNewGame(File save) {
        Utils.Save(game);
        guiManager.openGameFrame();
        guiManager.setInformationGame(game);
        guiManager.updateGameFrame(game.getPlayer().getCurrentPlace().getDescription());
    }
    
    public static void continueGame(File save){
        guiManager.openGameFrame(Utils.LoadGame(game, save));
        guiManager.setInformationGame(game);
        guiManager.updateGameFrame(game.getPlayer().getCurrentPlace().getDescription());
    }
    
    // ottiene il testo direttamente da GameFrame
    public static void readCommand(String command) {
        // analizza comando
        ParserOutput p = new ParserOutput();
        p = parser.parse(command, game);
        
        // se il comando è nullo o il comando è nullo e non è in corso una conversazione 
        if((p == null || p.getCommand() == null) && !isTalking) { 
            guiManager.updateGameFrame("Non capisco quello che mi vuoi dire...");
        } 
        
        else if(p.getNpc() != null && p.getCommand() == null && isTalking) { 
            System.out.println("Tizio che parla: " + p.getNpc().getName());
            System.out.println("Sta parlando? " + p.getNpc().getIsTalking());
            if(p.getNpc().getIsTalking() && p.getConversation() != null) { // npc parla e la conversazione non è nulla
                guiManager.updateGameFrame(p.getNpc().getName().toUpperCase() + ": " + p.getConversation().getAnswer());
            } else {
                guiManager.updateGameFrame(p.getNpc().getName().toUpperCase() + ": Non capisco quello che mi vuoi dire...");
            }
        } 
        
        else {
            CommandType type = p.getCommand().getType();
            switch(type){
                case SAVE: 
                    guiManager.updateGameFrame(Utils.Save(game));
                    break;
                case CLEAN: 
                    guiManager.cleanGameFrame();
                    guiManager.updateGameFrame(game.getPlayer().getCurrentPlace().getDescription());
                    break;
                case END: 
                    guiManager.updateGameFrame("Arrivederci!");
                    PutThreadToSleep();
                    break;
                default: 
                    guiManager.updateGameFrame(Utils.NextMove(p, game.getPlayer()));
                    //Non tocco perchè non so la logica però controlla
                    //E' necessario che ci sia un guiManager.setInformationGame(game) ripetuto qui e in CheckPlayerDeath?
                    //Non basterebbe metterne solo uno alla fine di questo else?
                    guiManager.setInformationGame(game);
                    CheckPlayerDeath();
                    CheckGameWin();
                    
                    break;
            }
        }
    }
    
    private static void CheckPlayerDeath(){
        // quando muori vieni riportato nel luogo di inizio della storia
        if(game.getPlayer().getHp() <= 0) {
            guiManager.updateGameFrame("Ops sei morto!\n"
                    + "Il nobile mercenario stremato viene riportato nel luogo dove la sua avventura è cominciata");
            game.getPlayer().setHp((int) (game.getPlayer().getMaxHP() * 0.3));
            game.getPlayer().setCurrentPlace(game.getRooms().get(0));
            guiManager.updateGameFrame(game.getRooms().get(0).getDescription());
            guiManager.setInformationGame(game);
        }
    }
    
    private static void CheckGameWin(){
        // se hai ti trovi nella stanza finale e hai sconfitto il boss
        // termina la partita
        if(Utils.Final(game.getPlayer())){
            guiManager.updateGameFrame("Hai vinto + cazzate varie");
            guiManager.updateGameFrame("Arrivederci!");
            PutThreadToSleep();
        }
    }
    
    private static void PutThreadToSleep(){
        // lambda expr
        EventQueue.invokeLater(() -> {
            try {
                Thread.sleep(1300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            guiManager.EndsGame();
        });
    }
    
}
