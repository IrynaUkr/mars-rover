package org.rover.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MarsRoverTest {
    RoverPosition position;
    Plateau plateau;
    MarsRover marsRover;

    @BeforeEach
    void setUp() {
        position = new RoverPosition(0, 0, 0);
        plateau = new RectPlateau(5, 5);
        marsRover = new MarsRover(plateau, position);
    }

    @Test
    void moveChangePositionInDegreesTest() {
        marsRover.move("R");
        int actOrientation = marsRover.position.getOrientation();
        int excOr = 90;
        assertEquals(excOr, actOrientation);
    }

}