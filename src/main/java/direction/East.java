package direction;

import lawn.Lawn;
import mower.Mower;
import mower.PositionMower;

public class East implements IDirection {

    @Override
    public Mower move(PositionMower positionMower, Lawn lawn) {
        positionMower = getActualPositionMower(positionMower, lawn);
        return new Mower(positionMower.x(), positionMower.y(), Direction.EAST, lawn, isObstacle -> false);
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
    public PositionMower getActualPositionMower(PositionMower positionMower, Lawn lawn) {
        return new PositionMower(positionMower.x() + 1, positionMower.y(), lawn);
    }


}
