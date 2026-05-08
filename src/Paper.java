/*
    Developers: Fischer Hewitt, Sameeka Molugu, Mason Brown
    Date: 04/20/2026
    Project 2: RPSv1
    Description: Build a rock paper scissors game that has a world full of rock, paper, and scissors, then they move
    around randomly moving one step at a time (and they are allowed to move in any direction including up, down, left, right
    and the respective diagonals) and the last object standing is the winner.
    world view print view with coordinate labels
   0 1 2 3 (x)      ^ 0 1 2
  +-+-+-+-+           ^ ^ ^
0 | | | | |        0
  +-+-+-+-+           - - -
1 | | | | |        1
  +-+-+-+-+           - - -
2 | | | | |        2
  +-+-+-+-+           v v v
(y)                          v
 */


import java.util.ArrayList;
import java.util.Random;
//
public class Paper implements IEntity{
    // Current rock position
    // Random number generator

    // Rock count
    public static int paperCount = 0;
    private Point position;

    /*
        Initializes a rock object with a position and world
        Input: Point position, Object[][] world
        Result: A new Rock object is created at the given position in the given world
        Returns: Rock
    */
    public Paper(Point position){
        this.position = position;
        paperCount++;
    }

    public static void initializeEntity(World world){
        Point paperPoint = IEntity.findEmpty(world);  //finds an empty coordinate in the world array
        world.map[paperPoint.getPointX()][paperPoint.getPointY()] = new Paper(paperPoint); // puts the new rock in the world
        world.entityArrayList.add(world.map[paperPoint.getPointX()][paperPoint.getPointY()]); // adds the rock to the rocks array list
    }

    /*
        Returns the current position of the paper
        Input: none
        Result: The current position of the paper is returned
        Returns: Point
    */
    public Point getEntityPosition() {
        return position;
    }

    /*
        Sets the paper to a new position
        Input: Point position
        Result: The paper's position is updated to the new position
        Returns: void
    */
    public void setEntityPosition(Point position) {
        this.position = position;
    }

    /*
        Attacks a rock object if it is in a neighboring cell
        Input: none
        Result: Adjacent rock is removed from the world and rockCount decreases by 1 returns if it attacked someone or not
        Returns: boolean
    */
    public boolean attack(IEntity[][] map) {
        ArrayList<Point> neighbors = checkNeighbors(this.getEntityPosition(), map);
        ArrayList<Point> validNeighbors = new ArrayList<>();
        boolean attackInstance = false;
        // Evaluates which neighbors are paper, and then adds them to valid neighbors
        for (Point neighbor: neighbors) {
            if (map[neighbor.getPointX()][neighbor.getPointY()] instanceof Rock) {
                validNeighbors.add(neighbor);
            }
        }
        // for each neighbor that is paper, it will eliminate it from the world
        for (Point p : validNeighbors) {
            if(map[p.getPointX()][p.getPointY()] instanceof Rock){
                // sets its position to (-1, -1)
                removeEntity(p.getPointX(), p.getPointY(), map);
                // reduces the paper count by 1
                Rock.rockCount--;
                // Sets attack instance to true
                attackInstance = true;
            }
        }
        // returns true if there was an attack and false if there was not
        return attackInstance;
    }
}
