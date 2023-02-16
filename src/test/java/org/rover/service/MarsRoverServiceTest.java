package org.rover.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.rover.exception.IncorrectDirectionException;
import org.rover.exception.IncorrectPositionException;
import org.rover.model.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.rover.model.Orientation.*;

class MarsRoverServiceTest {
    public static final String LEFT_DIRECTION = "L";
    public static final String RIGHT_DIRECTION = "R";
    public static final String FORWARD_DIRECTION = "M";
    public static final String INCORRECT_DIRECTION = "U";
    RoverPosition position;
    RectPlateau plateau;
    MarsRover marsRover;
    MarsRoverService roverService;

    @BeforeEach
    void setUp() {
        position = new RoverPosition(3, 3, N);
        plateau = new RectPlateau(5, 5, new ArrayList<>());
        marsRover = new MarsRover(plateau, position);
        roverService = new MarsRoverService(marsRover);
    }

    @Test
    void moveTurnLefChangePositionTest() {
        Orientation actual = roverService.move(LEFT_DIRECTION).getOrientation();
        assertEquals(W, actual);
    }

    @Test
    void moveTurnRightChangePositionTest() {
        Orientation actual = roverService.move(RIGHT_DIRECTION).getOrientation();
        assertEquals(E, actual);
    }

    @Test
    void moveForwardIfOrientationNorth() {
        position.setOrientation(N);
        int actualY = roverService.move(FORWARD_DIRECTION).getY();
        int expectedY = 4;
        assertEquals(expectedY, actualY);
    }

    @Test
    void shouldThrowInvalidPositionExcIfPositionIsOccupiedMoveForwardIfOrientationNorth() {
        List<MarsRover> rovers = new ArrayList<>();
        RoverPosition occupied = new RoverPosition(3, 4, N);
        rovers.add(new MarsRover(plateau, occupied));
        plateau.setRovers(rovers);

        assertThrows(IncorrectPositionException.class, () -> roverService.move(FORWARD_DIRECTION));
    }

    @Test
    void moveForwardIfOrientationSouth() {
        position.setOrientation(S);
        roverService.move(FORWARD_DIRECTION);
        int actualY = marsRover.getPosition().getY();
        int expectedY = 2;
        assertEquals(expectedY, actualY);
    }

    @Test
    void shouldThrowInvalidPositionExcIfPositionIsOccupiedMoveForwardIfOrientationSouth() {
        position.setOrientation(S);
        List<MarsRover> rovers = new ArrayList<>();
        RoverPosition occupied = new RoverPosition(3, 2, S);
        rovers.add(new MarsRover(plateau, occupied));
        plateau.setRovers(rovers);

        assertThrows(IncorrectPositionException.class, () -> roverService.move(FORWARD_DIRECTION));
    }

    @Test
    void moveForwardIfOrientationEast() {
        position.setOrientation(E);

        int actualX = roverService.move(FORWARD_DIRECTION).getX();
        int expectedX = 4;
        assertEquals(expectedX, actualX);
    }

    @Test
    void shouldThrowInvalidPositionExcIfPositionIsOccupiedMoveForwardIfOrientationEast() {
        position.setOrientation(E);
        List<MarsRover> rovers = new ArrayList<>();
        RoverPosition occupied = new RoverPosition(4, 3, S);
        rovers.add(new MarsRover(plateau, occupied));
        plateau.setRovers(rovers);

        assertThrows(IncorrectPositionException.class, () -> roverService.move(FORWARD_DIRECTION));
    }


    @Test
    void moveForwardIfOrientationWest() {
        position.setOrientation(W);
        roverService.move(FORWARD_DIRECTION);
        int actualX = marsRover.getPosition().getX();
        int expectedX = 2;
        assertEquals(expectedX, actualX);
    }

    @Test
    void shouldThrowInvalidPositionExcIfPositionIsOccupiedMoveForwardIfOrientationWest() {
        position.setOrientation(W);
        List<MarsRover> rovers = new ArrayList<>();
        RoverPosition occupied = new RoverPosition(2, 3, S);
        rovers.add(new MarsRover(plateau, occupied));
        plateau.setRovers(rovers);

        assertThrows(IncorrectPositionException.class, () -> roverService.move(FORWARD_DIRECTION));
    }

    @Test
    void throwExceptionIfDirectionNotValid() {
        assertThrows(IncorrectDirectionException.class, () -> roverService.move(INCORRECT_DIRECTION));
    }

}
