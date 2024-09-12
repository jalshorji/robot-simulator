package org.example;

public class RightCommand implements Command {
    private final Robot robot;

    public RightCommand(Robot robot) {
        this.robot = robot;
    }

    @Override
    public String execute(String[] strings) {
        robot.rotateRight();
        return null;
    }
}
