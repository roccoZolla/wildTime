package com.mycompany.wild_time.Util;

import java.util.Map;

public class Messages {
    private static final Map<MessageKey, String> it = Map.of(
            MessageKey.UNKNOWN_COMMAND, "Non ho capito cosa intendi.",
            MessageKey.CANT_GO_THERE, "Non puoi andare verso %s.",
            MessageKey.ITEM_NOT_FOUND, "Non vedo %s qui.",
            MessageKey.WHERE_AM_I, "Ti trovi in %s",
            MessageKey.SUCCESS_SAVE, "Salvataggio avvenuto con successo!",
            MessageKey.ERROR_SAVE, "Errore durante il salvataggio",
            MessageKey.EXITING_GAME, "Tornando al schermata principale..."
    );

    public static String get(MessageKey key, Object... args) {
        return String.format(it.get(key), args);
    }
}
