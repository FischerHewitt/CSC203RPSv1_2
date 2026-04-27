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

public class Scissors {
    // Current scissor position
    // Random number generator

    // Scissor count
    public static int scissorsCount = 0;
    private Object[][] world;
    private Point position;

    /*
        Initializes a scissors object with a position and world
        Input: Point position, Object[][] world
        Result: A new Scissors object is created at the given position in the given world
        Returns: Scissors
    */
    public Scissors(Point position, Object[][] world){
        this.position = position;
        this.world = world;
        scissorsCount++;
    }

    /*
        Returns the current position of the scissors
        Input: none
        Result: The current position of the scissors is returned
        Returns: Point
    */
    public Point getEntityPosition() {
        return position;
    }

    /*
        Sets the scissors to a new position
        Input: Point position
        Result: The scissors position is updated to the new position
        Returns: void
    */
    public void setEntityPosition(Point position) {
        this.position = position;
    }

    /*
        Checks all neighboring cells around the scissors and returns a list of valid positions
        Input: none
        Result: A list of valid neighboring positions is returned
        Returns: ArrayList<Point>
    */
    public ArrayList<Point> checkNeighbors(){
        ArrayList<Point> neighbors = new ArrayList<>();

        // Check all positions around the rock
        for(int x = -1; x <= 1; x++){
            for(int y = -1; y <= 1; y++){
                int newX = position.getPointX() + x;
                int newY = position.getPointY() + y;

                // Add to list if within bounds
                if((newX < this.world.length) && (0 <= newX) && (newY < this.world[0].length) && (0 <= newY)){
                    neighbors.add(new Point(newX, newY));
                }
            }
        }
        return neighbors;
    }


    /*
        Moves the scissors to a random neighboring cell
        Input: none
        Result: The scissors moves to a random valid neighboring position
        Returns: void
    */
    public void moveScissors(){
        ArrayList<Point> neighbors = checkNeighbors();
        ArrayList<Point> validNeighbors = new ArrayList<>();
        // Checks to see which neighbors are empty/valid spaces to move
        for (Point neighbor: neighbors){
            if (world[neighbor.getPointX()][neighbor.getPointY()] == null){
                validNeighbors.add(neighbor);
            }
        }
        // if valid neighbors is not empty, then move to a new position
        if (validNeighbors.size() > 0) {
            // Pick a random position from the list,
            Random rand = new Random();
            Point newPosition = validNeighbors.get(rand.nextInt(validNeighbors.size()));
            // Remove from old position
            world[position.getPointX()][position.getPointY()] = null;
            // Place this rock in new position
            world[newPosition.getPointX()][newPosition.getPointY()] = this;
            setEntityPosition(newPosition);
        }
    }

    /*
        Attacks a paper object if it is in a neighboring cell
        Input: none
        Result: Adjacent paper is removed from the world and paperCount decreases by 1 returns if it attacked someone or not
        Returns: boolean
    */
    public boolean scissorsAttack() {
        ArrayList<Point> neighbors = checkNeighbors();
        ArrayList<Point> validNeighbors = new ArrayList<>();
        boolean attackInstance = false;
        // Evaluates which neighbors are paper, and then adds them to valid neighbors
        for (Point neighbor: neighbors) {
            if (world[neighbor.getPointX()][neighbor.getPointY()] instanceof Paper) {
                validNeighbors.add(neighbor);
            }
        }

        // for each neighbor that is paper, it will eliminate it from the world
        for (Point p : validNeighbors) {
            if(world[p.getPointX()][p.getPointY()] instanceof Paper){
                // sets its position to (-1, -1)
                ((Paper) world[p.getPointX()][p.getPointY()]).setEntityPosition(new Point(-1, -1));
                // Sets the point to null
                world[p.getPointX()][p.getPointY()] = null;
                // reduces the paper count by 1
                Paper.paperCount--;
                // Sets attack instance to true
                attackInstance = true;
            }
        }
        // returns true if there was an attack and false if there was not
        return attackInstance;
    }
}