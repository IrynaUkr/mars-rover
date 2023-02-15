package org.rover.service;

import org.rover.exception.IncorrectPositionException;
import org.rover.model.Orientation;
import org.rover.model.RectPlateau;
import org.rover.model.RoverPosition;

import java.util.ArrayList;

public class RoverAppService {
    public static RectPlateau createPlateau(String plateauCoordinates) {
        if (plateauCoordinates.matches("\\d\\s\\d")) {
            int platoX = plateauCoordinates.charAt(0) - '0';
            int platoY = plateauCoordinates.charAt(2) - '0';
            return new RectPlateau(platoX, platoY, new ArrayList<>());
        } else throw new IllegalArgumentException();
    }

    public static RoverPosition createRoverPosition(String plateauCoordinates) {
        if (plateauCoordinates.matches("\\d\\s\\d\\s['N|S|W|E']")) {
            int roverX = plateauCoordinates.charAt(0) - '0';
            int roverY = plateauCoordinates.charAt(2) - '0';
            Orientation orientation = Orientation.valueOf(plateauCoordinates.charAt(4) + "");
            return new RoverPosition(roverX, roverY, orientation);
        }
        throw new IncorrectPositionException("The string of Rover position is incorrect");
    }

}
