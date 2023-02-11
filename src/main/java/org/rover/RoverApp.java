package org.rover;

import org.rover.exception.IncorrectPositionException;
import org.rover.model.MarsRover;
import org.rover.model.Orientation;
import org.rover.model.RectPlateau;
import org.rover.model.RoverPosition;
import org.rover.service.MarsRoverService;

import java.util.Scanner;

import static java.lang.System.in;

public class RoverApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(in);

        System.out.println("Enter coordinates of the  plateau (in the form x y):");
        String plateauCoordinates = scanner.nextLine();
        RectPlateau plateau = createPlateau(plateauCoordinates);

        System.out.println("Enter coordinates and facing of the  rover (in the form x y N):");
        String roverPositionData = scanner.nextLine();
        RoverPosition roverPosition = createRoverPosition(roverPositionData);
        MarsRover rover = new MarsRover(plateau, roverPosition);

        System.out.println("Enter Directions without spaces(in the form LMRLMR)");
        String directions = scanner.nextLine();

      MarsRoverService roverService = new MarsRoverService(rover);
        RoverPosition move = roverService.move(directions);
        System.out.println(move);


    }

    private static RectPlateau createPlateau(String plateauCoordinates) {
        if (plateauCoordinates.matches("\\d\\s\\d")) {
            int platoX = plateauCoordinates.charAt(0) - '0';
            int platoY = plateauCoordinates.charAt(2) - '0';
            return new RectPlateau(platoX, platoY);
        } else throw new IllegalArgumentException();
    }

    private static RoverPosition createRoverPosition(String plateauCoordinates) {
        if (plateauCoordinates.matches("\\d\\s\\d\\s['N|S|W|E']")) {
            int roverX = plateauCoordinates.charAt(0) - '0';
            int roverY = plateauCoordinates.charAt(2) - '0';
            Orientation orientation = Orientation.valueOf(plateauCoordinates.charAt(4) + "");
            return new RoverPosition(roverX, roverY, orientation);
        }
        throw new IncorrectPositionException("The string of Rover position is incorrect");
    }

}