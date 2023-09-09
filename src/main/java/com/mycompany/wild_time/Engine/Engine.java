/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.wild_time.Engine;

import com.mycompany.wild_time.Game.WildTime;

/**
 *
 * @author rocco
 */
public class Engine {
    private final GameManager gameManager;
    private GameDescription game;
    
    public Engine(GameDescription game) {
        this.game = game;
        gameManager = new GameManager(game);
    }
    
    public void excute() {
        // try catch
        //init meglio qui che nel costruttore
        //Se fallisce nel costruttore che fai esegui lo stesso il gioco?
        try {
            this.game.init();
            gameManager.Start();
        } catch (Exception ex) {
            System.err.println(ex);
        } 
    }
        
    public static void main(String[] args) {
        Engine engine = new Engine(new WildTime());
        
        engine.excute();
    }
}
