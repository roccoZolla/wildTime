/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.wild_time.Parser;

import com.mycompany.wild_time.Engine.GameDescription;
import com.mycompany.wild_time.Type.Chest;
import com.mycompany.wild_time.Type.Command;
import com.mycompany.wild_time.Type.Item;
import com.mycompany.wild_time.Type.Npc;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

/**
 *
 * @author rocco
 */
public class Parser {
    //private final Set<String> stopwords;
    
    public Parser() {}

    /*public Parser(Set<String> stopwords) {
        this.stopwords = stopwords;
    } */
    
    interface Function<T, R> {
        R apply(T t);
    }
    
    private List<String> findKeyWords(String command) {
        // Lista delle keyword
        List<String> keyWords = new ArrayList<>();
        
        // dividi la stringa in tante parole quanti sono gli spazi 
        String[] words = command.split("\\s+"); // -> REGEX 
        
        // lista di parole da non includere nel comando finale
        List<String> uselessWord = Arrays.asList("il", "lo", "la", "gli", "le", "i", "l'", "un", "una", "uno",
                "di", "a", "da", "in", "con", "su", "per", "tra");
        
        // controllo
        // Filtra le parole non desiderate
        for (String word : words) {
            // Rimuovi spazi bianchi iniziali e finali e converti in minuscolo
            String cleanedWord = word.trim().toLowerCase();

            // Aggiungi la parola alla lista delle parole chiave solo se non è una stopword
            if (!uselessWord.contains(cleanedWord)) {
                keyWords.add(cleanedWord);
            }
        }

        return keyWords;
    }
    
    // funzione generica che prende in input un token, una lista di oggetti e una funzione tramite cui recuperare il nome
    private <T> int checkForObject(String token, List<T> items, Function<T, String> getNameFunction, Function<T, Set<String>> getAliasesFunction) {
        for (int i = 0; i < items.size(); i++) {
            String name = getNameFunction.apply(items.get(i));
            
            if (name.equals(token)) {
                return i;
            } else {
                if(getAliasesFunction != null) {
                    if(getAliasesFunction.apply(items.get(i)).contains(token))
                        return i;
                }
            }

        }
        return -1;
    }
    
    // improved parser 2.0
    // formato comando supportato: AZIONE articolo OGGETTO articolo OGGETTO
    public ParserOutput parse(String command, GameDescription game) {
        ParserOutput p = new ParserOutput();
        Item item = new Item();
        String text = command;
        List<String> keyWords = new ArrayList<>();
        keyWords = findKeyWords(command);
        
        int n = 0; 
        
        p.setCommand(null);
        p.setInvObject(null);
        p.setObject(null);
        p.setConversation(null);

        for(int i = 0; i < keyWords.size(); i++) {
            if(!keyWords.get(i).isEmpty()) { // controlla prima se è un oggetto
                n = checkForObject(keyWords.get(i), game.getCommands(), Command::getName, Command::getAlias);
               
                if(n != -1) {
                    p.setCommand(game.getCommands().get(n));
                    System.out.println("Comando trovato: " + p.getCommand().getName());
                } else {            // se non è un commando verifica che sia un oggetto
                    n = checkForObject(keyWords.get(i), game.getItems(), Item::getName, null);

                    if(n == -1) {   // se non è un oggetto controllo se è un Npc
                        n = checkForObject(keyWords.get(i), game.getNpcs(), Npc::getName, null);
                    
                        if(n != -1) {
                            p.setNpc(game.getNpcs().get(n));
                            System.out.println("Npc trovato: " + p.getNpc().getName());
                        }

                    } else {
                        item = game.getItems().get(n);
                    
                        if(item instanceof Chest) { // se è un oggetto verifico che sia una chest
                            p.setInvObject((Chest) item);
                        } else {
                            p.setObject(game.getItems().get(n));
                        }
                    }
                }
            }
        }
        
        /*
            Possibile problema: se avvio un'altra conversazione senza aver terminato quella corrente 
            casino bordello anche se nel momento in cui viene rilevato un comando tutte le conversazioni
            avviate vengono settate su false DA VERIFICARE
        */
        
        // controlla conversazione
        if(p.getCommand() == null) { // se il testo inserito non contiene comandi
            // il commando è nullo
            System.out.println("Il comando è nullo");
            for(int i = 0; i < game.getPlayer().getCurrentPlace().getNpcs().size(); i++) {
                if(game.getPlayer().getCurrentPlace().getNpcs().get(i).getIsTalking()) {
                    if(text.equals(game.getPlayer().getCurrentPlace().getNpcs().get(i).getConversation().getQuestion())) {
                        p.setConversation(game.getPlayer().getCurrentPlace().getNpcs().get(i).getConversation());
                    }
                    
                    p.setNpc(game.getPlayer().getCurrentPlace().getNpcs().get(i));
                }
            }
        } else { // se il comando contiene un comando interrompi conversazione
            for(int i = 0; i < game.getPlayer().getCurrentPlace().getNpcs().size(); i++) {
                game.getPlayer().getCurrentPlace().getNpcs().get(i).setIsTalking(false);
            }
        }

        
        if(p.getConversation() != null) {
            System.out.println(p.getConversation().getQuestion());
            System.out.println(p.getConversation().getAnswer());
        }


        
        return p;
    }
}
