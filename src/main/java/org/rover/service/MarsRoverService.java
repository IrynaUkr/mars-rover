package org.rover.service;

import org.rover.model.MarsRover;
import org.rover.model.Orientation;
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
        Orientation orientation = position.getOrientation();

        switch (orientation){
            case NORTH -> position.setOrientation(Orientation.EAST);
            case EAST -> position.setOrientation(Orientation.SOUTH);
            case SOUTH -> position.setOrientation(Orientation.WEST);
            case WEST -> position.setOrientation(Orientation.NORTH);
        }
    }

     private void turnLeft(MarsRover rover) {
        RoverPosition position = rover.getPosition();
        Orientation orientation = position.getOrientation();

        switch (orientation){
            case NORTH -> position.setOrientation(Orientation.WEST);
            case EAST -> position.setOrientation(Orientation.NORTH);
            case SOUTH -> position.setOrientation(Orientation.EAST);
            case WEST -> position.setOrientation(Orientation.SOUTH);
        }
    }

}
