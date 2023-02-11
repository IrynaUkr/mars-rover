package org.rover.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@AllArgsConstructor
@Data
public class RoverPosition {
    private int x;
    private int y;
     Orientation orientation;
}
