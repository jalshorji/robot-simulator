package org.example.Move;

import org.example.Position;

public class EastMovementStrategy implements MovementStrategy {
    @Override
    public Position move(Position position) {
        return new Position(position.x() + 1, position.y(), position.direction());
    }
}
