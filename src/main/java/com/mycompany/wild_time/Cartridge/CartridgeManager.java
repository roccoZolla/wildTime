package com.mycompany.wild_time.Cartridge;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class CartridgeManager {
    private GameDescription gameDescription;
    private final String gamePath;

    public CartridgeManager() {
        this.gamePath = this.getClass().getResource("/mock/game.json").getPath();
        System.out.println(gamePath);
    }

    public void loadCartridge() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        // Legge il JSON e converte in GameDescription
        try {
            this.gameDescription = gson.fromJson(new FileReader(gamePath), GameDescription.class);
            System.out.println(gameDescription.toString());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public GameDescription getCartridge() {
        return this.gameDescription;
    }

}
