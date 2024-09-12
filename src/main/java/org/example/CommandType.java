package org.example;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum CommandType {
    PLACE("PLACE\\s+\\d+,\\d+,(NORTH|SOUTH|EAST|WEST)"),
    MOVE("MOVE"),
    LEFT("LEFT"),
    RIGHT("RIGHT"),
    REPORT("REPORT");

    private String validationRegex;

    CommandType() {
    }

    CommandType(String validationRegex) {
        this.validationRegex = validationRegex;
    }

    public boolean isValid(String commandString) {
        if (this.validationRegex == null) {
            return true;
        }
        Pattern pattern = Pattern.compile(this.validationRegex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(commandString.trim());
        return matcher.matches();
    }
}
