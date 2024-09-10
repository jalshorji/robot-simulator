package org.example;

public class Robot {

    private Position position;
    private boolean isPlaced;

    public Position getPosition() {
        return position;
    }


    public void place(Position position) {
        this.position = position;
        this.isPlaced = true;
    }

    public Position getNextPosition() {
        return position.direction().getMovementStrategy().move(position);
    }

    public void move(Position nextPosition) {
        position = nextPosition;
    }

    public void rotateLeft() {
        position = new Position(position.x(), position.y(), position.direction().getLeft());
    }

    public void rotateRight() {
        position = new Position(position.x(), position.y(), position.direction().getRight());
    }

    public boolean isPlaced() {
        return isPlaced;
    }
}
