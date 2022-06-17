package direction;

import lawn.Lawn;
import mower.Mower;
import mower.PositionMower;

public class North implements IDirection {

    @Override
    public Mower move(PositionMower positionMower,Lawn lawn) {
        positionMower = getActualPositionMower(positionMower, lawn);
        return new Mower(positionMower, Direction.NORTH);
    }

    public PositionMower getActualPositionMower(PositionMower positionMower, Lawn lawn) {
        positionMower = new PositionMower(positionMower.getX(), positionMower.getY() + 1,lawn);
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
