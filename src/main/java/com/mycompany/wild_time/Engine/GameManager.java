/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.wild_time.Engine;

import com.mycompany.wild_time.Parser.Parser;
import com.mycompany.wild_time.Parser.ParserOutput;
import com.mycompany.wild_time.Type.CommandType;
import java.io.File;


/**
 *
 * @author rocco
 */
public class GameManager {
    private static GUIManager guiManager;
    private static GameDescription game;
    private static Parser parser = new Parser();
    
    public GameManager(GUIManager guiManager, GameDescription game) {
        this.guiManager = guiManager;
        this.game = game;
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
         
        for(int i = 0; i < game.getCommands().size(); i++) {
            System.out.println(game.getCommands().get(i).getName() + "\n");
        }
        
        for(int i = 0; i < game.getNpcs().size(); i++) {
            System.out.println(game.getNpcs().get(i).getName() + "\n");
        }
    }
    
    public void continueGame(File save){
        guiManager.openGameFrame(Utils.LoadGame(game, save));
        guiManager.setInformationGame(game);
        guiManager.updateGameFrame(game.getPlayer().getCurrentPlace().getDescription());
        for(int i = 0; i < game.getCommands().size(); i++) {
            System.out.println(game.getCommands().get(i).getName() + "\n");
        }
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
            if(p.getNpc().getIsTalking() && p.getConversation() != null) {
                guiManager.updateGameFrame(p.getNpc().getName().toUpperCase() + ": " + p.getConversation().getAnswer());
            } else {
                guiManager.updateGameFrame(p.getNpc().getName().toUpperCase() + ": Non capisco quello che mi vuoi dire...");
            }
        } else if(p == null || p.getCommand() == null) { // esegui azione
            guiManager.updateGameFrame("Non capisco quello che mi vuoi dire");
        } else if (p.getCommand().getType().equals(CommandType.SAVE)) {
            guiManager.updateGameFrame(Utils.Save(game));
        } else if(p.getCommand().getType().equals(CommandType.CLEAN)) {
            guiManager.cleanGameFrame();
            guiManager.updateGameFrame(game.getPlayer().getCurrentPlace().getDescription());
        } /* else if(p.getCommand().getType().equals(CommandType.END)) {
            // DA SISTEMARE 
            // BUG: quando chuiudo il gameframe e avvio una nuova partita
            // l'istanza del gameManager della partita precedente rimane attiva
            guiManager.setVisibleStartFrame();
            guiManager.closeGameFrame();  
        }*/ else {
            guiManager.updateGameFrame(Utils.NextMove(p, game.getPlayer()));
            guiManager.setInformationGame(game);
            
            // se la vita scende a zero dopo un attacco termina la partita?
            // o riprende dall'ultimo salvataggio? 
        }
        
    }
    
    
    
}
