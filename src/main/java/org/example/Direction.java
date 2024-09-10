package org.example;

import org.example.Move.*;

import java.util.Map;

public enum Direction {
    NORTH(new NorthMovementStrategy()),
    SOUTH(new SouthMovementStrategy()),
    EAST(new EastMovementStrategy()),
    WEST(new WestMovementStrategy());

    private static final Map<Direction, Direction> LEFT_MAP = Map.of(
            NORTH, WEST,
            EAST, NORTH,
            SOUTH, EAST,
            WEST, SOUTH
    );

    private static final Map<Direction, Direction> RIGHT_MAP = Map.of(
            NORTH, EAST,
            EAST, SOUTH,
            SOUTH, WEST,
            WEST, NORTH
    );

    private final MovementStrategy movementStrategy;

    Direction(MovementStrategy movementStrategy) {
        this.movementStrategy = movementStrategy;
    }

    public Direction getLeft() {
        return LEFT_MAP.get(this);
    }
    public Direction getRight() {
        return RIGHT_MAP.get(this);
    }

    public MovementStrategy getMovementStrategy() {
        return movementStrategy;
    }
}
