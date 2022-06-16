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
        if (command.equals("A")) {
            return moveForward(direction, positionMower);
        }
        if (command.equals("L")) {
            if (direction.equals(Direction.NORTH)) {
                return new Mower(1, 3, Direction.WEST);
            } else if (direction.equals(Direction.WEST)) {
                return new Mower(1, 3, Direction.SOUTH);
            } else if(direction.equals(Direction.SOUTH)){
                return new Mower(1,3,Direction.EAST);
            }else if(direction.equals(Direction.EAST)){
                return new Mower(1,3,Direction.NORTH);
            }

        }

        return null;
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
