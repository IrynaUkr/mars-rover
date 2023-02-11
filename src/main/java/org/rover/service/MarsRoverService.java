package org.rover.service;

import org.rover.exception.IncorrectDirectionException;
import org.rover.exception.StepOutOfBorderException;
import org.rover.model.MarsRover;
import org.rover.model.Orientation;
import org.rover.model.RoverPosition;

public class MarsRoverService {
    public static final String MESSAGE = "The Rover can't move on, the border has been reached.";
    MarsRover rover;

    public MarsRoverService(MarsRover rover) {
        this.rover = rover;
    }

    public RoverPosition move(String direction) {
        char[] actions = direction.toCharArray();
        for (Character action : actions) {
            switch (action) {
                case 'L' -> turnLeft(rover);
                case 'R' -> turnRight(rover);
                case 'M' -> goForward(rover);
                default -> throw new IncorrectDirectionException("Direction should be L,R or M");
            }
        }
        return rover.getPosition();
    }

    private void goForward(MarsRover rover) {
        RoverPosition position = rover.getPosition();
        Orientation orientation = position.getOrientation();

        switch (orientation) {
            case NORTH -> changeYPositionGoForward(rover);
            case SOUTH -> changeYPositionGoBack(rover);
            case EAST -> changeXPositionGoRight(rover);
            case WEST -> changeXPositionGoLeft(rover);
        }
    }

    private static void changeYPositionGoForward(MarsRover rover) {
        RoverPosition position = rover.getPosition();
        int borderY = rover.getPlateau().getPosY();
        int roverStepY = position.getY() + 1;
        if (borderY >= roverStepY) {
            position.setY(roverStepY);
        } else throw new StepOutOfBorderException(MESSAGE);
    }
    private static void changeYPositionGoBack(MarsRover rover) {
        RoverPosition position = rover.getPosition();
        int borderY = 0;
        int roverStepY = position.getY() - 1;
        if (borderY <= roverStepY) {
            position.setY(roverStepY);
        } else throw new StepOutOfBorderException(MESSAGE);
    }
    private static void changeXPositionGoRight(MarsRover rover) {
        RoverPosition position = rover.getPosition();
        int borderX = rover.getPlateau().getPosX();
        int roverStepX = position.getX() + 1;
        if (borderX >= roverStepX) {
            position.setX(roverStepX);
        } else throw new StepOutOfBorderException(MESSAGE);
    }
    private static void changeXPositionGoLeft(MarsRover rover) {
        RoverPosition position = rover.getPosition();
        int borderX = 0;
        int roverStepX = position.getX() - 1;
        if (borderX <= roverStepX) {
            position.setX(roverStepX);
        } else throw new StepOutOfBorderException(MESSAGE);
    }

    private void turnRight(MarsRover rover) {
        RoverPosition position = rover.getPosition();
        Orientation orientation = position.getOrientation();

        switch (orientation) {
            case NORTH -> position.setOrientation(Orientation.EAST);
            case EAST -> position.setOrientation(Orientation.SOUTH);
            case SOUTH -> position.setOrientation(Orientation.WEST);
            case WEST -> position.setOrientation(Orientation.NORTH);
        }
    }

    private void turnLeft(MarsRover rover) {
        RoverPosition position = rover.getPosition();
        Orientation orientation = position.getOrientation();

        switch (orientation) {
            case NORTH -> position.setOrientation(Orientation.WEST);
            case EAST -> position.setOrientation(Orientation.NORTH);
            case SOUTH -> position.setOrientation(Orientation.EAST);
            case WEST -> position.setOrientation(Orientation.SOUTH);
        }
    }

}
