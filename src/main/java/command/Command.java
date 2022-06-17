package command;

import java.util.Objects;

public class Command {
    private final char unitCommand;

    public Command(char unitCommand) {
        this.unitCommand = unitCommand;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Command)) return false;
        Command command = (Command) o;
        return unitCommand == command.unitCommand;
    }

    @Override
    public int hashCode() {
        return Objects.hash(unitCommand);
    }

    @Override
    public String toString() {
        return "Command{" +
                "unitCommand=" + unitCommand +
                '}';
    }

    public char getUnitCommand() {
        return unitCommand;
    }
}
