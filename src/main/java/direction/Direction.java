package direction;

public enum Direction {
    WEST(new West()), SOUTH(new South()), EAST(new East()), NORTH(new North());
    private final IDirection iDirection;
    private Direction(IDirection iDirection){
        this.iDirection = iDirection;
    }

    public IDirection getiDirection() {
        return iDirection;
    }
}
