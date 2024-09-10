package org.example;

public class Table {
    int rows;
    int columns;

    public Table(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
    }

    public boolean positionsWithinTable(int x, int y) {
        return x >= 0 && x < rows && y >= 0 && y < columns;
    }
}
