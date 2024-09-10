
package org.example;

public record Position(int x, int y, Direction direction) {

    public String toString() {
        return x +
                "," +
                y +
                "," +
                direction;
    }

}
