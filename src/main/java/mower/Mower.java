package mower;

import direction.Direction;

import javax.swing.text.Position;
import java.util.Objects;

public class Mower {

    private final PositionMower position;
    private final Direction direction;

    public Mower(int x, int y, Direction direction){
        this.position=new PositionMower(x,y);
        this.direction=direction;

    }

    public Mower receiveCommand(String command) {
        return new Mower(0, position.getY() +1, Direction.NORTH);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mower mower = (Mower) o;
        return Objects.equals(position, mower.position) && direction == mower.direction;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, direction);
    }

    @Override
    public String toString() {
        return "Mower{" +
                "position=" + position +
                ", direction=" + direction +
                '}';
    }
}
