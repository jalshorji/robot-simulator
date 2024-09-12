package org.example;

public class PlaceCommand implements Command {
    private final Robot robot;
    private final Table table;

    public PlaceCommand(Robot robot, Table table) {
        this.robot = robot;
        this.table = table;
    }

    @Override
    public String execute(String[] strings) {
        Position position = extractPosition(strings);
        int x = position.x();
        int y = position.y();
        if (table.positionsWithinTable(x, y)) {
            robot.place(new Position(x, y, position.direction()));
        }
        return null;
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
