package org.example;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;


public class CommandTypeTest {

    @Test
    public void testPlaceCommandIsValid() {
        assertTrue(CommandType.PLACE.isValid("PLACE 1,2,NORTH"));
        assertTrue(CommandType.PLACE.isValid("PLACE 3,4,SOUTH"));
        assertTrue(CommandType.PLACE.isValid("PLACE 0,0,EAST"));

        assertFalse(CommandType.PLACE.isValid("PLACE 1,2,UP"));
        assertFalse(CommandType.PLACE.isValid("PLACE 1,2"));
        assertFalse(CommandType.PLACE.isValid("PLACE"));
    }


    @Test
    public void testMoveCommandIsValid() {
        assertTrue(CommandType.MOVE.isValid("MOVE"));
    }
}