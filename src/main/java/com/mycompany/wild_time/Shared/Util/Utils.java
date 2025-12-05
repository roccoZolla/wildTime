///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package com.mycompany.wild_time.Utils;
//
//import com.mycompany.wild_time.Game.Game;
//import com.mycompany.wild_time.Game.Parser.ParserOutput;
//import com.mycompany.wild_time.Game.Command.CommandType;
//import com.mycompany.wild_time.Shared.Type.Direction;
//import com.mycompany.wild_time.Shared.Type.Player;
//import com.mycompany.wild_time.Shared.Type.Room;
//
//import java.io.*;
//import java.nio.file.Files;
//import java.nio.file.Paths;
//import java.util.Collections;
//import java.util.List;
//
///**
// *
// * @author rocco
// */
//
//// @todo: classe per leggere le traduzioni, di utilita
//public class Utils {
//    public static String LoadGame(File saveFile) {
//        String text = "Gioco caricato con successo!\n";
//
//        try (ObjectInputStream inputStream = new ObjectInputStream(Files.newInputStream(saveFile.toPath()))) {
//            Game game = (Game) inputStream.readObject();
////            GameManager.getInstance().setGame(game);
//        } catch (IOException | ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//
//        return text;
//    }
//
//    public static String Save(Game game) {
//        String text = "Gioco Salvato con successo!\n";
//
//        String userDir = System.getProperty("user.dir");
//        String outputFile = userDir + File.separator + "save.dat";
//
//        try (ObjectOutputStream outputStream = new ObjectOutputStream(Files.newOutputStream(Paths.get(outputFile)))) {
//            outputStream.writeObject(game);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        return text;
//    }
//
//    //  @todo: ho il readCommand nel gameManager che usa alcuni comandi la maggior parti vengono letti qua
//    public static String NextMove(ParserOutput p, Player player1, Room currentPlace) {
//        String text = "";
//        CommandType type = p.getCommand().getType();
//
//        if (p.getCommand() == null) {
//            text = "Non capisco quello che mi vuoi dire...";
//        } else {
//            switch (type) {
//                case NORD:
//                    text = move(currentPlace, Direction.NORD);
//                    break;
//
//                case SOUTH:
//                    text = move(currentPlace, Direction.SOUTH);
//                    break;
//
//                case EAST:
//                    text = move(currentPlace, Direction.EAST);
//                    break;
//
//                case WEST:
//                    text = move(currentPlace, Direction.WEST);
//                    break;
//
//                case PICK_UP:   // raccogli gli oggetti
//                    if (p.getObject() == null) {
//                        if (p.getChestObject() != null) {
//                            text = "Come fai a mettere una cassa in quello zainetto minuscolo?";
//                        } else {
//                            text = "Non c'è nessuno oggetto che si chiami cosi";
//                        }
//                    } else if (currentPlace.getItems().isEmpty()) {
//                        text = "Non c'è niente da raccogliere in questa stanza!";
//                    } else if (!p.getObject().isTakeable()) {
//                        text = "Per qualche strana ragione non puoi raccogliere questo oggetto";
//                    } else if (player1.getInventory().contains(p.getObject())) {
//                        text = "Hai gia raccolto questo oggetto!";
//                    } else {
//                        for (int i = 0; i < currentPlace.getItems().size(); i++) {
//                            if (p.getObject().equals(currentPlace.getItems().get(i))) {
//                                player1.getInventory().add(currentPlace.getItems().get(i));
//                                text = "Hai raccolto: " + currentPlace.getItems().get(i).getName();
//                                text += ". " + currentPlace.getItems().get(i).getDescription();
//                                currentPlace.getItems().remove(i);
//                            }
//                        }
//                    }
//                    break;
//
////               @todo: chest va negli item
//                case LOOK_AT:
//                    if (!currentPlace.getItems().isEmpty() || !currentPlace.getChest().getList().isEmpty()) {
//                        text = "Nella stanza sono presenti: ";
//                        for (int i = 0; i < currentPlace.getItems().size(); i++) {
//                            text += currentPlace.getItems().get(i).getName() + " ";
//                        }
//
//                        text += currentPlace.getChest().getName();
//                    } else {
//                        text = "Non c'è niente di particolare in questa stanza";
//                    }
//
//                    if (currentPlace.getNpcList().isEmpty()) {
//                        // guarda se sono presenti npcs
//                        text += "\nOh, ma c'è qualcuno qui:\n";
//
//                        for (int i = 0; i < currentPlace.getNpcList().size(); i++) {
//                            if (currentPlace.getNpcList().get(i).getHp() <= 0) {
//                                text += "+" + currentPlace.getNpcList().get(i).getName() + "+";
//                            } else {
//                                text += currentPlace.getNpcList().get(i).getName() +
//                                        ". " +
//                                        currentPlace.getNpcList().get(i).getDescription() +
//                                        "\n";
//                            }
//                        }
//                    }
//                    break;
//
//                case INVENTORY:     // mostra lo zaino
//                    if (!player1.getInventory().isEmpty()) {
//                        text = "Nello zaino hai: ";
//
//                        for (int i = 0; i < player1.getInventory().size(); i++) {
//                            if (!player1.getInventory().get(i).isUseable()) {
//                                text += "-" + player1.getInventory().get(i).getName() + "-" + " ";
//                            } else {
//                                text += player1.getInventory().get(i).getName() + " ";
//                            }
//                        }
//                    } else {
//                        text = "Non hai niente nello zaino!";
//                    }
//                    break;
//
//                case OPEN:      // apri le casse con l'oggetto adatto
//                    if (p.getObject() == null) {
//                        text = "Non è l'oggetto giusto per aprire qualcosa...";
//                    } else if (p.getChestObject().getIsOpen()) {
//                        text = "Hai gia aperto questa cassa!";
//                    } else {
//                        if (p.getObject().isUseable() && p.getChestObject().getKey().equals(p.getObject())) {
//                            text = "Hai aperto la cassa! \nLa cassa contiene: ";
//
//                            for (int i = 0; i < currentPlace.getChest().getList().size(); i++) {
//                                // ottengo gli elementi presenti nella cassa e li inserisco
//                                // nella lista degli oggetti presenti nella stanza
//                                currentPlace.getItems().add(currentPlace.getChest().getList().get(i));
//
//                                text += currentPlace.getChest().getList().get(i).getName() + " ";
//                            }
//
//                            // la cassa risultera aperta
//                            currentPlace.getChest().setIsOpen(true);
//
//                            // la chiave diventa inutilizzabile
//                            int n = player1.getInventory().indexOf(p.getObject());
//                            player1.getInventory().get(n).setUseable(false);
//
//                            // rimuovo tutti gli oggetti presenti nella cassa
//                            currentPlace.getChest().getList().removeAll(currentPlace.getChest().getList());
//                        } else {
//                            text = "Non è possbile aprire questo oggetto";
//                        }
//                    }
//                    break;
//
//                case EAT:   // mangia o bevi, dicreati
//                    if (p.getObject() == null) {
//                        text = "Il nulla non è un qualcosa che si puo usare...";
//                    } else if (!player1.getInventory().contains(p.getObject())) {
//                        text = "Non puoi mangiare o bere un oggetto che non è presente nel tuo zaino!";
//                    } else if (!p.getObject().isUseable()) {
//                        text = "Non puoi mangiare o bere questo oggetto!";
//                    } else {
//                        if (p.getObject().IsHeal()) {        // curativo
//                            if (player1.getHp() == player1.getMaxHP()) {
//                                text = "Stai bene, non serve";
//                            } else {
//                                player1.setHp(player1.getHp() + p.getObject().getBonus());
//
//                                if (player1.getHp() > player1.getMaxHP()) player1.setHp(player1.getMaxHP());
//
//                                // rendi l'oggetto non piu utilizzabile
//                                player1.getInventory().get(player1.getInventory().indexOf(p.getObject())).setUseable(false);
//
//                                text = "Hai recuperato " + p.getObject().getBonus() + " HP";
//                            }
//
//                        } else if (p.getObject().IsPowerUp()) { // potenziamento
//                            if (p.getObject().IsWeapon()) {       // arma
//                                if (p.getObject().getAttackDamage() != 0) {      // potenzia attacco
//                                    player1.getArma().setAttackDamage(player1.getArma().getAttackDamage() + p.getObject().getAttackDamage());
//                                    text = "Attacco dell'arma aumentato di: " + p.getObject().getAttackDamage() + "\n";
//                                } else if (p.getObject().getDefenseBonus() != 0) {  // potenzia difesa
//                                    player1.getScudo().setDefenseBonus(player1.getScudo().getDefenseBonus() + p.getObject().getDefenseBonus());
//                                    text = "Difesa dello scudo aumentato di: " + p.getObject().getDefenseBonus() + "\n";
//                                }
//
//                                player1.getInventory().get(player1.getInventory().indexOf(p.getObject())).setUseable(false);
//                            } else {                  // potenziamento vita
//                                player1.setMaxHP(player1.getMaxHP() + p.getObject().getBonus());
//                                player1.setHp(player1.getHp() + p.getObject().getBonus());
//
//                                text = "Salute aumentata di: " + p.getObject().getBonus() + " HP\n";
//                            }
//                        }
//
//                    }
//                    break;
//
//                case EQUIP:     // equipaggia le armi
//                    if (p.getObject() == null) {
//                        text = "Il nulla non è un qualcosa che si puo usare...";
//                    } else if (!player1.getInventory().contains(p.getObject())) {
//                        text = "Non puoi equipaggiare un oggetto che non è presente nel tuo zaino!";
//                    } else if (!p.getObject().isUseable() || !p.getObject().IsWeapon() || p.getObject().IsPowerUp()) {
//                        text = "Non puoi equipaggiare questo oggetto!";
//                    } else {
//                        player1.getInventory().remove(p.getObject());
//
//                        if (p.getObject().getAttackDamage() > 0) {
//                            player1.getInventory().add(player1.getArma());
//                            player1.setArma(p.getObject());
//
//                            text = "Hai equipaggiato: " + player1.getArma().getName();
//                        } else if (p.getObject().getDefenseBonus() > 0) {
//                            player1.getInventory().add(player1.getScudo());
//                            player1.setScudo(p.getObject());
//
//                            text = "Hai equipaggiato: " + player1.getScudo().getName();
//                        }
//                    }
//                    break;
//
//                case ATTACK:    // attacca
//                    double reductionPercentage = 0.03;
//
//                    if (p.getNpc() == null) {
//                        text = "Non puoi attaccare qualcosa che non c'è";
//                    } else if (!currentPlace.getNpcList().contains(p.getNpc())) {
//                        text = "Vuoi attaccare qualcuno che non è qui...";
//                    } else if (!p.getNpc().getIsEnemy()) {
//                        text = "Perche attaccare qualcuno che non è neanche un nemico?";
//                    } else if (p.getNpc().getHp() <= 0) {
//                        text = "Non puoi attaccare qualcuno che è gia morto!";
//                    } else {
//                        int attack = player1.getArma().getAttackDamage();
//                        int defense = p.getNpc().getScudo().getDefenseBonus();
//
//                        int damage = (int) (attack - (attack * (defense * reductionPercentage)));
//
//                        p.getNpc().setHp(p.getNpc().getHp() - damage);
//
//                        if (p.getNpc().getHp() <= 0) {
//                            text = p.getNpc().getName().toUpperCase() + ": E' stato un piacere mercenario\n";
//                            if (p.getNpc().getReward() != null) {
//                                text += p.getNpc().getName().toUpperCase() + " ha lasciato cadere: " + p.getNpc().getReward().getName();
//                                currentPlace.getItems().add(p.getNpc().getReward());
//                            }
//                        } else {
//                            text = p.getNpc().getName().toUpperCase() + " HP: " + p.getNpc().getHp() + "\n";
//                            text += p.getNpc().getName().toUpperCase() + ": Tocca ammazzarti!";
//
//                            attack = p.getNpc().getArma().getAttackDamage();
//                            defense = player1.getScudo().getDefenseBonus();
//
//                            damage = (int) (attack - (attack * (defense * reductionPercentage)));
//
//                            text += "\nDanno subito: " + damage;
//
//                            player1.setHp(player1.getHp() - damage);
//                        }
//                    }
//                    break;
//
//                case TALK_TO: // parla con gli npc
//                    if (p.getNpc() == null) {
//                        text = "Non puoi parlare con qualcuno che non c'è...";
//                    } else if (!currentPlace.getNpcList().contains(p.getNpc())) {
//                        text = "Non puoi parlare con qualcuno che non è qui...";
//                    } else if (p.getNpc().getHp() <= 0) {
//                        text = "I morti non hanno ancora imparato a parlare...";
//                    } else {
//                        // sto parlando con l'npc
//                        if (p.getNpc().getConversation().isEmpty()) {
//                            text = p.getNpc().getName().toUpperCase() + ": " + p.getNpc().getTalk() + "\n";
//                            text += p.getNpc().getName().toUpperCase() + " non ha nient'altro da dire...\n";
//                        } else {
////                            GameManager.getInstance().setIsTalking(true);
//                            p.getNpc().setIsTalking(true);
//                            text = "----- Stai parlando con " + p.getNpc().getName().toUpperCase() + " -----\n";
//                            text += "Per uscire dalla conversazione digita un altro comando\n";
//                            text += "Cosa puoi chiedere:\n";
//
//                            for (int i = 0; i < p.getNpc().getConversation().size(); i++) {
//                                text += "- " + p.getNpc().getConversation().get(i).getQuestion() + "\n";
//                            }
//
//                            text += p.getNpc().getName().toUpperCase() + ": " + p.getNpc().getTalk() + "\n";
//                        }
//
//                    }
//                    break;
//
//                case THROW: // getta gli oggetti
//                    if (p.getObject() == null) {
//                        text = "Non puoi lasciare qualcosa che non c'è...";
//                    } else if (!player1.getInventory().contains(p.getObject())) {
//                        text = "Non puoi lasciare qualcosa che non è presente nel tuo zaino...";
//                    } else {
//                        // rimuovi l'oggetto dallo zaino
//                        player1.getInventory().remove(p.getObject());
//
//                        // aggiungi l'oggetto rimosso alla stanza corrente
//                        currentPlace.getItems().add(p.getObject());
//
//                        text = "Hai lasciato: " + p.getObject().getName();
//                    }
//                    break;
//
//                case USE: // per 'sbloccare' le stanze
//                    if (p.getObject() == null) {
//                        text = "Non puoi usare il nulla...";
//                    } else if (p.getBlockedRoom() == null) {
//                        text = "E' inutile, puoi gia passare...";
//                    } else if (!p.getObject().isUseable()) {
//                        text = "Non puoi usare questo oggetto!";
//                    } else if (!player1.getInventory().contains(p.getObject())) {
//                        text = "Non puoi usare qualcosa che non è presente nel tuo zaino...";
//                    } else if (!p.getObject().equals(p.getBlockedRoom().getOpenWith())) {
//                        text = "Il passaggio è ancora ostruito, sembra che non sia questo l'ggetto giusto per passare...";
//                    } else {
//                        if (currentPlace.getNord() != null && currentPlace.getNord().equals(p.getBlockedRoom()))
//                            currentPlace.getNord().setBlocked(false);
//                        else if (currentPlace.getSouth() != null && currentPlace.getSouth().equals(p.getBlockedRoom()))
//                            currentPlace.getSouth().setBlocked(false);
//                        else if (currentPlace.getEst() != null && currentPlace.getEst().equals(p.getBlockedRoom()))
//                            currentPlace.getEst().setBlocked(false);
//                        else if (currentPlace.getWest() != null && currentPlace.getWest().equals(p.getBlockedRoom()))
//                            currentPlace.getWest().setBlocked(false);
//
//                        // una volta sbloccata la stanza l'oggetto non si puo piu usare
//                        player1.getInventory().get(player1.getInventory().indexOf(p.getObject())).setUseable(false);
//
//                        text = "Sembra che adesso si possa proseguire!";
//                    }
//                    break;
//
//                case HELP:
//                    text = "Comandi di gioco:\n";
//                    text += "--> salva\t\t\t--> per salvare la partita\n";
//                    text += "--> esci \t\t\t--> per uscire dalla partita e chiudere il gioco\n";
//                    text += "--> pulisci\t\t\t--> per ripulire l'area di testo\n";
//                    text += "--> nord \t\t\t--> per andare a nord della stanza\n";
//                    text += "--> sud  \t\t\t--> per andare a sud della stanza\n";
//                    text += "--> est  \t\t\t--> per andare a est della stanza\n";
//                    text += "--> ovest\t\t\t--> per andare a ovest della stanza\n";
//                    text += "--> zaino\t\t\t--> per vedere cosa hai nello zaino\n";
//                    text += "--> apri (oggetto) (oggeto)\t\t--> per aprire le casse\n";
//                    text += "--> raccogli (oggetto)\t\t--> per raccogliere un oggetto\n";
//                    text += "--> parla (npc)\t\t\t--> per parlare con un npc\n";
//                    text += "--> osserva\t\t\t--> per vedere cosa c'è nella stanza\n";
//                    text += "--> mangia (o bevi)\t\t--> per utilizzare consumabili\n";
//                    text += "--> equipaggia\t\t\t--> per equipaggiare armi o scudi\n";
//                    text += "--> attacca (npc)\t\t--> per attaccare un nemico\n";
//                    text += "--> butta (oggetto)\t\t--> per gettare via un oggetto presente nello zaino\n";
//                    text += "--> usa (oggetto)\t\t--> per usare gli oggetti utili ad aprire una stanza\n";
//                    break;
//
//                default:
//                    text = Translator.t("errors.unrecognized");
//                    break;
//            }
//
//        }
//
//        return text;
//    }
//
//    private static String move(Room currentPlace, Direction dir) {
//        Room next = null;
//
//        switch (dir) {
//            case NORD:
//                next = currentPlace.getNord();
//                break;
//
//            case SOUTH:
//                next = currentPlace.getSouth();
//                break;
//
//            case EAST:
//                next = currentPlace.getEst();
//                break;
//
//            case WEST:
//                next = currentPlace.getWest();
//                break;
//        }
//
//        if (next == null)
//            return Translator.t("movement.no_path");
//
//        if (next.getBlocked())
//            return Translator.t("movement.blocked");
//
//        // Esegui spostamento
//        // @Todo la stanza corrente verrò gestita dal game manager
////        currentPlace = next;
//
//        if (!next.getExplored()) next.setExplored(true);
//
//        return next.getDescription();
//    }
//
//    @SafeVarargs
//    public static <T> void addObjects(List<T> target, T... items) {
//        Collections.addAll(target, items);
//    }
//}