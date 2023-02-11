package org.rover.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.rover.model.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.rover.model.Orientation.*;

class MarsRoverServiceTest {
    RoverPosition position;
    Plateau plateau;
    MarsRover marsRover;
    MarsRoverService roverService;

    @BeforeEach
    void setUp() {
        position = new RoverPosition(0, 0, NORTH);
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
        int expectedY = 1;
        assertEquals(expectedY, actualY);
    }
    @Test
    void moveForwardIfOrientationSouth() {
        position.setOrientation(SOUTH);
        roverService.move("M");
        int actualY = marsRover.getPosition().getY();
        int expectedY = 1;
        assertEquals(expectedY, actualY);
    }
    @Test
    void moveForwardIfOrientationEast() {
        position.setOrientation(EAST);
        roverService.move("M");
        int actualX = marsRover.getPosition().getX();
        int expectedX = 1;
        assertEquals(expectedX, actualX);
    }
    @Test
    void moveForwardIfOrientationWest() {
        position.setOrientation(WEST);
        roverService.move("M");
        int actualX = marsRover.getPosition().getX();
        int expectedX = -1;
        assertEquals(expectedX, actualX);
    }

}
