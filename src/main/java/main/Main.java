package main;

import mower.Mower;
import parserCommand.ParserCommand;

import java.util.List;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        List<Mower> mowers = new ParserCommand().parsingFile();
        mowers.forEach(mower -> System.out.println(mower.executeCommand(new Predicate<>() {
            public boolean test(Boolean obstacle) {
                for (Mower mowerOfList : mowers) {
                    if (mowerOfList != mower) {
                        if (mower.moveForward().getPositionMower().equals(mowerOfList.getPositionMower())) {
                            System.out.println("Obstacle");
                            obstacle = true;
                        }
                    }

                }
                return obstacle;
            }
        }).toString()));

    }


}
