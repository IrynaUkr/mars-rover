### The RectPlateau class impl Plateau

The Plateau describes the grid, it has maximum coordinates (x,y).
Coordinates are stored in fields posX, posY.
The lower-left coordinate of the Plateau is (0,0)
Rover can't move beyond of the border

### The Mars Rover class impl Rover
Mars Rover depends on:
* Plateau(rover needs borders' data)
* RoverPosition(class helps easy store data coordinates and direction where the rover is facing)
When rover moves, it takes direction string and spins if there are L or R and go forward in facing direction

To make a move Rover has  turnLeft, turnRight and goForward methods.
* The turnLeft method spins the Rover 90 degrees Left without moving from the current coordinate point
* The turnRight method Spins the Rover 90 degrees Right without moving from the current coordinate point
* The goForward method Moves the Rover forward by one grid point, maintaining the same orientation

_The methods that serve the rover are in the MarsServiceClass class, which corresponds to the Single Responsibility Principle._
