package org.example;

import java.util.HashMap;
import java.util.Map;

public class Simulator {
    private final Table table;
    private final Robot robot;
    private final Map<CommandType, Command> commands = new HashMap<>();

    public Simulator(Table table, Robot robot) {
        this.table = table;
        this.robot = robot;
        initCommands();
    }

    private void initCommands() {
        commands.put(CommandType.PLACE, new PlaceCommand(robot, table));
        commands.put(CommandType.MOVE, new MoveCommand(robot, table));
        commands.put(CommandType.LEFT, new LeftCommand(robot));
        commands.put(CommandType.RIGHT, new RightCommand(robot));
        commands.put(CommandType.REPORT, new ReportCommand(robot));
    }

    public String execute(String input) {
        String[] strings = input.split(" ");

        CommandType commandType;
        try {
            commandType = CommandType.valueOf(strings[0]);
        } catch (IllegalArgumentException e) {
            return null;
        }

        if (!commandType.isValid(input)) {
            return null;
        }

        if (!robot.isPlaced() && !commandType.equals(CommandType.PLACE)) {
            return null;
        }

        return commands.get(commandType).execute(strings);
    }

}
