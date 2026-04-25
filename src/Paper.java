/*
    Developers: Fischer Hewitt, Sameeka Molugu, Mason Brown
    Date: 04/20/2026
    Project 2: RPSv1
    Description: Build a rock paper scissors game that has a world full of rock, paper, and scissors, then they move
    around randomly and the last object standing is the winner.
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

public class Paper {
    // Current paper position
    // Random number generator

    // Paper count
    public static int paperCount = 0;
    private Object[][] world;
    private Point position;

    /*
        Initializes a paper object with a position and world
        Input: Point position, Object[][] world
        Result: A new Paper object is created at the given position in the given world
        Returns: Paper
    */
    public Paper(Point position, Object[][] world){
        this.position = position;
        this.world = world;
        paperCount++;
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
        Checks all neighboring cells around the paper and returns a list of valid positions
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
        Moves the paper to a random neighboring cell
        Input: none
        Result: The paper moves to a random valid neighboring position
        Returns: void
     */
    public void movePaper(){
        ArrayList<Point> neighbors = checkNeighbors();
        ArrayList<Point> validNeighbors = new ArrayList<>();
        for (Point neighbor: neighbors){
            if (world[neighbor.getPointX()][neighbor.getPointY()] == null){
                validNeighbors.add(neighbor);
            }
        }
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
        Attacks a rock object if it is in a neighboring cell
        Input: none
        Result: Adjacent rock is removed from the world and rockCount decreases by 1
        Returns: void
    */
    public void paperAttack() {
        ArrayList<Point> neighbors = checkNeighbors();
        ArrayList<Point> validNeighbors = new ArrayList<>();
        for (Point neighbor: neighbors) {
            if (world[neighbor.getPointX()][neighbor.getPointY()] instanceof Rock) {
                validNeighbors.add(neighbor);
            }
        }

        for (Point p : validNeighbors) {
            if(world[p.getPointX()][p.getPointY()] instanceof Rock){
                world[p.getPointX()][p.getPointY()] = null;
                Rock.rockCount--;
            }
        }
    }
}