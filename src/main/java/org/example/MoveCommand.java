package org.example;

import java.util.Arrays;
import java.util.stream.Collectors;

public class MoveCommand implements Command {
    private final Robot robot;
    private final Table table;

    public MoveCommand(Robot robot, Table table) {
        this.robot = robot;
        this.table = table;
    }

    @Override
    public String execute(String[] strings) {
        Position newPosition = robot.getNextPosition();
        if (table.positionsWithinTable(newPosition.x(), newPosition.y())) {
            robot.move(newPosition);
        }
        return null;
    }
}
