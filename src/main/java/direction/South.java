package direction;

import lawn.Lawn;
import mower.Mower;
import mower.PositionMower;

public class South implements IDirection {

    @Override
    public Mower move(PositionMower positionMower, Lawn lawn) {
        positionMower = getActualPositionMower(positionMower, lawn);
        return new Mower(positionMower.x(), positionMower.y(), Direction.SOUTH, lawn, isObstacle -> false);
    }


    @Override
    public Direction turnLeft() {
        return Direction.EAST;
    }

    @Override
    public Direction turnRight() {
        return Direction.WEST;
    }

    @Override
    public PositionMower getActualPositionMower(PositionMower positionMower, Lawn lawn) {
        return new PositionMower(positionMower.x(), positionMower.y() - 1, lawn);
    }
}
