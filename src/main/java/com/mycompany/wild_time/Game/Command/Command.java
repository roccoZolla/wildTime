package com.mycompany.wild_time.Game.Command;

import java.util.List;
import java.util.Set;

public class Command {
    private String name;
    private CommandType type;
    private Set<String> alias;
    private List<String> parameters;

    public Command() {
    }

    public Set<String> getAlias() {
        return alias;
    }

    public CommandType getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Command{" +
                "name='" + name + '\'' +
                ", aliases=" + alias +
                ", type=" + type +
                ", parameters=" + parameters +
                '}';
    }
}
