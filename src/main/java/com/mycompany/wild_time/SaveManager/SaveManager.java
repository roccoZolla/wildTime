package com.mycompany.wild_time.SaveManager;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mycompany.wild_time.Game.GameState;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SaveManager {

    private static final String DIR_PATH = "output";
    private static final String SAVE_PATH = "output/save.json";

    public static boolean save(GameState gameState) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(gameState);

        Path dirPath = Paths.get(DIR_PATH);
        Path filePath = Paths.get(SAVE_PATH);

        try {
            Files.createDirectories(dirPath);

            try (FileWriter writer = new FileWriter(filePath.toFile())) {
                writer.write(json);
            }

            System.out.println("--- Salvataggio completato con successo ---");
            return true;

        } catch (IOException e) {
            System.err.println("--- ERRORE NEL SALVATAGGIO ---");
            e.printStackTrace();
            return false;
        }
    }


    public static GameState loadSave() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Path filePath = Paths.get(SAVE_PATH);

        try {
            String json = Files.readString(filePath);
            return gson.fromJson(json, GameState.class);
        } catch (IOException e) {
            System.err.println("--- ERRORE NEL CARICAMENTO ---");
            e.printStackTrace();
            return null;
        }
    }

    public static boolean saveExists() {
        return Files.exists(Paths.get(SAVE_PATH));
    }

    public static boolean deleteSave() {
        return new File(SAVE_PATH).delete();
    }
}
