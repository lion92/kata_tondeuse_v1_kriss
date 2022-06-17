package lawn;

import mower.Mower;

import java.util.ArrayList;
import java.util.List;

public class Lawn {
    private final int x;
    private final int y;
    private final List<Mower>mowers;

    public Lawn(int x, int y) {
        mowers=new ArrayList<>();
        this.x = x;
        this.y = y;
    }

    public void addMower(Mower mower) {
        mowers.add(mower);
    }

    public int getX() {
        return x;
    }



    public int getY() {
        return y;
    }

    public List<Mower> getMowers() {
        return mowers;
    }
}
