package direction;

import lawn.Lawn;
import mower.Mower;
import mower.PositionMower;

public interface IDirection {
    Mower move(PositionMower positionMower,Lawn lawn);

    Direction turnLeft();

    Direction turnRight();

    PositionMower getActualPositionMower(PositionMower positionMower, Lawn lawn);
}
