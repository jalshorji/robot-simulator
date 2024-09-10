package org.example;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;


public class CommandTest {

    @Test
    public void testPlaceCommandIsValid() {
        assertTrue(Command.PLACE.isValid("PLACE 1,2,NORTH"));
        assertTrue(Command.PLACE.isValid("PLACE 3,4,SOUTH"));
        assertTrue(Command.PLACE.isValid("PLACE 0,0,EAST"));

        assertFalse(Command.PLACE.isValid("PLACE 1,2,UP"));
        assertFalse(Command.PLACE.isValid("PLACE 1,2"));
        assertFalse(Command.PLACE.isValid("PLACE"));
    }


    @Test
    public void testMoveCommandIsValid() {
        assertTrue(Command.MOVE.isValid("MOVE"));
    }
}