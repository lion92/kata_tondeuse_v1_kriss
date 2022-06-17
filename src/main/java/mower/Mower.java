package mower;

import command.Command;
import direction.Direction;
import lawn.Lawn;
import parserCommand.ParserCommand;

import java.util.Objects;

public class Mower {
    private final Direction direction;
    private final PositionMower positionMower;
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
        }
        return mower;
    }

    private Mower moveMower(Mower mower, Command actualCommand, Lawn lawn) {
        Direction actualDirection;

        mower = actualCommand.moveForward(mower.getPositionMower(), mower.getDirection(), lawn);

        actualDirection = actualCommand.rotate(actualCommand, mower.getDirection());
        mower = new Mower(mower.getPositionMower().getX(), mower.getPositionMower().getY(), actualDirection, lawn);
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
