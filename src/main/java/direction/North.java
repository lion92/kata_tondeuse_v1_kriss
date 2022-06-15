package direction;

import mower.Mower;
import mower.PositionMower;

public class North implements IDirection{

    @Override
    public Mower move(PositionMower positionMower) {
       positionMower=new PositionMower(positionMower.getX(), positionMower.getY()+1);
        return new Mower(positionMower,Direction.NORTH);
    }
}
