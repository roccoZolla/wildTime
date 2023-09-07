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
    private static GUIManager guiManager = new GUIManager();
    private static GameDescription game;
    private static Parser parser = new Parser();
    
    public GameManager(GameDescription game) {
        GameManager.game = game;
    }
    
    public static void setGame(GameDescription game) {
        GameManager.game = game;
    }
    
    public void Start() {
        guiManager.openStartFrame(this);
    }
    
    public void startNewGame(File save) {
        Utils.Save(game);
        guiManager.openGameFrame();
        guiManager.setInformationGame(game);
        guiManager.updateGameFrame(game.getPlayer().getCurrentPlace().getDescription());
    }
    
    public void continueGame(File save){
        guiManager.openGameFrame(Utils.LoadGame(game, save));
        guiManager.setInformationGame(game);
        guiManager.updateGameFrame(game.getPlayer().getCurrentPlace().getDescription());
    }
    
    // ottiene il testo direttamente da GameFrame
    public static void readCommand(String command) {
        // flag per capire se è attivo il dialogo
        boolean isTalking = false;
        
        // analizza comando
        ParserOutput p = new ParserOutput();
        p = parser.parse(command, game);
        
        // verifica se è in corso un dialogo
        if(p.getNpc() != null && p.getCommand() == null) { // DA SISTEMARE HA BISOGNO DEL NPC
            System.out.println("Tizio che parla: " + p.getNpc().getName());
            System.out.println("Sta parlando? " + p.getNpc().getIsTalking());
            if(p.getNpc().getIsTalking() && p.getConversation() != null) { // npc parla e la conversazione non è nulla
                guiManager.updateGameFrame(p.getNpc().getName().toUpperCase() + ": " + p.getConversation().getAnswer());
            } else {
                guiManager.updateGameFrame(p.getNpc().getName().toUpperCase() + ": Non capisco quello che mi vuoi dire...");
            }
        } else if(p == null || p.getCommand() == null) { // esegui azione
            guiManager.updateGameFrame("Non capisco quello che mi vuoi dire...");
        } else if (p.getCommand().getType().equals(CommandType.SAVE)) { // introdurre variabili? per evitare che il confronto avvenga in questa classe?
            guiManager.updateGameFrame(Utils.Save(game));
        } else if(p.getCommand().getType().equals(CommandType.CLEAN)) {
            guiManager.cleanGameFrame();
            guiManager.updateGameFrame(game.getPlayer().getCurrentPlace().getDescription());
        } else if(p.getCommand().getType().equals(CommandType.END)) {
            guiManager.updateGameFrame("Arrivederci!");
            
            // lambda expr
            EventQueue.invokeLater(() -> {
                try {
                    Thread.sleep(1300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                guiManager.EndsGame();
            });
        } else {
            guiManager.updateGameFrame(Utils.NextMove(p, game.getPlayer()));
            guiManager.setInformationGame(game);
            
            // quando muori vieni riportato nel luogo di inizio della storia
            if(game.getPlayer().getHp() <= 0) {
                guiManager.updateGameFrame("Ops sei morto!\n"
                        + "Il nobile mercenario stremato viene riportato nel luogo dove la sua avventura è cominciata");
                game.getPlayer().setHp((int) (game.getPlayer().getMaxHP() * 0.3));
                game.getPlayer().setCurrentPlace(game.getRooms().get(0));
                guiManager.updateGameFrame(game.getRooms().get(0).getDescription());
                guiManager.setInformationGame(game);
            }

            // se hai ti trovi nella stanza finale e hai sconfitto il boss
            // termina la partita
            if(Utils.Final(game.getPlayer())){
                guiManager.updateGameFrame("Hai vinto + cazzate varie");
                guiManager.updateGameFrame("Arrivederci!");
            
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
        
    }
    
    
    
}
