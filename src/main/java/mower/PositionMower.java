package mower;

import lawn.Lawn;

import java.util.Objects;

public class PositionMower {
    private final int x;
    private final int y;

    public PositionMower(int x, int y, Lawn lawn) {
        x = getXmin(x);
        y = getYmin(y);
        x = getXmax(x, lawn);
        y = getYmax(y, lawn);
        this.x = x;
        this.y = y;
    }

    private int getYmax(int y, Lawn lawn) {
        if (y > lawn.getY()) {
            y = lawn.getY();
        }
        return y;
    }

    private int getXmax(int x, Lawn lawn) {
        if (x > lawn.getX()) {
            x = lawn.getX();
        }
        return x;
    }

    private int getYmin(int y) {
        if (y < 0) {
            y = 0;
        }
        return y;
    }

    private int getXmin(int x) {
        if (x < 0) {
            x = 0;
        }
        return x;
    }


    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PositionMower that = (PositionMower) o;
        return x == that.x && y == that.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }


    @Override
    public String
    toString() {
        return "PositionMower{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
