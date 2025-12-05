package com.mycompany.wild_time.Game.Parser;

import com.mycompany.wild_time.Game.Command.CommandType;

public record ParsedCommand(CommandType type,
                            String target,
                            String secondary,
                            String rawInput) {

    @Override
    public String toString() {
        return "ParserOutput{" +
                "type=" + type +
                ", target=" + target +
                ", secondary=" + secondary +
                ", rawInput='" + rawInput + '\'' +
                '}';
    }
}
