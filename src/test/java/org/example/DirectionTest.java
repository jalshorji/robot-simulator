package org.example;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DirectionTest {

    @Test
    public void testGetLeft() {
        assertEquals(Direction.WEST, Direction.NORTH.getLeft());
        assertEquals(Direction.NORTH, Direction.EAST.getLeft());
        assertEquals(Direction.EAST, Direction.SOUTH.getLeft());
        assertEquals(Direction.SOUTH, Direction.WEST.getLeft());
    }

    @Test
    public void testGetRight() {
        assertEquals(Direction.EAST, Direction.NORTH.getRight());
        assertEquals(Direction.SOUTH, Direction.EAST.getRight());
        assertEquals(Direction.WEST, Direction.SOUTH.getRight());
        assertEquals(Direction.NORTH, Direction.WEST.getRight());
    }
}