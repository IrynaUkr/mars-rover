package org.rover.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.rover.model.MarsRover;
import org.rover.model.Plateau;
import org.rover.model.RectPlateau;
import org.rover.model.RoverPosition;

import static org.junit.jupiter.api.Assertions.*;

class MarsRoverServiceTest {
    RoverPosition position;
    Plateau plateau;
    MarsRover marsRover;

    MarsRoverService roverService;

    @BeforeEach
    void setUp() {
        position = new RoverPosition(0, 0, 0);
        plateau = new RectPlateau(5, 5);
        marsRover = new MarsRover(plateau, position);
        roverService = new MarsRoverService(marsRover);
    }

    @Test
    void moveChangePositionInDegreesTest() {
        roverService.move("L");
        int actualOrientation = marsRover.getPosition().getOrientation();
        int excOr = -90;
        assertEquals(excOr, actualOrientation);
    }

}
