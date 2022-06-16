package mower;

import direction.Direction;

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

    public Mower receiveCommand(String command) {
        Direction actualDirection = direction;
        if (command.equals("A")) {
            return moveForward(direction, positionMower);
        }
        if (command.equals("L")) {
            actualDirection = turnLeft();
        }
        if (command.equals("R")) {
            actualDirection = turnRight();
        }

        return new Mower(1, 3, actualDirection);

    }

    private Direction turnRight() {
        return direction.getiDirection().turnRight();
    }

    private Direction turnLeft() {
        return direction.getiDirection().turnLeft();
    }


    private Mower moveForward(Direction direction, PositionMower positionMower) {
        return direction.move(direction, positionMower);
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
