package org.rover.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.rover.exception.IncorrectDirectionException;
import org.rover.exception.IncorrectPositionException;
import org.rover.exception.StepOutOfBorderException;
import org.rover.model.MarsRover;
import org.rover.model.Orientation;
import org.rover.model.RoverPosition;

import java.util.List;

@Data
@AllArgsConstructor
public class MarsRoverService {
    public static final String BORDER_HAS_BEEN_REACHED = "The Rover can't move on, the border has been reached.";
    public static final String POSITION_OCCUPIED = "new position is already occupied";
    private MarsRover rover;

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
            case N -> changeYPositionGoForward(rover);
            case S -> changeYPositionGoBack(rover);
            case E -> changeXPositionGoRight(rover);
            case W -> changeXPositionGoLeft(rover);
        }
    }

    private static void changeYPositionGoForward(MarsRover rover) {
        RoverPosition position = rover.getPosition();
        int borderY = rover.getPlateau().getPosY();
        int roverStepY = position.getY() + 1;
        if (isPositionOccupied(rover, new RoverPosition(position.getX(),roverStepY,position.getOrientation()))) {
            throw new IncorrectPositionException(POSITION_OCCUPIED);
        }
        if (borderY >= roverStepY) {
            position.setY(roverStepY);
        } else throw new StepOutOfBorderException(BORDER_HAS_BEEN_REACHED);
    }

    private static void changeYPositionGoBack(MarsRover rover) {
        RoverPosition position = rover.getPosition();
        int borderY = 0;
        int roverStepY = position.getY() - 1;
        if (isPositionOccupied(rover, new RoverPosition(position.getX(),roverStepY,position.getOrientation()))) {
            throw new IncorrectPositionException(POSITION_OCCUPIED);
        }
        if (borderY <= roverStepY) {
            position.setY(roverStepY);
        } else throw new StepOutOfBorderException(BORDER_HAS_BEEN_REACHED);
    }

    private static void changeXPositionGoRight(MarsRover rover) {
        RoverPosition position = rover.getPosition();
        int borderX = rover.getPlateau().getPosX();
        int roverStepX = position.getX() + 1;
        if (isPositionOccupied(rover, new RoverPosition(roverStepX,position.getY(),position.getOrientation()))) {
            throw new IncorrectPositionException(POSITION_OCCUPIED);
        }
        if (borderX >= roverStepX) {
            position.setX(roverStepX);
        } else throw new StepOutOfBorderException(BORDER_HAS_BEEN_REACHED);

    }

    private static void changeXPositionGoLeft(MarsRover rover) {
        RoverPosition position = rover.getPosition();
        int borderX = 0;
        int roverStepX = position.getX() - 1;
        if (isPositionOccupied(rover, new RoverPosition(roverStepX,position.getY(),position.getOrientation()))) {
            throw new IncorrectPositionException(POSITION_OCCUPIED);
        }
        if (borderX <= roverStepX) {
            position.setX(roverStepX);
        } else throw new StepOutOfBorderException(BORDER_HAS_BEEN_REACHED);

    }

    private void turnRight(MarsRover rover) {
        RoverPosition position = rover.getPosition();
        Orientation orientation = position.getOrientation();

        switch (orientation) {
            case N -> position.setOrientation(Orientation.E);
            case E -> position.setOrientation(Orientation.S);
            case S -> position.setOrientation(Orientation.W);
            case W -> position.setOrientation(Orientation.N);
        }
    }

    private void turnLeft(MarsRover rover) {
        RoverPosition position = rover.getPosition();
        Orientation orientation = position.getOrientation();

        switch (orientation) {
            case N -> position.setOrientation(Orientation.W);
            case E -> position.setOrientation(Orientation.N);
            case S -> position.setOrientation(Orientation.E);
            case W -> position.setOrientation(Orientation.S);
        }
    }

    private static boolean isPositionOccupied(MarsRover rover, RoverPosition newPosition) {
        List<MarsRover> rovers = rover.getPlateau().getRovers();
        for (MarsRover с : rovers) {
            if (с.getPosition().getY() == newPosition.getY() && с.getPosition().getX() == newPosition.getX()) {
                return true;
            }
        }
        return false;
    }

}
