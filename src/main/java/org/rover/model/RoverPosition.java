package org.rover.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Objects;

@AllArgsConstructor
@Data
public class RoverPosition {
    private int x;
    private int y;
    private Orientation orientation;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoverPosition that = (RoverPosition) o;
        return x == that.x && y == that.y && orientation == that.orientation;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, orientation);
    }

}
