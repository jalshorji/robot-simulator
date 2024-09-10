package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TableTest {

    private Table table;

    @BeforeEach
    public void setUp() {
        table = new Table(5, 5);
    }

    @Test
    public void testPositionWithinBounds() {
        assertTrue(table.positionsWithinTable(0, 0));
        assertTrue(table.positionsWithinTable(4, 4));
        assertTrue(table.positionsWithinTable(3, 2));
    }

    @Test
    public void testPositionOutOfBounds() {
        assertFalse(table.positionsWithinTable(-1, 0));
        assertFalse(table.positionsWithinTable(0, -1));
        assertFalse(table.positionsWithinTable(6, 5));
        assertFalse(table.positionsWithinTable(5, 6));
        assertFalse(table.positionsWithinTable(6, 6));
    }

    @Test
    public void testPositionOnBorder() {
        assertTrue(table.positionsWithinTable(0, 4));
        assertTrue(table.positionsWithinTable(4, 0));
    }
}