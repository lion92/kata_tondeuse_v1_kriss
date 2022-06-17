package mower;

import command.Command;
import direction.Direction;
import lawn.Lawn;
import parserCommand.ParserCommand;

import java.util.Objects;

public class Mower {
    private Direction direction;
    private PositionMower positionMower;
    private Lawn lawn;


    public Mower(int x, int y, Direction direction, Lawn lawn) {
        this.lawn = lawn;

        this.positionMower = new PositionMower(x, y, lawn);
        this.direction = direction;
    }

    public Mower(PositionMower positionMower, Direction direction) {
        this.positionMower = positionMower;
        this.direction = direction;
    }

    public Mower executeCommand(String command) {

        Mower mower = this;
        for (Command actualCommand : new ParserCommand().parsing(command)) {
            mower = moveMower(mower, actualCommand, this.lawn);
            this.positionMower = mower.positionMower;
            this.direction = mower.direction;
        }
        return this;
    }

    public Mower moveForward(Command command, PositionMower positionMower, Direction direction, Lawn lawn) {
        if (command.getUnitCommand() == ('A')) {
            return direction.move(direction, positionMower, lawn);
        }
        return new Mower(positionMower.x(), positionMower.y(), direction, lawn);
    }

    private Mower moveMower(Mower mower, Command actualCommand, Lawn lawn) {
        mower = moveForward(actualCommand, mower.getPositionMower(), mower.getDirection(), lawn);

        Direction actualDirection = rotate(actualCommand, mower.getDirection());
        this.positionMower = mower.positionMower;
        this.direction = actualDirection;

        return this;
    }

    public Direction getDirection() {
        return direction;
    }

    public PositionMower getPositionMower() {
        return positionMower;
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
