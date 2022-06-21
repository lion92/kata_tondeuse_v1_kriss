package mower;

import java.util.function.Predicate;

class ObstacleDetection implements Predicate<Boolean> {
    private final Mowers mowers;
    private final Mower mower;

    public ObstacleDetection(Mowers mowers, Mower mower) {
        this.mowers = mowers;
        this.mower = mower;
    }

    public boolean test(Boolean obstacle) {
        for (Mower mowerOfList : mowers.currentMowers()) {
            if (mowerOfList != mower) {
                if (mower.moveForward().getPositionMower().equals(mowerOfList.getPositionMower())) {
                    System.out.println("Obstacle");
                    obstacle = true;
                }
            }

        }

        return obstacle;
    }

}
