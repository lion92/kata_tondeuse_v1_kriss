package mower;

import direction.Direction;

public class Mower {
    private final int x;
    private final int y;
    private final Direction direction;

    public Mower(int x, int y, Direction direction) {

        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public Mower receiveCommand(String command) {
        return null;
    }
}
