package direction;

import mower.Mower;
import mower.PositionMower;

public enum Direction {
    NORTH(new North()),
    EAST(new East()),
    SOUTH(new South()),
    WEST(new West());


    private final IDirection iDirection;

    Direction(IDirection iDirection) {
        this.iDirection = iDirection;
    }

    public IDirection getiDirection() {
        return iDirection;
    }

    public Mower move(Direction direction, PositionMower positionMower) {
        return direction.getiDirection().move(positionMower);
    }

}
