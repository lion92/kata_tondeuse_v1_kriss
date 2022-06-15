package direction;

import mower.Mower;
import mower.PositionMower;

public enum Direction {
    WEST(new West()), SOUTH(new South()), EAST(new East()), NORTH(new North());
    private final IDirection iDirection;
    private Direction(IDirection iDirection){
        this.iDirection = iDirection;
    }

    public IDirection getiDirection() {
        return iDirection;
    }

    public Mower move(Direction direction, PositionMower positionMower) {
        return direction.getiDirection().move(positionMower);
    }
}
