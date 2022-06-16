package direction;

import mower.Mower;
import mower.PositionMower;

public class North implements IDirection {

    @Override
    public Mower move(PositionMower positionMower) {
        positionMower = getActualPositionMower(positionMower);
        return new Mower(positionMower, Direction.NORTH);
    }

    public PositionMower getActualPositionMower(PositionMower positionMower) {
        positionMower = new PositionMower(positionMower.getX(), positionMower.getY() + 1);
        return positionMower;
    }

    @Override
    public Direction turnLeft() {
        return Direction.WEST;
    }

    @Override
    public Direction turnRight() {
        return Direction.EAST;
    }
}
