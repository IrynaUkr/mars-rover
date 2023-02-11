### The RectPlateau class impl Plateau

The Plateau describes the grid, it has maximum coordinates (x,y).
Coordinates are stored in fields posX, posY.
The lower-left coordinate of the Plateau is (0,0)

When the rover moves we need to check the border of the Plateau.
????
Possibly there are several rovers in the Plateau... 
in that case we need to check if the Plateau position is available

### The Mars Rover class impl Rover
Mars Rover depends on:
* Plateau(it needs the info of borders)
* RoverPosition(class helps easy store data coordinates and direction where the rover is facing)
When rover moves, it takes direction string and spins if there are L or R and go forward in facing direction

To make a move Rover should have methods, turnLeft, TurnRight and  goForward.
The methods that serve the rover are in the MarsServiceClass class, which corresponds to the Single Responsibility Principle.
