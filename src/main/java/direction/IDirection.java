package direction;

import mower.Mower;
import mower.PositionMower;

public interface IDirection {
    Mower move(PositionMower positionMower);

    Direction turnLeft();

    Direction turnRight();

    PositionMower getActualPositionMower(PositionMower positionMower);
}
