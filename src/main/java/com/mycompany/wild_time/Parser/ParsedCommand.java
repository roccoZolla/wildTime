package com.mycompany.wild_time.Parser;

import com.mycompany.wild_time.Command.CommandType;

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
