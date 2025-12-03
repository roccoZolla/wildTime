package com.mycompany.wild_time.Type;

import java.util.Arrays;
import java.util.List;

public enum Direction {
    NORTH(Arrays.asList("n", "north", "nord")),
    SOUTH(Arrays.asList("s", "south", "sud")),
    EAST(Arrays.asList("e", "east", "est")),
    WEST(Arrays.asList("w", "west", "ovest"));

    private final List<String> aliases;

    Direction(List<String> aliases) {
        this.aliases = aliases;
    }

    public static Direction fromToken(String token) {
        if(token == null) return null;

        token = token.toLowerCase();
        for (Direction d : values()) {
            if (d.aliases.contains(token)) return d;
        }
        return null;
    }

    @Override
    public String toString() {
        return name().toLowerCase();
    }
}
