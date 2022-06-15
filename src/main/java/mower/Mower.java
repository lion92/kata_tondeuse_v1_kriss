package mower;

import direction.Direction;

import java.util.Objects;

public record Mower(int x, int y, Direction direction) {

    public Mower receiveCommand(String command) {
        return new Mower(0, y+1, Direction.NORTH);
    }

    @Override
    public String toString() {
        return "Mower{" +
                "x=" + x +
                ", y=" + y +
                ", direction=" + direction +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mower mower = (Mower) o;
        return x == mower.x && y == mower.y && direction == mower.direction;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, direction);
    }
}
