package org.rover.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
public class RectPlateau implements Plateau{
    private final int posX;
    private final int posY;
    private List<MarsRover> rovers;


}
