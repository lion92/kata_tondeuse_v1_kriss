package mower;

import command.Command;
import direction.Direction;
import lawn.Lawn;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

public class Mower {
    private Direction direction;
    private PositionMower positionMower;
    private final Lawn lawn;
    private List<Command> listCommand = new ArrayList<>();
    private final Predicate<Boolean> isObstacles;


    public Mower(int x, int y, Direction direction, Lawn lawn, List<Command> listCommand, Predicate<Boolean> isObstacles) {
        this.lawn = lawn;
        this.listCommand = listCommand;
        this.isObstacles = isObstacles;
        this.positionMower = new PositionMower(x, y, lawn);
        this.direction = direction;
    }


    public Mower(int x, int y, Direction direction, Lawn lawn, Predicate<Boolean> isObstacles) {
        this.lawn = lawn;
        this.positionMower = new PositionMower(x, y, lawn);
        this.direction = direction;
        this.isObstacles = isObstacles;
    }


    public Mower executeCommand() {
        return executeCommand(isObstacle -> false);
    }

    public Mower executeCommand(Predicate<Boolean> obstacleDetection) {
        for (Command actualCommand : listCommand) {
            boolean isObstacle = obstacleDetection.test(false);
            moveMower(actualCommand, isObstacle);
        }
        return this;
    }

    public Mower moveForward() {

        return direction.move(direction, positionMower, lawn);

    }

    public Direction getDirection() {
        return direction;
    }

    public PositionMower getPositionMower() {
        return positionMower;
    }

    public Lawn getLawn() {
        return lawn;
    }

    public List<Command> getListCommand() {
        return listCommand;
    }

    private void moveMower(Command actualCommand, boolean obstacle) {
        rotate(actualCommand);
        if (actualCommand.getUnitCommand() == ('A')) {
            if (!obstacle) {
                this.positionMower = moveForward().positionMower;
            }
        }
    }

    public void rotate(Command command) {
        if (command.equals(new Command('G'))) {
            this.direction = turnLeft();
        }
        if (command.equals(new Command('D'))) {
            this.direction = turnRight();
        }
    }

    public Direction turnRight() {
        return this.direction.getiDirection().turnRight();
    }

    public Direction turnLeft() {
        return this.direction.getiDirection().turnLeft();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Mower)) return false;
        Mower mower = (Mower) o;
        return direction == mower.direction && Objects.equals(positionMower, mower.positionMower) && Objects.equals(lawn, mower.lawn) && Objects.equals(listCommand, mower.listCommand);
    }

    @Override
    public int hashCode() {
        return Objects.hash(direction, positionMower, lawn, listCommand);
    }

    @Override
    public String toString() {
        return "Mower{" +
                "direction=" + direction +
                ", positionMower=" + positionMower +
                ", lawn=" + lawn +
                ", listCommand=" + listCommand +
                '}';
    }
}
