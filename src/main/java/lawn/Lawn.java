package lawn;

import mower.Mower;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class Lawn {
    private final int x;
    private final int y;


    public Lawn(int x, int y) {
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lawn lawn = (Lawn) o;
        return x == lawn.x && y == lawn.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "Lawn{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
