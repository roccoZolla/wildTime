package com.mycompany.wild_time.Game.Parser;

import com.mycompany.wild_time.Game.Command.Command;
import com.mycompany.wild_time.Game.Command.CommandType;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class Parser {
    private final List<String> STOP_WORDS = Arrays.asList("il", "lo", "la", "gli", "le", "i", "l'", "un", "una", "uno",
            "di", "a", "da", "in", "con", "su", "per", "tra", "dal", "del");

    public Parser() {
    }

    private CommandType findCommandType(String token, List<Command> commands) {
        return commands
                .stream()
                .filter(c -> c.getAlias().contains(token))
                .map(Command::getType)
                .findFirst()
                .orElse(null);
    }

    public ParsedCommand parse(String input, List<Command> commands) {
        List<String> tokens = Arrays.stream(input.toLowerCase().split("\\s+"))
                .collect(Collectors.toList());

        tokens = tokens.stream()
                .filter(t -> !STOP_WORDS.contains(t))
                .toList();

        String rawInput = input;

        CommandType commandType = null;
        String target = null;
        String secondary = null;

        for (String t : tokens)
        {

            if (commandType == null)
            {
                commandType = findCommandType(t, commands);

                if (commandType != null) {
                    continue;
                }
            }

            if(target == null)
            {
                target = t;
                continue;
            }

            if(secondary == null) {
                secondary = t;
            }

        }


        return new ParsedCommand(commandType, target, secondary, rawInput);
    }
}
