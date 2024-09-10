package org.example;

public class Simulator {
    private final Table table;
    private final Robot robot;

    public Simulator(Table table, Robot robot) {
        this.table = table;
        this.robot = robot;
    }

    public String execute(String input) {
        String[] strings = input.split(" ");

        Command command;
        try {
            command = Command.valueOf(strings[0]);
        } catch (IllegalArgumentException e) {
            return null;
        }

        if (!command.isValid(input)) {
            return null;
        }

        if (!robot.isPlaced() && !command.equals(Command.PLACE)) {
            return null;
        }


        Position position = new Position(0, 0, Direction.NORTH);

        if (command.equals(Command.PLACE)) {
            position = extractPosition(strings);
        }

        String output = null;

        // Man skulle kunna ändra den här switch-satsten till command-pattern istället.
        switch (command) {
            case PLACE -> {
                int x = position.x();
                int y = position.y();
                if (table.positionsWithinTable(x, y)) {
                    robot.place(new Position(x, y, position.direction()));
                }
            }
            case MOVE -> {
                Position newPosition = robot.getNextPosition();
                if (table.positionsWithinTable(newPosition.x(), newPosition.y())) {
                    robot.move(newPosition);
                }
            }
            case LEFT -> robot.rotateLeft();
            case RIGHT -> robot.rotateRight();
            case REPORT -> output = "Output: " + robot.getPosition().toString();
            default -> throw new IllegalArgumentException("Invalid command");
        }
        return output;
    }

    private static Position extractPosition(String[] strings) {
        Position position;
        String[] positions = strings[1].split(",");
        int x = Integer.parseInt(positions[0]);
        int y = Integer.parseInt(positions[1]);
        Direction direction = Direction.valueOf(positions[2]);
        position = new Position(x, y, direction);
        return position;
    }


}
