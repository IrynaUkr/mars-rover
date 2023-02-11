package org.rover.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.rover.model.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MarsRoverServiceTest {
    RoverPosition position;
    Plateau plateau;
    MarsRover marsRover;
    MarsRoverService roverService;

    @BeforeEach
    void setUp() {
        position = new RoverPosition(0, 0, Orientation.NORTH);
        plateau = new RectPlateau(5, 5);
        marsRover = new MarsRover(plateau, position);
        roverService = new MarsRoverService(marsRover);
    }

    @Test
    void moveTurnLefChangePositionTest() {
        roverService.move("L");
        Orientation actual = marsRover.getPosition().getOrientation();
        Orientation expected = Orientation.WEST;
        assertEquals(expected, actual);
    }

    @Test
    void moveTurnRightChangePositionTest() {
        roverService.move("R");
        Orientation actual = marsRover.getPosition().getOrientation();
        Orientation expected = Orientation.EAST;
        assertEquals(expected, actual);
    }

}
