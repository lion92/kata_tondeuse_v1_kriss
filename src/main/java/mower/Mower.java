package mower;

import command.Command;
import direction.Direction;
import lawn.Lawn;

import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

public class Mower {
    private Direction direction;
    private PositionMower positionMower;
    private final Lawn lawn;
    private List<Command> listCommand;


    public Mower(int x, int y, Direction direction, Lawn lawn, List<Command> listCommand) {
        this.lawn = lawn;
        this.listCommand = listCommand;
        this.positionMower = new PositionMower(x, y, lawn);
        this.direction = direction;
    }


    public Mower(int x, int y, Direction direction, Lawn lawn) {
        this.lawn = lawn;
        this.positionMower = new PositionMower(x, y, lawn);
        this.direction = direction;
    }


    public Mower executeCommand() {
       return executeCommand(aBoolean -> false);
    }

    public Mower executeCommand(Predicate<Boolean> booleanPredicate) {
        for (Command actualCommand : listCommand) {
            boolean isObstacle = booleanPredicate.test(false);
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

    private Mower moveMower(Command actualCommand, boolean obstacle) {

        Direction actualDirection = rotate(actualCommand);

        if (actualCommand.getUnitCommand() == ('A')) {
            if (obstacle == false) {
                this.positionMower = moveForward().positionMower;
            }
        }
        this.direction = actualDirection;

        return this;
    }


    public Direction rotate
            (Command command) {
        if (command.equals(new Command('G'))) {
            this.direction = turnLeft(direction);
        }
        if (command.equals(new Command('D'))) {
            this.direction = turnRight(direction);
        }
        return this.direction;
    }

    public Direction turnRight(Direction direction) {
        return direction.getiDirection().turnRight();
    }

    public Direction turnLeft(Direction direction) {
        return direction.getiDirection().turnLeft();
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
