package direction;

import mower.Mower;
import mower.PositionMower;

public class West implements IDirection {

    @Override
    public Mower move(PositionMower positionMower) {
        positionMower = getActualPositionMower(positionMower);
        return new Mower(positionMower, Direction.WEST);
    }

    public PositionMower getActualPositionMower(PositionMower positionMower) {
        return new PositionMower(positionMower.getX() - 1, positionMower.getY());
    }

    @Override
    public Direction turnLeft() {
        return Direction.SOUTH;
    }

    @Override
    public Direction turnRight() {
        return Direction.NORTH;
    }
}
