package org.rover.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class MarsRover implements Rover {
    Plateau plateau;

    RoverPosition position;

}


