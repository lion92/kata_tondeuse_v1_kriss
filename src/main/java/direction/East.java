package direction;

import mower.Mower;
import mower.PositionMower;

public class East implements IDirection{

    @Override
    public Mower move(PositionMower positionMower) {
        positionMower=new PositionMower(positionMower.getX()+1, positionMower.getY());
        return new Mower(positionMower,Direction.EAST);
    }

    @Override
    public Direction turnLeft() {
        return Direction.NORTH;
    }

    @Override
    public Direction turnRight() {
        return Direction.SOUTH;
    }


}
