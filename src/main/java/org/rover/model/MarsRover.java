package org.rover.model;

public class MarsRover implements Rover {
    Plateau plateau;

    RoverPosition position;

    public MarsRover(Plateau plateau, RoverPosition position) {
        this.plateau = plateau;
        this.position = position;
    }

    @Override
    public void move(String direction) {
        char[] actions = direction.toCharArray();
        for (Character action : actions) {
            switch (action) {
                case 'L' -> position.setOrientation(position.getOrientation() - 90);
                case 'R' -> position.setOrientation(position.getOrientation() + 90);
                // case 'M' -> change(position);
            }
        }

    }

}
