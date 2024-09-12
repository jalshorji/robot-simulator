package org.example.Move;

import org.example.Move.MovementStrategy;
import org.example.Position;

public class SouthMovementStrategy implements MovementStrategy {
    @Override
    public Position nextPosition(Position currentPosition) {
        return new Position(currentPosition.x(), currentPosition.y() - 1, currentPosition.direction());
    }
}
