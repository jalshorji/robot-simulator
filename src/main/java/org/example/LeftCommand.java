package org.example;

public class LeftCommand implements Command {
    private final Robot robot;

    public LeftCommand(Robot robot) {
        this.robot = robot;
    }

    @Override
    public String execute(String[] strings) {
        robot.rotateLeft();
        return null;
    }
}
