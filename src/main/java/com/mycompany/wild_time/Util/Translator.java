package com.mycompany.wild_time.Util;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.InputStream;
import java.util.Collections;
import java.util.Map;

public class Translator {

    private static Map<String, String> translations = Collections.emptyMap();
    private static final ObjectMapper mapper = new ObjectMapper();
    private static String currentLang = "it";  // lingua di default

    /**
     * Inizializza caricando il file JSON della lingua
     */
    public static void init(String lang) {
        currentLang = lang;

        try {
            String path = "/assets/translations/" + lang + ".json";
            InputStream in = Translator.class.getResourceAsStream(path);

            if (in == null) {
                System.err.println("File di traduzione non trovato: " + path);
                translations = Collections.emptyMap();
                return;
            }

            translations = mapper.readValue(in, Map.class);

        } catch (Exception e) {
            e.printStackTrace();
            translations = Collections.emptyMap();
        }
    }

    /**
     * Restituisce la traduzione associata alla chiave.
     * Se manca, ritorna la chiave stessa (fallback).
     */
    public static String t(String key) {
        return translations.getOrDefault(key, "[" + key + "]");
    }

    /**
     * Restituisce la lingua attuale
     */
    public static String getCurrentLang() {
        return currentLang;
    }
}
