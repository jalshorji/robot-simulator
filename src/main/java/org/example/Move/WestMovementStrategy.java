package org.example.Move;

import org.example.Move.MovementStrategy;
import org.example.Position;

public class WestMovementStrategy implements MovementStrategy {
    @Override
    public Position nextPosition(Position currentPosition) {
        return new Position(currentPosition.x() - 1, currentPosition.y(), currentPosition.direction());
    }
}
