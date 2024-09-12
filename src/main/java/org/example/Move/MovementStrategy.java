package org.example.Move;

import org.example.Position;

public interface MovementStrategy {
    Position nextPosition(Position currentPosition);
}
