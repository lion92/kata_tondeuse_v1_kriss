package mower;

import command.Command;
import direction.Direction;
import lawn.Lawn;
import parserCommand.ParserCommand;

import java.util.List;
import java.util.Objects;

public class Mower {
    private Direction direction;
    private PositionMower positionMower;
    private final Lawn lawn;
    private List<Command> listCommand;


    public Mower(int x, int y, Direction direction, Lawn lawn, List<Command> listCommand) {
        this.lawn = lawn;
        this.listCommand = listCommand;
        this.positionMower = new PositionMower(x, y, lawn);
        this.direction = direction;
    }

    public Mower(int x, int y, Direction direction, Lawn lawn) {
        this.lawn = lawn;
        this.positionMower = new PositionMower(x, y, lawn);
        this.direction = direction;
    }


    public Mower executeCommand(List<Command> commands) {

        Mower mower;
        for (Command actualCommand : commands) {
            mower = moveMower(actualCommand);
            this.positionMower = mower.positionMower;
            this.direction = mower.direction;
        }
        return this;
    }

    public Mower moveForward(Command command) {

            return direction.move(direction, positionMower, lawn);
            
    }

    private Mower moveMower(Command actualCommand) {

        Direction actualDirection = rotate(actualCommand, direction);
        if (actualCommand.getUnitCommand() == ('A')) {
        this.positionMower = moveForward(actualCommand).positionMower;
        }
        this.direction = actualDirection;

        return this;
    }


    public Direction rotate
            (Command command, Direction direction) {
        Direction actualDirection = direction;
        if (command.equals(new Command('L'))) {
            actualDirection = turnLeft(direction);
        }
        if (command.equals(new Command('R'))) {
            actualDirection = turnRight(direction);
        }
        return actualDirection;
    }

    public Direction turnRight(Direction direction) {
        return direction.getiDirection().turnRight();
    }

    public Direction turnLeft(Direction direction) {
        return direction.getiDirection().turnLeft();
    }

    public List<Command> getListCommand() {
        return listCommand;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mower mower = (Mower) o;
        return direction == mower.direction && Objects.equals(positionMower, mower.positionMower) && Objects.equals(lawn, mower.lawn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(direction, positionMower, lawn);
    }

    @Override
    public String toString() {
        return "Mower{" +
                "direction=" + direction +
                ", positionMower=" + positionMower +
                ", lawn=" + lawn +
                '}';
    }
}
