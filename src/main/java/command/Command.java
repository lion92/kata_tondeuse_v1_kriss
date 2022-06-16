package command;

import direction.Direction;
import mower.Mower;
import mower.PositionMower;
import parserCommand.ParserCommand;

import java.util.List;
import java.util.Objects;

public class Command {


    private char unitCommand;

    public Command(char c) {
        this.unitCommand = c;
    }

    public Command() {

    }

    public Mower executeCommand(String command, Mower mower) {
        for(Command actualCommand:new ParserCommand().parsing(command)){
            Direction actualDirection;
            if (actualCommand.unitCommand==('A')) {
                mower=actualCommand.moveForward(mower.getPositionMower(), mower.getDirection());
            }
            actualDirection = actualCommand.rotate(actualCommand, mower.getDirection());

            mower= new Mower(mower.getPositionMower().getX(), mower.getPositionMower().getY(), actualDirection);
        }
        return mower;
        }


    public Direction rotate
            (Command command, Direction direction) {
        Direction actualDirection = direction;
        if (command.equals(new Command('L'))) {
            actualDirection = new Command().turnLeft(direction);
        }
        if (command.equals(new Command('R'))) {
            actualDirection = new Command().turnRight(direction);
        }
        return actualDirection;
    }

    public Direction turnRight(Direction direction) {
        return direction.getiDirection().turnRight();
    }

    public Direction turnLeft(Direction direction) {
        return direction.getiDirection().turnLeft();
    }

    public Mower moveForward(PositionMower positionMower, Direction direction) {
        return direction.move(direction, positionMower);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Command command = (Command) o;
        return unitCommand == command.unitCommand;
    }

    @Override
    public int hashCode() {
        return Objects.hash(unitCommand);
    }

    @Override
    public String toString() {
        return "Command{" +
                "unitCommand=" + unitCommand +
                '}';
    }
}
