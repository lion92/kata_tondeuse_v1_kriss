package direction;

import lawn.Lawn;
import mower.Mower;
import mower.PositionMower;

public class West implements IDirection {

    @Override
    public Mower move(PositionMower positionMower, Lawn lawn) {
        positionMower = getActualPositionMower(positionMower, lawn);
        return new Mower(positionMower.x(), positionMower.y(), Direction.WEST, lawn);
    }

    public PositionMower getActualPositionMower(PositionMower positionMower, Lawn lawn) {
        return new PositionMower(positionMower.x() - 1, positionMower.y(), lawn);
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
