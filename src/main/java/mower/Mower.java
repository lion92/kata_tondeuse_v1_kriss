package mower;

import command.Command;
import direction.Direction;
import parserCommand.ParserCommand;

import java.util.Objects;

public class Mower {
    private final Direction direction;
    private final PositionMower positionMower;

    public Mower(int x, int y, Direction direction) {
        this.positionMower = new PositionMower(x, y);
        this.direction = direction;
    }

    public Mower(PositionMower positionMower, Direction direction) {
        this.positionMower = positionMower;
        this.direction = direction;
    }

    public Mower executeCommand(String command) {
        Mower mower = this;
        for(Command actualCommand:new ParserCommand().parsing(command)){
            mower = moveMower(mower, actualCommand);
        }
        return mower;
    }

    private Mower moveMower(Mower mower, Command actualCommand) {
        Direction actualDirection;
        mower = actualCommand.moveForward(mower.getPositionMower(), mower.getDirection());
        actualDirection = actualCommand.rotate(actualCommand, mower.getDirection());
        mower = new Mower(mower.getPositionMower().getX(), mower.getPositionMower().getY(), actualDirection);
        return mower;
    }

    public Direction getDirection() {
        return direction;
    }

    public PositionMower getPositionMower() {
        return positionMower;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mower mower = (Mower) o;
        return Objects.equals(positionMower, mower.positionMower) && direction == mower.direction;
    }

    @Override
    public int hashCode() {
        return Objects.hash(positionMower, direction);
    }

    @Override
    public String toString() {
        return "Mower{" +
                "position=" + positionMower +
                ", direction=" + direction +
                '}';
    }
}
