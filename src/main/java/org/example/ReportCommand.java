package org.example;

public class ReportCommand implements Command {
    private final Robot robot;

    public ReportCommand(Robot robot) {
        this.robot = robot;
    }

    @Override
    public String execute(String[] strings) {
        return "Output: " + robot.getPosition().toString();
    }
}
