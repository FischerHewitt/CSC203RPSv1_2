import java.util.ArrayList;
import java.util.Random;

import static java.lang.Math.random;

public interface IEntity {
    public static void initializeEntities(World world, int numOfEntities){
        for (int idx = 0; idx < numOfEntities; idx++) {
            Rock.initializeEntity(world);// adds a rock to the world
            Paper.initializeEntity(world);// adds a paper to the world
            Scissors.initializeEntity(world);// adds scissors to the world

        }
    }

    /*
    purpose: finds an empty spot in the array initializing all the objects to make sure they have a place
    (we check to make sure all objects will fit in dimensions in gameplay)
    input: int x, int y
    result: Point(x,y). Returns a point that is a valid empty spot.
     */
    public static Point findEmpty(World world){
        int x = (int)(random() * world.width);
        int y = (int)(random() * world.height);
        while (world.map[x][y] != null){ //if the current spot is not empty go check all the x's for each height.
            int counter = 0;
            while ((world.map[x][y] != null) && (counter < world.width)){
                x = (x + 1) % world.width; // makes sure it stays within the boundaries
                counter++; // lets us check the height and not iterate for infinity
            }
            if (world.map[x][y] == null){ // check to see if it is null space or if we need to increase the height by 1
                break;
            }
            y = (y + 1) % world.height; // makes sure it stays within the height boundaries
        }

        return new Point(x, y);
    }

    /*
        Checks all neighboring cells around the paper and returns a list of valid positions
        Input: none
        Result: A list of valid neighboring positions is returned
        Returns: ArrayList<Point>
    */

    /* Check (=C) all positions around the paper
           +-+-+-+-+     +-+-+-+-+
           | | | | |     |C|C|C| |
           +-+-+-+-+     +-+-+-+-+
           | |P| | |     |C|C|C| |
           +-+-+-+-+     +-+-+-+-+
           | | | | |     |C|C|C| |
           +-+-+-+-+     +-+-+-+-+
                */
    default ArrayList<Point> checkNeighbors(Point position, IEntity[][] world){
        ArrayList<Point> neighbors = new ArrayList<>();

        // Check all positions around the rock
        for(int x = -1; x <= 1; x++){
            for(int y = -1; y <= 1; y++){
                int newX = position.getPointX() + x;
                int newY = position.getPointY() + y;

                // Add to list if within bounds
                if((newX < world.length) && (0 <= newX) && (newY < world[0].length) && (0 <= newY)){
                    neighbors.add(new Point(newX, newY));
                }
            }
        }
        return neighbors;
    }


    /*
        Purpose: gets all the neighbor cells that are null/valid spots to move
        Input: Point, Object[][]
        Result: returns a list of neighbors that have no entity in them
        Returns: ArrayList<Point>
     */
    default ArrayList<Point> getValidNeighbors(Point position, IEntity[][] world){
        ArrayList<Point> neighbors = checkNeighbors(position, world);
        ArrayList<Point> validNeighbors = new ArrayList<>();
        // Looks for all positions around the paper that are null and adds them to valid neighbors
        for (Point neighbor: neighbors){
            if (world[neighbor.getPointX()][neighbor.getPointY()] == null){
                validNeighbors.add(neighbor);
            }
        }
        return validNeighbors;
    }

    default void removeEntity(int x, int y, IEntity[][] map){
        if (map[x][y] != null) {
            map[x][y].setEntityPosition(new Point(-1, -1));
        }
        map[x][y] = null;
    }

    default void addEntity(int x, int y, IEntity entity, IEntity[][] map){
        if (map[x][y] == null){
            map[x][y] = entity;
            entity.setEntityPosition(new Point(x, y));
        }
    }

    /*
    purpose: this initializes a Rock Object and add it to our world array.
    Input: null
    output: null
    Result: After finding an empty spot using the findEmpty,
    it creates a new rock object with the coordinates it is at in the list
     */

    default void move(IEntity entity, IEntity[][] map){
        ArrayList<Point> validNeighbors = getValidNeighbors(entity.getEntityPosition(), map);
        if (!validNeighbors.isEmpty()) {
            Random rand = new Random();
            Point newPosition = validNeighbors.get(rand.nextInt(validNeighbors.size()));
            // Remove from old position
            removeEntity(entity.getEntityPosition().getPointX(), getEntityPosition().getPointY(), map);
            // Place this rock in new position
            addEntity(newPosition.getPointX(), newPosition.getPointY(), entity, map);
        }
    }

    /*
        Returns the current position of the rock
        Input: none
        Result: The current position of the rock is returned
        Returns: Point
    */
    Point getEntityPosition();

    /*
        Sets the rock to a new position
        Input: Point position
        Result: The rock's position is updated to the new position
        Returns: void
    */
    void setEntityPosition(Point position);

    boolean attack(IEntity[][] map);

}
