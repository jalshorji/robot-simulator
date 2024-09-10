package org.example.Move;

import org.example.Move.MovementStrategy;
import org.example.Position;

public class SouthMovementStrategy implements MovementStrategy {
    @Override
    public Position move(Position position) {
        return new Position(position.x(), position.y() - 1, position.direction());
    }
}
