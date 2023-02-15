package org.rover.service;

import org.rover.exception.IncorrectPositionException;
import org.rover.model.*;

import java.util.List;

public class PlateauService {

    RectPlateau plateau;

    public PlateauService(RectPlateau plateau) {
        this.plateau = plateau;
    }

     public boolean addRover(MarsRover rover) {
        if(isOccupied(rover.getPosition())){
            throw new IncorrectPositionException("position is already occupied");
        }
        return plateau.getRovers().add(rover);
    }

     boolean isOccupied(RoverPosition position) {
        List<MarsRover> rovers =plateau.getRovers();
        for (MarsRover rover : rovers) {
            if (rover.getPosition().getY()== position.getY() && rover.getPosition().getX() == position.getX()) {
                return true;
            }
        }
        return false;
    }
}
