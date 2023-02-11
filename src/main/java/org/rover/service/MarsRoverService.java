package org.rover.service;

import org.rover.model.MarsRover;
import org.rover.model.RoverPosition;

public class MarsRoverService {
    MarsRover rover;

    public MarsRoverService(MarsRover rover) {
        this.rover = rover;
    }

    public void move(String direction) {
        char[] actions = direction.toCharArray();
        for (Character action : actions) {
            switch (action) {
                case 'L' -> turnLeft(rover);
                case 'R' -> turnRight(rover);
                // case 'M' -> change(position);
            }
        }
    }

    private void turnRight(MarsRover rover) {
        RoverPosition position = rover.getPosition();
        position.setOrientation(position.getOrientation() + 90);
    }

    private void turnLeft(MarsRover rover) {
        RoverPosition position = rover.getPosition();
        position.setOrientation(position.getOrientation() - 90);
    }

}
