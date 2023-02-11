package org.rover.model;

public class MarsRover implements Rover {
    Plateau plateau;

    RoverPosition position;

    public MarsRover(Plateau plateau, RoverPosition position) {
        this.plateau = plateau;
        this.position = position;
    }

    public Plateau getPlateau() {
        return plateau;
    }

    public void setPlateau(Plateau plateau) {
        this.plateau = plateau;
    }

    public RoverPosition getPosition() {
        return position;
    }

    public void setPosition(RoverPosition position) {
        this.position = position;
    }

}


