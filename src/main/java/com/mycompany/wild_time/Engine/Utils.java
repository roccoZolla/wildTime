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
    
    
    
    /* public static Set<String> loadFileListInSet(File file) throws IOException {
        Set<String> set = new HashSet<>();
        BufferedReader reader = new BufferedReader(new FileReader(file));
        while (reader.ready()) {
            set.add(reader.readLine().trim().toLowerCase());
        }
        reader.close();
        return set;
    }

    public static List<String> parseString(String string, Set<String> stopwords) {
        List<String> tokens = new ArrayList<>();
        String[] split = string.toLowerCase().split("\\s+");
        for (String t : split) {
            if (!stopwords.contains(t)) {
                tokens.add(t);
            }
        }
        return tokens;
    } */
    
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
        if(p.getCommand() == null) {
            text = "Non capisco quello che mi vuoi dire";
        } else {
            if (p.getCommand().getType() == CommandType.NORD) {
                if (player1.getCurrentPlace().getNord() != null && !player1.getCurrentPlace().getNord().getBlocked()) {
                    player1.setCurrentPlace(player1.getCurrentPlace().getNord());
                    text = player1.getCurrentPlace().getDescription();
                } else {
                    text = "Non c'è niente da questa parte";
                } 
            } else if (p.getCommand().getType() == CommandType.SOUTH) {
                if (player1.getCurrentPlace().getSouth() != null && !player1.getCurrentPlace().getSouth().getBlocked()) {
                    player1.setCurrentPlace(player1.getCurrentPlace().getSouth());
                    text = player1.getCurrentPlace().getDescription();
                } else {
                    text = "Non c'è niente da questa parte";
                }
            } else if (p.getCommand().getType() == CommandType.EAST) {
                if (player1.getCurrentPlace().getEst() != null && !player1.getCurrentPlace().getEst().getBlocked()) {
                    player1.setCurrentPlace(player1.getCurrentPlace().getEst());
                    text = player1.getCurrentPlace().getDescription();
                } else {
                    text = "Non c'è niente da questa parte";
                }
            } else if (p.getCommand().getType() == CommandType.WEST) {
                if (player1.getCurrentPlace().getWest() != null && !player1.getCurrentPlace().getWest().getBlocked()) {
                    player1.setCurrentPlace(player1.getCurrentPlace().getWest());
                    text = player1.getCurrentPlace().getDescription();
                } else {
                    text = "Non c'è niente da questa parte";
                } 
            } else if (p.getCommand().getType() == CommandType.PICK_UP) {                  // pick up
                // Aggiungere controlli relativi agli oggetti
                // si puo raccogliere?
                
                
                // System.out.println(p.getObject().getName() + p.getObject().isTakeable());
                
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
                } else {
                    System.out.println("oggetto nel comando: " + p.getObject().getName());
                    for(int i = 0; i < player1.getCurrentPlace().getItems().size(); i++) {
                        if(p.getObject().equals(player1.getCurrentPlace().getItems().get(i))) {                           
                            System.out.println("oggetto for: " + player1.getCurrentPlace().getItems().get(i).getName());
                            player1.getInventory().getList().add(player1.getCurrentPlace().getItems().get(i));
                            text = "Hai raccolto " + player1.getCurrentPlace().getItems().get(i).getName();
                            // text += ". " + player1.getCurrentPlace().getItems().get(i).getDescription();
                            player1.getCurrentPlace().getItems().remove(i);                           
                        }
                    }
                } 
            } else if (p.getCommand().getType() == CommandType.LOOK_AT) {                  // guarda
                if(!player1.getCurrentPlace().getNpcs().isEmpty()){
                    System.out.println("Lista npc:" + player1.getCurrentPlace().getNpcs().get(0).getName());
                }
                
                // cosa c'è nella stanza?
                if (!player1.getCurrentPlace().getItems().isEmpty() || !player1.getCurrentPlace().getChest().getChest().isEmpty()) {
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
                        text += "\nOh, ma c'è qualcuno qui: ";
                    
                    for(int i = 0; i < player1.getCurrentPlace().getNpcs().size(); i++) {
                        if(player1.getCurrentPlace().getNpcs().get(i).getHp() <= 0) {
                            text += "+" + player1.getCurrentPlace().getNpcs().get(i).getName() + "+";
                        } else {
                            text += player1.getCurrentPlace().getNpcs().get(i).getName() + " ";
                        }
                    }
                }
            } else if(p.getCommand().getType() == CommandType.INVENTORY) {
                // cosa ho nell'inventario
                
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
            } else if(p.getCommand().getType() == CommandType.OPEN) {
                // apri le cose
                if(p.getObject() == null) {
                    text = "Non è l'oggetto giusto per aprire qualcosa...";                  
                } else if(p.getChestObject().getIsOpen()) {
                    text = "Hai gia aperto questa cassa!";
                } else {
                    if(p.getObject().isUseable() && p.getChestObject().getKey().equals(p.getObject())) {
                        text = "Hai aperto la cassa! \nLa cassa contiene: ";
                        
                        for(int i = 0; i < player1.getCurrentPlace().getChest().getChest().size(); i++)  {
                            // ottengo gli elementi presenti nella cassa e li inserisco
                            // nella lista degli oggetti presenti nella stanza
                            player1.getCurrentPlace().getItems().add(player1.getCurrentPlace().getChest().getChest().get(i));
                            
                            text += player1.getCurrentPlace().getChest().getChest().get(i).getName();
                        }    
                        
                        // la cassa risultera aperta
                        player1.getCurrentPlace().getChest().setIsOpen(true);
                        
                        // la chiave diventa inutilizzabile
                        int n = player1.getInventory().getList().indexOf(p.getObject());
                        player1.getInventory().getList().get(n).setUseable(false);
                            
                        // rimuovo tutti gli oggetti presenti nella cassa
                        player1.getCurrentPlace().getChest().getChest().removeAll(player1.getCurrentPlace().getChest().getChest());
   
                    } else {
                        text = "Non è possbile aprire questo oggetto";
                    }
                }        
            } else if(p.getCommand().getType() == CommandType.EAT) {
                // permette di utilizzare gli oggetti presenti nell'inventario
                // oggetti di tipo curativo
                
                if(p.getObject() == null) {
                    text = "Il nulla non è un qualcosa che si puo usare...";
                } else if(!player1.getInventory().getList().contains(p.getObject())) {
                    text = "Non puoi usare un oggetto che non è presente nel tuo zaino!";
                } else if(!p.getObject().isUseable() || !p.getObject().IsHeal()) {
                    text = "Non puoi usare questo oggetto!";
                } else if(player1.getHp() == player1.getMaxHP()){
                    text = "Stai bene, non serve";
                } else {
                    player1.setHp(player1.getHp() + p.getObject().getBonusHP());
                    
                    if(player1.getHp() > player1.getMaxHP())
                        player1.setHp(player1.getMaxHP());
                    
                    // rendi l'oggetto non piu utilizzabile
                    player1.getInventory().getList().get(player1.getInventory().getList().indexOf(p.getObject())).setUseable(false);
                    
                    text = "Hai recuperato " + p.getObject().getBonusHP() + " HP";
                }
            } else if (p.getCommand().getType() == CommandType.EQUIP) {
                // equipaggia le armi e gli scudi che trovi nel mondo di gioco
                
                System.out.println("Usesabilty: " + p.getObject().isUseable());
                System.out.println("Weaponability: " + p.getObject().IsWeapon());
                
                if(p.getObject() == null) {
                    text = "Il nulla non è un qualcosa che si puo usare...";
                } else if(!player1.getInventory().getList().contains(p.getObject())) {
                    text = "Non puoi usare un oggetto che non è presente nel tuo zaino!";
                } else if(!p.getObject().isUseable() || !p.getObject().IsWeapon()) {
                    text = "Non puoi usare questo oggetto!";
                } else {   
                    player1.getInventory().getList().remove(p.getObject());
                    
                    if(p.getObject().getAttackDamage() > 0) {
                        player1.getInventory().getList().add(player1.getArma());
                        player1.setArma(p.getObject());
                        
                        text = "Hai equipaggiato " + player1.getArma().getName();
                    } else if (p.getObject().getDefenseBonus() > 0) {
                        player1.getInventory().getList().add(player1.getScudo());
                        player1.setScudo(p.getObject());
                        
                        text = "Hai equipaggiato " + player1.getScudo().getName();
                    }
                }
                
            } else if(p.getCommand().getType() == CommandType.ATTACK) {     
                // attacca i nemici
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
                        text = p.getNpc().getName() + ": E' stato un piacere mercenario";
                    } else {
                        text = p.getNpc().getName() + " HP: " + p.getNpc().getHp() + "\n";
                        text += p.getNpc().getName() + ": Tocca ammazzarti!";
                        
                        attack = p.getNpc().getArma().getAttackDamage();
                        defense = player1.getScudo().getDefenseBonus();
                        
                        damage = (int) ((int) attack - (attack * (defense * reductionPercentage)));
                        
                        text += "\nDanno subito: " + damage;
                        
                        player1.setHp(player1.getHp() - damage);
                    }
                }
            } else if(p.getCommand().getType() == CommandType.TALK_TO) {  
                // DA SISTEMARE: implementare un sistema di dialogo
                // parla con gli npc
                if(p.getNpc() == null) {
                    text = "Non puoi parlare con qualcuno che non c'è...";
                } else if(!player1.getCurrentPlace().getNpcs().contains(p.getNpc())) {
                    text = "Non puoi parlare con qualcuno che non è qui...";
                } else if(p.getNpc().getHp() <= 0){
                    text = "I morti non hanno ancora imparato a parlare...";
                } else {
                    text = p.getNpc().getName() + ": " + p.getNpc().getTalk();
                }
                
            }
        }
        
        return text;
    }
    
    
}