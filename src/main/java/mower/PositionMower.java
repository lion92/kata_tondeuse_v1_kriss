package mower;

import java.util.Objects;

public class PositionMower {
    private final int x;
    private final int y;

    public PositionMower(int x, int y) {
        if(x<0) {
            x = 0;
        }
        if(y>5){
            y=5;
        }
        if(y<0){
            y=0;
        }
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return "PositionMower{" +
                "x=" + x +
                ", y=" + y +
                '}';
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
}
