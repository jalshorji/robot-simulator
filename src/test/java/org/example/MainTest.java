package org.example;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class MainTest {

    @Test
    public void testRobotCommandsFromFile() {
        Robot robot = new Robot();
        Table table = new Table(5, 5);
        Simulator simulator = new Simulator(table, robot);

        try (BufferedReader br = new BufferedReader(new FileReader("src/test/resources/test-file.txt"))) {
            String command;
            StringBuilder actualOutput = new StringBuilder();
            String expectedOutput = getExpectedOutput();

            while ((command = br.readLine()) != null) {
                String result = simulator.execute(command.trim());
                if (result != null) {
                    actualOutput.append(result).append("\n");
                }
            }

            // Trim both actual and expected outputs
            assertEquals(expectedOutput.trim(), actualOutput.toString().trim());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String getExpectedOutput() {
        return """
            Output: 1,2,NORTH
            Output: 0,1,NORTH
            Output: 0,0,WEST
            Output: 3,3,NORTH
            Output: 0,0,SOUTH
            Output: 0,0,WEST
            Output: 4,4,NORTH
            Output: 4,4,EAST
            Output: 0,1,NORTH
            Output: 2,1,EAST
            Output: 2,1,SOUTH
            Output: 2,3,WEST
            Output: 0,0,WEST
            Output: 0,0,NORTH
            Output: 0,0,EAST
            Output: 0,0,NORTH
            Output: 0,1,NORTH
            Output: 2,1,WEST
            Output: 2,4,NORTH
            Output: 2,0,SOUTH
            Output: 4,2,EAST
            Output: 0,2,WEST
            Output: 1,3,NORTH
            Output: 4,4,EAST
            Output: 4,4,NORTH
            """;
    }
}