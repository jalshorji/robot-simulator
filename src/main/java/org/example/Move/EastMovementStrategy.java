package org.example.Move;

import org.example.Position;

public class EastMovementStrategy implements MovementStrategy {
    @Override
    public Position nextPosition(Position currentPosition) {
        return new Position(currentPosition.x() + 1, currentPosition.y(), currentPosition.direction());
    }
}
