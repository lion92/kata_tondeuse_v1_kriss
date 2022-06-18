package parserCommand;

import command.Command;
import direction.Direction;
import lawn.Lawn;
import mower.Mower;
import mower.PositionMower;
import read.Read;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ParserCommand {

    public List<Mower> parsingFile() {
        List<Mower> mowers = getMowersAfterParsing(new File("").getAbsolutePath()+"\\src\\main\\java\\intruction.txt");
        return mowers;
    }
    private List<Mower> getMowersAfterParsing(String path) {
        String acquisition = new Read(path).reading();
        System.out.println(acquisition);
        String[] tabAcquisition = acquisition.split("\n");

        List<Mower> mowers = new ArrayList<>();

        Lawn lawn = new Lawn(Integer.parseInt(tabAcquisition[0].substring(0, 1))
                , Integer.parseInt(tabAcquisition[0].substring(2, 3)));
        PositionMower positionMower = null;
        Direction direction = null;
        for (int ligne = 0; ligne < tabAcquisition.length; ligne++) {

            List<Command> commands = new ArrayList<>();
            if (ligne == 0) {
                continue;
            }

            if (ligne % 2 != 0) {
                System.out.println(tabAcquisition[ligne].substring(2, 3));
                positionMower = new PositionMower(Integer.parseInt(
                        tabAcquisition[ligne].substring(0, 1)),
                        Integer.parseInt(tabAcquisition[ligne].substring(2, 3)), lawn);

                if (tabAcquisition[ligne].substring(4, 5).equals("N")) {
                    direction = Direction.NORTH;
                } else if (tabAcquisition[ligne].substring(4, 5).equals("S")) {
                    direction = Direction.SOUTH;
                } else if (tabAcquisition[ligne].substring(4, 5).equals("E")) {
                    direction = Direction.EAST;
                } else if (tabAcquisition[ligne].substring(4, 5).equals("W")) {
                    direction = Direction.WEST;
                }

            } else {
                for (String s : tabAcquisition[ligne].split("")) {
                    commands.add(new Command(s.charAt(0)));
                }
                mowers.add(new Mower(positionMower.x(), positionMower.y(), direction, lawn, commands));
            }
        }
        return mowers;
    }
}
