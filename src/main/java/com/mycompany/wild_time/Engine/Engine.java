/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.wild_time.Engine;

import Game.WildTime;

/**
 *
 * @author rocco
 */
public class Engine {
    private final GameManager gameManager;
    private GameDescription game;
    
    public Engine(GameDescription game) {
        this.game = game;
        
        try {
            this.game.init();
        } catch (Exception ex) {
            System.err.println(ex);
        }   
        
        gameManager = new GameManager(game);
    }
    
    public void excute() {
        gameManager.Start();
    }
        
    public static void main(String[] args) {
        Engine engine = new Engine(new WildTime());
        
        engine.excute();
    }
}
