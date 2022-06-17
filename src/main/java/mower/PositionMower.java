package mower;

import lawn.Lawn;

public record PositionMower(int x, int y, Lawn lawn) {


    public PositionMower(int x, int y, Lawn lawn) {
        this.lawn = lawn;
        x = getXmin(x);
        y = getYmin(y);
        x = getXmax(x, lawn);
        y = getYmax(y, lawn);
        this.x = x;
        this.y = y;

    }

    private int getYmax(int y, Lawn lawn) {
        if (y > lawn.y()) {
            y = lawn.y();
        }
        return y;
    }

    private int getXmax(int x, Lawn lawn) {
        if (x > lawn.x()) {
            x = lawn.x();
        }
        return x;
    }

    private int getYmin(int y) {
        if (y < 0) {
            y = 0;
        }
        return y;
    }

    private int getXmin(int x) {
        if (x < 0) {
            x = 0;
        }
        return x;
    }


}
