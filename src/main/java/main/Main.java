package main;

import command.Command;
import direction.Direction;
import lawn.Lawn;
import mower.Mower;
import mower.PositionMower;
import parserCommand.ParserCommand;
import read.Read;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
    List<Mower> mowers=new ParserCommand().parsingFile();

    mowers.forEach(mower -> System.out.println(mower.toString()));

    }


}
