package com.mycompany.wild_time.Shared.Type;

public class CommandResult {
    private final String message;
    private final boolean exit;

    public CommandResult(String message, boolean exit) {
        this.message = message;
        this.exit = exit;
    }

    public String getMessage() {
        return message;
    }

    public boolean shouldExitEngine() {
        return exit;
    }
}
