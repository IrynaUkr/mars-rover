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
        if(!isOnThePlateau(rover)){
            throw new IncorrectPositionException("position is not in the plateau");
        }
        if (isOccupied(rover.getPosition())) {
            throw new IncorrectPositionException("position is already occupied");
        }
        return plateau.getRovers().add(rover);
    }

    boolean isOnThePlateau(MarsRover rover) {
        int posPlatoX = rover.getPlateau().getPosX();
        int posRoverX = rover.getPosition().getX();
        int posPlatoY = rover.getPlateau().getPosY();
        int posRoverY = rover.getPosition().getY();
        return (posPlatoX > posRoverX && posPlatoY > posRoverY);
    }

    boolean isOccupied(RoverPosition position) {
        List<MarsRover> rovers = plateau.getRovers();
        for (MarsRover rover : rovers) {
            if (rover.getPosition().getY() == position.getY() && rover.getPosition().getX() == position.getX()) {
                return true;
            }
        }
        return false;
    }

}
