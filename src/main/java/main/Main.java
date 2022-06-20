package main;

import mower.Mower;
import mower.Mowers;
import parserCommand.ParserCommand;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        List<Mower> mowers = new ParserCommand().parsingFile();
       List<Mower>currentMowers=new Mowers(mowers).executeMultipleMowers();
        System.out.println(currentMowers.toString());




    }


}
