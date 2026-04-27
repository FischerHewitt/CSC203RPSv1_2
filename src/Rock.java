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


public class Rock {
    // Current rock position
    // Random number generator

    // Rock count
    public static int rockCount = 0;
    private Object[][] world;
    private Point position;

    /*
        Initializes a rock object with a position and world
        Input: Point position, Object[][] world
        Result: A new Rock object is created at the given position in the given world
        Returns: Rock
    */
    public Rock(Point position, Object[][] world){
        this.position = position;
        this.world = world;
        rockCount++;
    }

    /*
        Returns the current position of the rock
        Input: none
        Result: The current position of the rock is returned
        Returns: Point
    */
    public Point getEntityPosition() {
        return position;
    }

    /*
        Sets the rock to a new position
        Input: Point position
        Result: The rock's position is updated to the new position
        Returns: void
    */
    public void setEntityPosition(Point position) {
        this.position = position;
    }

    /*
        Checks all neighboring cells around the rock and returns a list of valid positions
        Input: none
        Result: A list of valid neighboring positions is returned
        Returns: ArrayList<Point>
    */
    public ArrayList<Point> checkNeighbors(){
        ArrayList<Point> neighbors = new ArrayList<>();

        // Check all positions around the rock
        for (int x = -1; x <= 1; x++) {
            for (int y = -1; y <= 1; y++) {
                int newX = position.getPointX() + x;
                int newY = position.getPointY() + y;

                // Add to list if within bounds
                if ((newX < this.world.length) && (0 <= newX) && (newY < this.world[0].length) && (0 <= newY)) {
                    neighbors.add(new Point(newX, newY));
                }
            }
        }
        return neighbors;
    }


    /*
        Moves the rock to a random neighboring cell
        Input: none
        Result: The rock moves to a random valid neighboring position
        Returns: void
    */
    public void moveRock(){
        ArrayList<Point> neighbors = checkNeighbors();
        ArrayList<Point> validNeighbors = new ArrayList<>();
        // Looks for all positions around the rock that are null and adds them to valid neighbors
        for (Point neighbor: neighbors){
            if (world[neighbor.getPointX()][neighbor.getPointY()] == null){
                validNeighbors.add(neighbor);
            }
        }

        // if the list is not empty, then it will move to a new position
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
        Attacks a scissors object if it is in a neighboring cell
        Input: none
        Result: Adjacent scissors is removed from the world and scissorsCount decreases by 1 and returns if it attacked someone or not
        Returns: boolean
    */
    public boolean rockAttack() {
        ArrayList<Point> neighbors = checkNeighbors();
        ArrayList<Point> validNeighbors = new ArrayList<>();
        boolean attackInstance = false;
        // checks for neighbors that are Scissors
        for (Point neighbor: neighbors) {
            if (world[neighbor.getPointX()][neighbor.getPointY()] instanceof Scissors) {
                validNeighbors.add(neighbor);
            }
        }

        // For each scissors neighbors, it will remove it from the world
        for (Point p : validNeighbors) {
            if(world[p.getPointX()][p.getPointY()] instanceof Scissors){
                // Sets scissor position to (-1, -1)
                ((Scissors) world[p.getPointX()][p.getPointY()]).setEntityPosition(new Point(-1, -1));
                // Sets the rock in the world to null
                world[p.getPointX()][p.getPointY()] = null;
                // Subtracts 1 from the rock total
                Scissors.scissorsCount--;
                // Sets the attack instance to True
                attackInstance = true;
            }
        }
        // Returns if it attacked someone or not
        return attackInstance;
    }



}