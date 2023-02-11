package org.rover.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.rover.exception.IncorrectDirectionException;
import org.rover.model.*;

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
        plateau = new RectPlateau(5, 5);
        marsRover = new MarsRover(plateau, position);
        roverService = new MarsRoverService(marsRover);
    }

    @Test
    void moveTurnLefChangePositionTest() {
        Orientation actual  = roverService.move(LEFT_DIRECTION).getOrientation();
        assertEquals(W, actual);
    }

    @Test
    void moveTurnRightChangePositionTest() {
        Orientation actual= roverService.move(RIGHT_DIRECTION).getOrientation();
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
    void moveForwardIfOrientationSouth() {
        position.setOrientation(S);
        roverService.move(FORWARD_DIRECTION);
        int actualY = marsRover.getPosition().getY();
        int expectedY = 2;
        assertEquals(expectedY, actualY);
    }
    @Test
    void moveForwardIfOrientationEast() {
        position.setOrientation(E);

        int actualX = roverService.move(FORWARD_DIRECTION).getX();
        int expectedX = 4;
        assertEquals(expectedX, actualX);
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
    void throwExceptionIfDirectionNotValid(){
        assertThrows(IncorrectDirectionException.class, ()->roverService.move(INCORRECT_DIRECTION));
    }

}
