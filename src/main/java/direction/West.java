package direction;

import lawn.Lawn;
import mower.Mower;
import mower.PositionMower;

public class West implements IDirection {

    @Override
    public Mower move(PositionMower positionMower, Lawn lawn) {
        positionMower = getActualPositionMower(positionMower, lawn);
        return new Mower(positionMower, Direction.WEST);
    }

    public PositionMower getActualPositionMower(PositionMower positionMower, Lawn lawn) {
        return new PositionMower(positionMower.getX() - 1, positionMower.getY(), lawn);
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
