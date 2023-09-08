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
    //Solo per fare i precisi usiamo final perchè non vogliamo che vengano modificati di nuovo
    //dopo averli inizializzati
    private static final GUIManager guiManager = new GUIManager();
    private static GameDescription game;
    private static final Parser parser = new Parser();
    
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
        //Viene usata questa variabile?
        boolean isTalking = false;
        
        // analizza comando
        ParserOutput p = new ParserOutput();
        p = parser.parse(command, game);
        
        // verifica se è in corso un dialogo
        //Il controllo sul null va fatto prima di tutto
        //altrimenti se p è null e cerchi di usare le robe all'interno (tipo p.getNpc()) va in eccezione
        //A questo punto secondo me è inutile controllare qui p.getCommand() se è null
        //altrimenti se lo dovesse essere non andrebbe mai controllato nll'if di sotto
        //CONTROLLA QUESTA COSA if(p == null || p.getCommand() == null)
        if(p == null) { // esegui azione
            guiManager.updateGameFrame("Non capisco quello che mi vuoi dire...");
        }
        else if(p.getNpc() != null && p.getCommand() == null) { // DA SISTEMARE HA BISOGNO DEL NPC
            System.out.println("Tizio che parla: " + p.getNpc().getName());
            System.out.println("Sta parlando? " + p.getNpc().getIsTalking());
            if(p.getNpc().getIsTalking() && p.getConversation() != null) { // npc parla e la conversazione non è nulla
                guiManager.updateGameFrame(p.getNpc().getName().toUpperCase() + ": " + p.getConversation().getAnswer());
            } else {
                guiManager.updateGameFrame(p.getNpc().getName().toUpperCase() + ": Non capisco quello che mi vuoi dire...");
            }
        } else if (p.getCommand().getType().equals(CommandType.SAVE)) { // introdurre variabili? per evitare che il confronto avvenga in questa classe?
            guiManager.updateGameFrame(Utils.Save(game));
        } else if(p.getCommand().getType().equals(CommandType.CLEAN)) {
            guiManager.cleanGameFrame();
            guiManager.updateGameFrame(game.getPlayer().getCurrentPlace().getDescription());
        } else if(p.getCommand().getType().equals(CommandType.END)) {
            guiManager.updateGameFrame("Arrivederci!");
            //Come scritto dopo usa i metodi per non duplicare il codice
            PutThreadToSleep();
        } else {
            guiManager.updateGameFrame(Utils.NextMove(p, game.getPlayer()));
            //Non tocco perchè non so la logica però controlla
            //E' necessario che ci sia un guiManager.setInformationGame(game) ripetuto qui e in CheckPlayerDeath?
            //Non basterebbe metterne solo uno alla fine di questo else?
            guiManager.setInformationGame(game);
            
            //Organizza in metodi cosicchè sia più leggibile e nel caso riutilizzabile
            CheckPlayerDeath();
            CheckGameWin();
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
            //Controlla questo come scritto prima
            guiManager.setInformationGame(game);
        }
    }
    
    private static void CheckGameWin(){
        // se hai ti trovi nella stanza finale e hai sconfitto il boss
        // termina la partita
        if(Utils.Final(game.getPlayer())){
            guiManager.updateGameFrame("Hai vinto + cazzate varie");
            guiManager.updateGameFrame("Arrivederci!");
            //Come scritto prima usa i metodi per non duplicare il codice
            PutThreadToSleep();
        }
    }
    
    private static void PutThreadToSleep(){
        // lambda expr
        //Come mai per chiudere il gioco metti il Thread in pausa per 1 secondo e 3?
        //Non so la logica quindi non modifico però controlla che non sia meglio usare Thread.stopRunning se l'intenzione è di stopparlo
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
