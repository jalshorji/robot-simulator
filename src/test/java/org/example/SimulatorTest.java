package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SimulatorTest {

    public static final int ROWS = 5;
    public static final int COLUMNS = 5;



    @Test
    void commandInValid() {
        // given
        Table table = new Table(ROWS, COLUMNS);
        Robot robot = new Robot();
        Simulator simulator = new Simulator(table, robot);

        // when
        String report = simulator.execute("RUN");

        // then
        assertNull(report);

    }

    @Test
    void placeCommandMissingPositions() {
        // given
        Table table = new Table(ROWS, COLUMNS);
        Robot robot = new Robot();
        Simulator simulator = new Simulator(table, robot);

        // when
        String report = simulator.execute("PLACE");

        // then
        assertNull(report);
    }

    @Test
    void placeRobot_correctPositions() {
        // give
        Table table = new Table(ROWS, COLUMNS);
        Robot robot = new Robot();
        Simulator simulator = new Simulator(table, robot);

        // when
        simulator.execute("PLACE 0,1,NORTH");

        // then
        Position position = robot.getPosition();
        assertEquals(0, position.x());
        assertEquals(1, position.y());
        assertEquals(Direction.NORTH, position.direction());
    }

    @Test
    void placeRobot_missingArguments() {
        // give
        Table table = new Table(ROWS, COLUMNS);
        Robot robot = new Robot();
        Simulator simulator = new Simulator(table, robot);

        // when
        String report = simulator.execute("PLACE 0,0");

        // then
        assertNull(report);
    }

    @Test
    void placeRobot_positionOutsideTableSize() {
        // give
        Table table = new Table(ROWS, COLUMNS);
        Robot robot = new Robot();
        Simulator simulator = new Simulator(table, robot);

        // when
        String report = simulator.execute("PLACE 7,6,NORTH");

        // then
        assertNull(report);
    }

    @Test
    void placeRobot_negativePosition() {
        // give
        Table table = new Table(ROWS, COLUMNS);
        Robot robot = new Robot();
        Simulator simulator = new Simulator(table, robot);

        // when
        String report = simulator.execute("PLACE -7,2,NORTH");

        // then
        assertNull(report);
    }

    @Test
    void moveRobot_happyPathNorth() {
        // give
        Table table = new Table(ROWS, COLUMNS);
        Robot robot = new Robot();
        Simulator simulator = new Simulator(table, robot);
        simulator.execute("PLACE 0,0,NORTH");

        // when
        simulator.execute("MOVE");

        // then
        assertEquals("0,1,NORTH", robot.getPosition().toString());
    }

    @Test
    void moveRobot_happyPathSouth() {
        // give
        Table table = new Table(ROWS, COLUMNS);
        Robot robot = new Robot();
        Simulator simulator = new Simulator(table, robot);
        simulator.execute("PLACE 4,4,SOUTH");

        // when
        simulator.execute("MOVE");

        // then
        assertEquals("4,3,SOUTH", robot.getPosition().toString());
    }

    @Test
    void moveRobot_happyPathEast() {
        // give
        Table table = new Table(ROWS, COLUMNS);
        Robot robot = new Robot();
        Simulator simulator = new Simulator(table, robot);
        simulator.execute("PLACE 1,1,EAST");

        // when
        simulator.execute("MOVE");

        // then
        assertEquals("2,1,EAST", robot.getPosition().toString());
    }


    @Test
    void moveRobot_happyPathWest() {
        // give
        Table table = new Table(ROWS, COLUMNS);
        Robot robot = new Robot();
        Simulator simulator = new Simulator(table, robot);
        simulator.execute("PLACE 1,1,WEST");

        // when
        simulator.execute("MOVE");

        // then
        assertEquals("0,1,WEST", robot.getPosition().toString());
    }

    @Test
    void moveRobot_newPositionOutsideTable_retainSamePosition() {
        // give
        Table table = new Table(ROWS, COLUMNS);
        Robot robot = new Robot();
        Simulator simulator = new Simulator(table, robot);
        simulator.execute("PLACE 0,0,SOUTH");

        // when
        simulator.execute("MOVE");

        // then
        assertEquals("0,0,SOUTH", robot.getPosition().toString());
    }

    @Test
    void rotateRight() {
        // give
        Table table = new Table(ROWS, COLUMNS);
        Robot robot = new Robot();
        Simulator simulator = new Simulator(table, robot);
        simulator.execute("PLACE 0,0,SOUTH");

        // when
        simulator.execute("RIGHT");

        // then
        assertEquals("0,0,WEST", robot.getPosition().toString());
    }

    @Test
    void rotateLeft() {
        // give
        Table table = new Table(ROWS, COLUMNS);
        Robot robot = new Robot();
        Simulator simulator = new Simulator(table, robot);
        simulator.execute("PLACE 0,0,SOUTH");

        // when
        simulator.execute("LEFT");

        // then
        assertEquals("0,0,EAST", robot.getPosition().toString());
    }
}