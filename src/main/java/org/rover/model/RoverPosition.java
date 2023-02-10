package org.rover.model;

public class RoverPosition {
    private int x;
    private int y;

    int Orientation;


    public RoverPosition(int x, int y, int orientation) {
        this.x = x;
        this.y = y;
        Orientation = orientation;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getOrientation() {
        return Orientation;
    }

    public void setOrientation(int orientation) {
        Orientation = orientation;
    }

}
