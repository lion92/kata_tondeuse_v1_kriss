package main;

import mower.Mower;
import parserCommand.ParserCommand;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Mower> mowers = new ParserCommand().parsingFile();

        mowers.forEach(mower -> System.out.println(mower.executeCommand(mower.getListCommand()).toString()));

    }


}
