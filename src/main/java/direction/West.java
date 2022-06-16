package direction;

import mower.Mower;
import mower.PositionMower;

public class West implements IDirection{

    @Override
    public Mower move(PositionMower positionMower) {
        positionMower=new PositionMower(positionMower.getX()-1, positionMower.getY());
        return new Mower(positionMower,Direction.WEST);
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
