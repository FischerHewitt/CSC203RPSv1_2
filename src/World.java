
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

import static java.lang.Math.random;

class World{
    public int width;
    public int height;
    public int numOfEntities;
    IEntity[][] map;
    ArrayList<IEntity> entityArrayList = new ArrayList<>();


    /*
    purpose: Creates the world as an Array<Array<String>> where its an Array[width[height]].
    each empty slot is represented as null (Java default)
    our coordinate system will be x in the horizontal direction (also the width), starting at 0
    and our y will be in the vertical direction(also known as the height) starting at 0.
    {{(0,0), (0,1), (0,2)}, {(1,0), (1,1), (2,1)}}
     */
    World(int width, int height, int numOfEntities){//width is the size of the outer list, height is the size of the inner list

        this.width = width;
        this.height = height;
        this.numOfEntities = numOfEntities;
        this.map = new IEntity[width][height];

        // sets the list = to null
        for (int idxW = 0; idxW < this.width; idxW++){
            for (int idxH = 0; idxH < this.height; idxH++){
                this.map[idxW][idxH] = null;

            }
        }

        IEntity.initializeEntities(this, numOfEntities);

    }


    /*
    purpose: removes rocks, papers, and scissors from item list that are not in the world
    input: null
    result: entities are removed from lists if they are not needed anymore
    output: null
     */
    public void cleanEntitys(){
        int entityListIdx = 0;
        // removes rocks in the list
        // while idx is less than rocks.size
        while (entityListIdx < this.entityArrayList.size()){
            // if rocks x position is -1
            if (this.entityArrayList.get(entityListIdx).getEntityPosition().getPointX() == -1
            && this.entityArrayList.get(entityListIdx).getEntityPosition().getPointY() == -1){
                // remove rock
                this.entityArrayList.remove(entityListIdx);
            } else {
                // keep moving through the list
                entityListIdx++;
            }
        }
    }

    private boolean endGame(ArrayList<IEntity> entitiesList){
        String winner;
        ArrayList<String> differentEntities= new ArrayList<>();
        for (int idx = 0; idx < entitiesList.size(); idx++){
            String curEntityName = entitiesList.get(idx).getClass().getSimpleName();
            if (!differentEntities.contains(curEntityName)){
                differentEntities.add(curEntityName);
            }

        }

        if (differentEntities.size() == 1){
            winner = differentEntities.getFirst();
            printWorld(); // prints the final world
            System.out.printf("Winner: %s", winner); // prints the winner of the game
            return true;
        } else if (differentEntities.isEmpty()){
            winner = "No Winner";
            System.out.printf("Winner: %s", winner); // prints the winner of the game
            return true;
        } else {
        return false;}
    }

    /*
    purpose: to start a round, have each entity attack each other, and then move around the board
    input: null
    result: one class is left standing and the games ends
    output: null
     */

    public void playRound(){
        boolean running = true;
        printWorld(); // prints the initial world with all the entities

        // runs the game
        while (running) {
            boolean attackInstance = false; // This turns true if there was an attack during the iteration
            // object attack
            // rock attack
            for (int entityIdx = 0; entityIdx < this.entityArrayList.size(); entityIdx++){
                if (this.entityArrayList.get(entityIdx).getEntityPosition().getPointX() != -1) {
                    attackInstance = this.entityArrayList.get(entityIdx).attack(this.map) || attackInstance;
                }
            }
            // if an object attacks, you can see the board updated before the pieces move
            if (attackInstance) {
                printWorld();
                try {
                    Thread.sleep(500); // Pauses for 0.5
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt(); // restore interupted status
                }
                // removes entitys that are not in the world from the entity lists
                cleanEntitys();
            }

            if (endGame(this.entityArrayList)){
                running = false;
                break;
            }


            // Moves each object
            for (int entityListIdx = 0; entityListIdx < this.entityArrayList.size(); entityListIdx++){
                if (this.entityArrayList.get(entityListIdx).getEntityPosition().getPointX() != -1) {
                    IEntity entity = this.entityArrayList.get(entityListIdx);
                    entity.move(entity, this.map);
                }
            }
            printWorld();
            try {
                Thread.sleep(500);// Pauses for 0.5
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();// restore interrupted status
            }

        }

    }



    /*
    Purpose: prints the world with the Rock, Paper, and Scissors objects in it
    input: null
    result: prints the world
    ex:
    +-+-+
    |R|P|
    +-+-+
    |P|S|
    +-+-+
    |S|R|
    +-+-+
    output: null
     */
    public void printWorld(){
        System.out.println("World:");
        // prints the top +-+-+-+
        for (int idxLine = 0; idxLine < this.width; idxLine++){
            System.out.print("+-") ; //prints the top +-+-+-
        }
        System.out.print("+\n"); // adds the last + to the top line


        // prints the rest of the world
        for (int idxHeight = 0; idxHeight < this.height; idxHeight++){
            for (int idxWidth = 0; idxWidth < this.width; idxWidth++) { // has to print at each width first before the height
                if (map[idxWidth][idxHeight] != null) { // checks if it is a rock
                    map[idxWidth][idxHeight].printInWorld();
                } else {
                    System.out.print("| ");
                }
            }

            System.out.print("|\n"); // prints the last | on the line

            // prints the bottom line
            for (int idxLine = 0; idxLine < this.width; idxLine++){
                System.out.print("+-") ; //prints the bottom +-+-+-
            }
            System.out.print("+\n"); // adds the last + to the bottom line
        }
    }

}
