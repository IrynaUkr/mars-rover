package org.rover.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.rover.exception.IncorrectDirectionException;
import org.rover.model.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.rover.model.Orientation.*;

class MarsRoverServiceTest {
    RoverPosition position;
    RectPlateau plateau;
    MarsRover marsRover;
    MarsRoverService roverService;

    @BeforeEach
    void setUp() {
        position = new RoverPosition(3, 3, NORTH);
        plateau = new RectPlateau(5, 5);
        marsRover = new MarsRover(plateau, position);
        roverService = new MarsRoverService(marsRover);
    }

    @Test
    void moveTurnLefChangePositionTest() {
        roverService.move("L");
        Orientation actual = marsRover.getPosition().getOrientation();
        assertEquals(WEST, actual);
    }

    @Test
    void moveTurnRightChangePositionTest() {
        roverService.move("R");
        Orientation actual = marsRover.getPosition().getOrientation();
        assertEquals(EAST, actual);
    }

    @Test
    void moveForwardIfOrientationNorth() {
        position.setOrientation(NORTH);
        roverService.move("M");
        int actualY = marsRover.getPosition().getY();
        int expectedY = 4;
        assertEquals(expectedY, actualY);
    }
    @Test
    void moveForwardIfOrientationSouth() {
        position.setOrientation(SOUTH);
        roverService.move("M");
        int actualY = marsRover.getPosition().getY();
        int expectedY = 2;
        assertEquals(expectedY, actualY);
    }
    @Test
    void moveForwardIfOrientationEast() {
        position.setOrientation(EAST);
        roverService.move("M");
        int actualX = marsRover.getPosition().getX();
        int expectedX = 4;
        assertEquals(expectedX, actualX);
    }
    @Test
    void moveForwardIfOrientationWest() {
        position.setOrientation(WEST);
        roverService.move("M");
        int actualX = marsRover.getPosition().getX();
        int expectedX = 2;
        assertEquals(expectedX, actualX);
    }

    @Test
    void throwExceptionIfDirectionNotValid(){
        assertThrows(IncorrectDirectionException.class, ()->roverService.move("U"));
    }

}
