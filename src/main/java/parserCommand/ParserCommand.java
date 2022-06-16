package parserCommand;

import command.Command;

import java.util.List;
import java.util.stream.Collectors;

public class ParserCommand {

    public List<Command> parsing(String command) {

        return command.chars().mapToObj(c -> new Command((char) c)).collect(Collectors.toList());

    }
}
