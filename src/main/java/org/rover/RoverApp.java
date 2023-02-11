package org.rover;

import org.rover.model.MarsRover;
import org.rover.model.RectPlateau;
import org.rover.model.RoverPosition;
import org.rover.service.MarsRoverService;

import java.util.Scanner;

import static java.lang.System.in;
import static org.rover.service.RoverAppService.createPlateau;
import static org.rover.service.RoverAppService.createRoverPosition;

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

}
