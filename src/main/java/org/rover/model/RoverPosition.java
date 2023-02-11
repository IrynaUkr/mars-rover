package org.rover.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class RoverPosition {
    private int x;
    private int y;
    private Orientation orientation;

}
