package direction;

import mower.Mower;
import mower.PositionMower;

public class South implements IDirection{

    @Override
    public Mower move(PositionMower positionMower) {
        positionMower=new PositionMower(positionMower.getX(), positionMower.getY()-1);
        return new Mower(positionMower,Direction.SOUTH);
    }

    @Override
    public Direction turnLeft() {
        return Direction.EAST;
    }

    @Override
    public Direction turnRight() {
        return Direction.WEST;
    }
}
