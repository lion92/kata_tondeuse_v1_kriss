package mower;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Mowers {

    private final List<Mower> currentMowers;

    public Mowers(List<Mower> currentMowers) {
        this.currentMowers = currentMowers;
    }

    public List<Mower> executeMultipleMowers() {
        List<Mower> currentMowersfinal = new ArrayList<>();
        currentMowers.forEach(mower -> {
            mower.executeCommand(new ObstacleDetection(this, mower));

            currentMowersfinal.add(mower);
        });
        return currentMowers;
    }

    @Override
    public String toString() {
        return "Mowers{" +
                "currentMowers=" + currentMowers +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Mowers)) return false;
        Mowers mowers = (Mowers) o;
        return Objects.equals(currentMowers, mowers.currentMowers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(currentMowers);
    }

    public List<Mower> currentMowers() {
        return currentMowers;
    }
}
