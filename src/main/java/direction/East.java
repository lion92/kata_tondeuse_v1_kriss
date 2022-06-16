package direction;

import mower.Mower;
import mower.PositionMower;

public class East implements IDirection {

    @Override
    public Mower move(PositionMower positionMower) {
        positionMower = getActualPositionMower(positionMower);
        return new Mower(positionMower, Direction.EAST);
    }

    @Override
    public Direction turnLeft() {
        return Direction.NORTH;
    }

    @Override
    public Direction turnRight() {
        return Direction.SOUTH;
    }

    @Override
    public PositionMower getActualPositionMower(PositionMower positionMower) {
        return new PositionMower(positionMower.getX() + 1, positionMower.getY());
    }


}
