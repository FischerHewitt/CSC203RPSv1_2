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


public class Rock implements IEntity{
    // Current rock position
    private Point position;
    /*
        Creates a new rock object
        Input: Point position
        Result: A new Rock object is created
        Returns: Rock
    */
    public Rock(Point position){
        this.position = position;
    }
    /*
    Intializes a rock entity into the world
     */
    public static void initializeEntity(World world){
        Point rockPoint = IEntity.findEmpty(world);  //finds an empty coordinate in the world array
        world.map[rockPoint.getPointX()][rockPoint.getPointY()] = new Rock(rockPoint); // puts the new rock in the world
        world.entityArrayList.add(world.map[rockPoint.getPointX()][rockPoint.getPointY()]); // adds the rock to the rocks array list
    }

    /*
        Returns the current position of the Rock
        Input: none
        Result: The current position of the rock is returned
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

    public void printInWorld(){
        System.out.print("|R");
    }



    /*
        Attacks a scissors object if it is in a neighboring cell
        Input: none
        Result: Adjacent scissors is removed from the world and scissorsCount decreases by 1 and returns if it attacked someone or not
        Returns: boolean
    */
    public boolean attack(IEntity[][] map) {
        ArrayList<Point> neighbors = checkNeighbors(this.getEntityPosition(), map);
        ArrayList<Point> validNeighbors = new ArrayList<>();
        boolean attackInstance = false;
        // Evaluates which neighbors are paper, and then adds them to valid neighbors
        for (Point neighbor: neighbors) {
            if (map[neighbor.getPointX()][neighbor.getPointY()] instanceof Scissors) {
                validNeighbors.add(neighbor);
            }
        }
        // for each neighbor that is paper, it will eliminate it from the world
        for (Point p : validNeighbors) {
            if(map[p.getPointX()][p.getPointY()] instanceof Scissors){
                // sets its position to (-1, -1)
                removeEntity(p.getPointX(), p.getPointY(), map);
                // Sets attack instance to true
                attackInstance = true;
            }
        }
        // returns true if there was an attack and false if there was not
        return attackInstance;
    }

}