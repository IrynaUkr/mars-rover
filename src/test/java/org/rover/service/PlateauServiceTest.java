package org.rover.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.rover.exception.IncorrectPositionException;
import org.rover.model.MarsRover;
import org.rover.model.Orientation;
import org.rover.model.RectPlateau;
import org.rover.model.RoverPosition;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.rover.model.Orientation.S;

class PlateauServiceTest {
    PlateauService plateauService;
    RectPlateau plateau;
    RoverPosition positionZero;
    MarsRover roverZero;
    MarsRover roverOne;
    RoverPosition positionOne;

    @BeforeEach
    void setUp() {

        plateau = new RectPlateau(5, 5, new ArrayList<>());
        plateauService = new PlateauService(plateau);
        positionZero = new RoverPosition(0, 0, Orientation.N);
        positionOne = new RoverPosition(1, 1, Orientation.N);
        roverZero = new MarsRover(plateau, positionZero);
        roverOne = new MarsRover(plateau, positionOne);
    }


    @Test
    void shouldAddRoversWithDifferentCoordinatesOnThePlateau() {
        assertTrue(plateauService.addRover(roverZero));
        assertTrue(plateauService.addRover(roverOne));
        assertEquals(2, plateau.getRovers().size());
    }

    @Test
    void shouldThrowIncorrectPositionExceptionIfPositionOccupied() {
        plateauService.addRover(roverOne);
        assertThrows(IncorrectPositionException.class, () -> plateauService.addRover(roverOne));
    }

    @Test
    void shouldThrowIncorrectPositionExceptionIfPositionNotInThePlateau() {
        MarsRover rover = new MarsRover(plateau, new RoverPosition(10, 10, S));
        assertThrows(IncorrectPositionException.class, () -> plateauService.addRover(rover));
    }

}
