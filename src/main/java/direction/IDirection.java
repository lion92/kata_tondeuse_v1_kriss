package direction;

import mower.Mower;
import mower.PositionMower;

public interface IDirection {
    Mower move(PositionMower positionMower);
}
