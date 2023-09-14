/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.wild_time.Engine;

import com.mycompany.wild_time.Parser.ParserOutput;
import com.mycompany.wild_time.Type.CommandType;
import com.mycompany.wild_time.Type.Player;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author rocco
 */

public class Utils {    
    public static String LoadGame(GameDescription game, File saveFile) {
        String text = "";
        
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(saveFile))) {
            game = (GameDescription) inputStream.readObject();
            GameManager.setGame(game);
            text = "Gioco caricato con successo!\n";
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        
        return text;
    }
    
    public static String Save(GameDescription game) {
        String text = "";
        
        String userDir = System.getProperty("user.dir");
        String outputFile = userDir + File.separator + "save.dat";
        
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(outputFile))) {
            outputStream.writeObject(game);
            text = "Gioco Salvato con successo!\n";
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return text;
    }
    
    public static String NextMove(ParserOutput p, Player player1) {
        String text = "";
        CommandType type = p.getCommand().getType();
        
        if(p.getCommand() == null) {
            text = "Non capisco quello che mi vuoi dire...";
        } else {
            switch(type) {
                case NORD:
                    if (player1.getCurrentPlace().getNord() != null && !player1.getCurrentPlace().getNord().getBlocked()) {
                        player1.setCurrentPlace(player1.getCurrentPlace().getNord());
                        
                        // se non è stata esplorata
                        if(!player1.getCurrentPlace().getNord().getExplored()) {
                            player1.getCurrentPlace().getNord().setExplored(true);
                        }
                        
                        text = player1.getCurrentPlace().getDescription();
                        
                    } else {
                        if(player1.getCurrentPlace().getNord() != null && player1.getCurrentPlace().getNord().getBlocked())
                            text = "Sembra ci sia qualcosa che ostruisce il passaggio...";
                        else
                            text = "Non c'è niente da questa parte";
                    }
                    break;
                    
                case SOUTH:
                    if (player1.getCurrentPlace().getSouth() != null && !player1.getCurrentPlace().getSouth().getBlocked()) {
                        player1.setCurrentPlace(player1.getCurrentPlace().getSouth());
                        
                        // se non è stata esplorata
                        if(!player1.getCurrentPlace().getSouth().getExplored()) {
                            player1.getCurrentPlace().getSouth().setExplored(true);
                        }
                        
                        text = player1.getCurrentPlace().getDescription();
                    } else {
                        if(player1.getCurrentPlace().getSouth() != null && player1.getCurrentPlace().getSouth().getBlocked())
                            text = "Sembra ci sia qualcosa che ostruisce il passaggio...";
                        else
                            text = "Non c'è niente da questa parte";
                    }
                    break;
                    
                case EAST:
                    if (player1.getCurrentPlace().getEst() != null && !player1.getCurrentPlace().getEst().getBlocked()) {
                        player1.setCurrentPlace(player1.getCurrentPlace().getEst());
                        
                        // se non è stata esplorata
                        if(!player1.getCurrentPlace().getEst().getExplored()) {
                            player1.getCurrentPlace().getEst().setExplored(true);
                        }
                        
                        text = player1.getCurrentPlace().getDescription();
                    } else {
                        if(player1.getCurrentPlace().getEst() != null && player1.getCurrentPlace().getEst().getBlocked())
                            text = "Sembra ci sia qualcosa che ostruisce il passaggio...";
                        else 
                            text = "Non c'è niente da questa parte";
                    }
                    break;
                    
                case WEST:  
                    if (player1.getCurrentPlace().getWest() != null && !player1.getCurrentPlace().getWest().getBlocked()) {
                        player1.setCurrentPlace(player1.getCurrentPlace().getWest());
                        
                        // se non è stata esplorata
                        if(!player1.getCurrentPlace().getWest().getExplored()) {
                            player1.getCurrentPlace().getWest().setExplored(true);
                        }
                        
                        text = player1.getCurrentPlace().getDescription();
                    } else {
                        if(player1.getCurrentPlace().getWest() != null && player1.getCurrentPlace().getWest().getBlocked())
                            text = "Sembra ci sia qualcosa che ostruisce il passaggio...";
                        else
                            text = "Non c'è niente da questa parte";
                    } 
                    break;
                    
                case PICK_UP:   // raccogli gli oggetti
                    if(p.getObject() == null) {
                        if(p.getChestObject() != null) {
                            text = "Come fai a mettere una cassa in quello zainetto minuscolo?";
                        } else {
                            text = "Non c'è nessuno oggetto che si chiami cosi";
                        }                    
                    } else if(player1.getCurrentPlace().getItems().isEmpty()) {
                        text = "Non c'è niente da raccogliere in questa stanza!";
                    } else if(!p.getObject().isTakeable()) {
                        text = "Per qualche strana ragione non puoi raccogliere questo oggetto";
                    } else if(player1.getInventory().getList().contains(p.getObject())) {
                        text = "Hai gia raccolto questo oggetto!";
                    } else {
                        for(int i = 0; i < player1.getCurrentPlace().getItems().size(); i++) {
                            if(p.getObject().equals(player1.getCurrentPlace().getItems().get(i))) {                           
                                player1.getInventory().getList().add(player1.getCurrentPlace().getItems().get(i));
                                text = "Hai raccolto: " + player1.getCurrentPlace().getItems().get(i).getName();
                                text += ". " + player1.getCurrentPlace().getItems().get(i).getDescription();
                                player1.getCurrentPlace().getItems().remove(i);
                            }
                        }
                    }
                    break;
                    
                case LOOK_AT:   // cosa c'è nella stanza
                    if (!player1.getCurrentPlace().getItems().isEmpty() || !player1.getCurrentPlace().getChest().getList().isEmpty()) {
                        text = "Nella stanza sono presenti: ";
                        for(int i = 0; i < player1.getCurrentPlace().getItems().size(); i++) {
                            text += player1.getCurrentPlace().getItems().get(i).getName() + " ";
                        }

                        text += player1.getCurrentPlace().getChest().getName();
                    } else {
                        text = "Non c'è niente di particolare in questa stanza";
                    }
                
                    if(!player1.getCurrentPlace().getNpcs().isEmpty()){
                        // guarda se sono presenti npcs
                            text += "\nOh, ma c'è qualcuno qui:\n";

                        for(int i = 0; i < player1.getCurrentPlace().getNpcs().size(); i++) {
                            if(player1.getCurrentPlace().getNpcs().get(i).getHp() <= 0) {
                                text += "+" + player1.getCurrentPlace().getNpcs().get(i).getName() + "+";
                            } else {
                                text += player1.getCurrentPlace().getNpcs().get(i).getName() + ". " + player1.getCurrentPlace().getNpcs().get(i).getDescription() + "\n";
                            }
                        }
                    }
                    break;
                    
                case INVENTORY:     // mostra lo zaino
                    if(!player1.getInventory().getList().isEmpty()) {
                        text = "Nello zaino hai: ";
                        
                        for(int i = 0; i < player1.getInventory().getList().size(); i++) {
                            if(!player1.getInventory().getList().get(i).isUseable()) {
                                text += "-" + player1.getInventory().getList().get(i).getName()+ "-" + " ";
                            } else {
                                text += player1.getInventory().getList().get(i).getName() + " ";
                            }
                        }
                    } else {
                        text = "Non hai niente nello zaino!";
                    }
                    break;
                    
                case OPEN:      // apri le casse con l'oggetto adatto
                    if(p.getObject() == null) {
                        text = "Non è l'oggetto giusto per aprire qualcosa...";                  
                    } else if(p.getChestObject().getIsOpen()) {
                        text = "Hai gia aperto questa cassa!";
                    } else {
                        if(p.getObject().isUseable() && p.getChestObject().getKey().equals(p.getObject())) {
                            text = "Hai aperto la cassa! \nLa cassa contiene: ";
                        
                            for(int i = 0; i < player1.getCurrentPlace().getChest().getList().size(); i++)  {
                                // ottengo gli elementi presenti nella cassa e li inserisco
                                // nella lista degli oggetti presenti nella stanza
                                player1.getCurrentPlace().getItems().add(player1.getCurrentPlace().getChest().getList().get(i));
                            
                                text += player1.getCurrentPlace().getChest().getList().get(i).getName() + " ";
                            }       
                        
                            // la cassa risultera aperta
                            player1.getCurrentPlace().getChest().setIsOpen(true);
                        
                            // la chiave diventa inutilizzabile
                            int n = player1.getInventory().getList().indexOf(p.getObject());
                            player1.getInventory().getList().get(n).setUseable(false);
                            
                            // rimuovo tutti gli oggetti presenti nella cassa
                            player1.getCurrentPlace().getChest().getList().removeAll(player1.getCurrentPlace().getChest().getList());
                        } else {
                            text = "Non è possbile aprire questo oggetto";
                        }
                    }
                    break;
                    
                case EAT:   // mangia o bevi, dicreati
                    if(p.getObject() == null) {
                        text = "Il nulla non è un qualcosa che si puo usare...";
                    } else if(!player1.getInventory().getList().contains(p.getObject())) {
                        text = "Non puoi mangiare o bere un oggetto che non è presente nel tuo zaino!";
                    } else if(!p.getObject().isUseable()) {
                        text = "Non puoi mangiare o bere questo oggetto!";
                    } else {
                        if(p.getObject().IsHeal()) {        // curativo
                            if(player1.getHp() == player1.getMaxHP()) {
                                text = "Stai bene, non serve";
                            } else {
                                player1.setHp(player1.getHp() + p.getObject().getBonus());

                                if(player1.getHp() > player1.getMaxHP())
                                    player1.setHp(player1.getMaxHP());

                                // rendi l'oggetto non piu utilizzabile
                                player1.getInventory().getList().get(player1.getInventory().getList().indexOf(p.getObject())).setUseable(false);

                                text = "Hai recuperato " + p.getObject().getBonus() + " HP"; 
                            }

                        } 
                        
                        else if(p.getObject().IsPowerUp()) { // potenziamento
                            if(p.getObject().IsWeapon()){       // arma
                                if(p.getObject().getAttackDamage() != 0) {      // potenzia attacco
                                    player1.getArma().setAttackDamage(player1.getArma().getAttackDamage() + p.getObject().getAttackDamage());
                                    text = "Attacco dell'arma aumentato di: " + p.getObject().getAttackDamage() + "\n";
                                } 
                                
                                else if(p.getObject().getDefenseBonus() != 0){  // potenzia difesa
                                    player1.getScudo().setDefenseBonus(player1.getScudo().getDefenseBonus() + p.getObject().getDefenseBonus());
                                    text = "Difesa dello scudo aumentato di: " + p.getObject().getDefenseBonus() + "\n";
                                }
                                
                                player1.getInventory().getList().get(player1.getInventory().getList().indexOf(p.getObject())).setUseable(false);
                            } 
                            
                            else {                  // potenziamento vita
                                player1.setMaxHP(player1.getMaxHP() + p.getObject().getBonus());
                                player1.setHp(player1.getHp() + p.getObject().getBonus());
                                
                                text = "Salute aumentata di: " + p.getObject().getBonus() + " HP\n";
                            }
                        }

                    }
                    break;
                    
                case EQUIP:     // equipaggia le armi
                    if(p.getObject() == null) {
                        text = "Il nulla non è un qualcosa che si puo usare...";
                    } else if(!player1.getInventory().getList().contains(p.getObject())) {
                        text = "Non puoi equipaggiare un oggetto che non è presente nel tuo zaino!";
                    } else if(!p.getObject().isUseable() || !p.getObject().IsWeapon() || p.getObject().IsPowerUp()) {
                        text = "Non puoi equipaggiare questo oggetto!";
                    } else {   
                        player1.getInventory().getList().remove(p.getObject());
                    
                        if(p.getObject().getAttackDamage() > 0) {
                            player1.getInventory().getList().add(player1.getArma());
                            player1.setArma(p.getObject());
                        
                            text = "Hai equipaggiato: " + player1.getArma().getName();
                        } else if (p.getObject().getDefenseBonus() > 0) {
                            player1.getInventory().getList().add(player1.getScudo());
                            player1.setScudo(p.getObject());
                        
                            text = "Hai equipaggiato: " + player1.getScudo().getName();
                        }
                    }
                    break;
                    
                case ATTACK:    // attacca 
                    int attack = 0;
                    int defense = 0;
                    int damage = 0;
                    double reductionPercentage = 0.03;
                
                    if(p.getNpc() == null) {
                        text = "Non puoi attaccare qualcosa che non c'è";
                    } else if(!player1.getCurrentPlace().getNpcs().contains(p.getNpc())){
                        text = "Vuoi attaccare qualcuno che non è qui...";
                    } else if(!p.getNpc().getIsEnemy()) {
                        text = "Perche attaccare qualcuno che non è neanche un nemico?";
                    } else if(p.getNpc().getHp() <= 0) {
                        text = "Non puoi attaccare qualcuno che è gia morto!";
                    } else {
                        attack = player1.getArma().getAttackDamage();
                        defense = p.getNpc().getScudo().getDefenseBonus();
                    
                        damage = (int) ((int) attack - (attack * (defense * reductionPercentage)));
                    
                        p.getNpc().setHp(p.getNpc().getHp() - damage);
                    
                        if(p.getNpc().getHp() <= 0){
                            text = p.getNpc().getName().toUpperCase() + ": E' stato un piacere mercenario\n";
                            if(p.getNpc().getReward() != null) {
                                text += p.getNpc().getName().toUpperCase() + " ha lasciato cadere: " + p.getNpc().getReward().getName();
                                player1.getCurrentPlace().getItems().add(p.getNpc().getReward());
                            }
                        } else {
                            text = p.getNpc().getName().toUpperCase() + " HP: " + p.getNpc().getHp() + "\n";
                            text += p.getNpc().getName().toUpperCase() + ": Tocca ammazzarti!";
                        
                            attack = p.getNpc().getArma().getAttackDamage();
                            defense = player1.getScudo().getDefenseBonus();
                        
                            damage = (int) ((int) attack - (attack * (defense * reductionPercentage)));
                        
                            text += "\nDanno subito: " + damage;
                        
                            player1.setHp(player1.getHp() - damage);
                        }
                    }
                    break;
                    
                case TALK_TO: // parla con gli npc
                    if(p.getNpc() == null) {
                        text = "Non puoi parlare con qualcuno che non c'è...";
                    } else if(!player1.getCurrentPlace().getNpcs().contains(p.getNpc())) {
                        text = "Non puoi parlare con qualcuno che non è qui...";
                    } else if(p.getNpc().getHp() <= 0){
                        text = "I morti non hanno ancora imparato a parlare...";
                    } else {
                        // sto parlando con l'npc
                        if(p.getNpc().getConversation().isEmpty()){
                            text = p.getNpc().getName().toUpperCase() + ": " + p.getNpc().getTalk() + "\n";
                            text += p.getNpc().getName().toUpperCase() + " non ha nient'altro da dire...\n";
                        }
                        
                        else {
                            GameManager.setIsTalking(true);
                            p.getNpc().setIsTalking(true);
                            text = "----- Stai parlando con " + p.getNpc().getName().toUpperCase() + " -----\n";
                            text += "Per uscire dalla conversazione digita un altro comando\n";
                            text += "Cosa puoi chiedere:\n";

                            for(int i = 0; i < p.getNpc().getConversation().size(); i++) {
                                text += "- " + p.getNpc().getConversation().get(i).getQuestion() + "\n";
                            }
                            
                            text += p.getNpc().getName().toUpperCase() + ": " + p.getNpc().getTalk() + "\n";
                        }

                    }
                    break;
                    
                case THROW: // getta gli oggetti
                    if(p.getObject() == null) {
                        text = "Non puoi lasciare qualcosa che non c'è...";
                    } else if(!player1.getInventory().getList().contains(p.getObject())) {
                        text = "Non puoi lasciare qualcosa che non è presente nel tuo zaino..."; 
                    } else {
                        // rimuovi l'oggetto dallo zaino
                        player1.getInventory().getList().remove(p.getObject());
                    
                        // aggiungi l'oggetto rimosso alla stanza corrente
                        player1.getCurrentPlace().getItems().add(p.getObject());
                    
                        text = "Hai lasciato: " + p.getObject().getName();
                    }
                    break;
                    
                case USE: // per 'sbloccare' le stanze
                    if(p.getObject() == null) {
                        text = "Non puoi usare il nulla...";
                    } else if(p.getBlockedRoom() == null){
                        text = "E' inutile, puoi gia passare...";
                    } else if(!p.getObject().isUseable()) {
                        text = "Non puoi usare questo oggetto!";
                    } else if(!player1.getInventory().getList().contains(p.getObject())) {
                        text = "Non puoi usare qualcosa che non è presente nel tuo zaino...";
                    } else if(!p.getObject().equals(p.getBlockedRoom().getOpenWith())) {
                        text = "Il passaggio è ancora ostruito, sembra che non sia questo l'ggetto giusto per passare...";
                    } else {
                        if(player1.getCurrentPlace().getNord() != null && player1.getCurrentPlace().getNord().equals(p.getBlockedRoom()))
                            player1.getCurrentPlace().getNord().setBlocked(false);
                        else if(player1.getCurrentPlace().getSouth() != null && player1.getCurrentPlace().getSouth().equals(p.getBlockedRoom()))
                            player1.getCurrentPlace().getSouth().setBlocked(false);
                        else if(player1.getCurrentPlace().getEst() != null && player1.getCurrentPlace().getEst().equals(p.getBlockedRoom()))
                            player1.getCurrentPlace().getEst().setBlocked(false);
                        else if(player1.getCurrentPlace().getWest() != null && player1.getCurrentPlace().getWest().equals(p.getBlockedRoom()))
                            player1.getCurrentPlace().getWest().setBlocked(false);
                        
                        // una volta sbloccata la stanza l'oggetto non si puo piu usare
                        player1.getInventory().getList().get(player1.getInventory().getList().indexOf(p.getObject())).setUseable(false);
                        
                        text = "Sembra che adesso si possa proseguire!";
                    }
                    break;
                    
                case HELP:
                    text = "Comandi di gioco:\n";
                    text += "--> salva\t\t\t--> per salvare la partita\n";
                    text += "--> esci \t\t\t--> per uscire dalla partita e chiudere il gioco\n";
                    text += "--> pulisci\t\t\t--> per ripulire l'area di testo\n";
                    text += "--> nord \t\t\t--> per andare a nord della stanza\n";
                    text += "--> sud  \t\t\t--> per andare a sud della stanza\n";
                    text += "--> est  \t\t\t--> per andare a est della stanza\n";
                    text += "--> ovest\t\t\t--> per andare a ovest della stanza\n";
                    text += "--> zaino\t\t\t--> per vedere cosa hai nello zaino\n";
                    text += "--> apri (oggetto) (oggeto)\t\t--> per aprire le casse\n";
                    text += "--> raccogli (oggetto)\t\t--> per raccogliere un oggetto\n";
                    text += "--> parla (npc)\t\t\t--> per parlare con un npc\n";
                    text += "--> osserva\t\t\t--> per vedere cosa c'è nella stanza\n";
                    text += "--> mangia (o bevi)\t\t--> per utilizzare consumabili\n";
                    text += "--> equipaggia\t\t\t--> per equipaggiare armi o scudi\n";
                    text += "--> attacca (npc)\t\t--> per attaccare un nemico\n";
                    text += "--> butta (oggetto)\t\t--> per gettare via un oggetto presente nello zaino\n";
                    text += "--> usa (oggetto)\t\t--> per usare gli oggetti utili ad aprire una stanza\n";
                    break;
                    
                default:
                    text = "Non capisco quello che mi vuoi dire...";
                    break;
            }
            
        }

        
        return text;
    }
    
    public static boolean Final(Player player) {
        boolean flag = false;
        
        if(player.getCurrentPlace().getFinal()) {
            for(int i = 0; i < player.getCurrentPlace().getNpcs().size(); i++) {
                // se è un nemico e la salute è a zero
                if(player.getCurrentPlace().getNpcs().get(i).getIsEnemy() && player.getCurrentPlace().getNpcs().get(i).getHp() <= 0) {
                    flag = true;
                }
            }
        }
            
            
        return flag;
    }
    
    
}