package command;

import direction.Direction;
import lawn.Lawn;
import mower.Mower;
import mower.PositionMower;

import java.util.Objects;

public class Command {
    private char unitCommand;

    public Command(char unitCommand) {
        this.unitCommand = unitCommand;
    }

    public Command() {
    }




    public Direction turnRight(Direction direction) {
        return direction.getiDirection().turnRight();
    }

    public Direction turnLeft(Direction direction) {
        return direction.getiDirection().turnLeft();
    }

    public char getUnitCommand() {
        return unitCommand;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
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
}
