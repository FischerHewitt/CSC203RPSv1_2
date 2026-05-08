
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
    //ArrayList<Paper> paper = new ArrayList<>();
    //ArrayList<Scissors> scissors = new ArrayList<>();




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
    purpose: gets a random value between 0 and the height
    input: null
    result: a random integer between 0 and the height
    output: int of a random value
     */
    public int getRandomHeight(){
        return (int)(random() * this.height);
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

    /*
    purpose: to start a round, have each entity attack each other, and then move around the board
    input: null
    result: one class is left standing and the games ends
    output: null
     */
    /*
    public void playRound(){
        boolean running = true;
        String winner = "";
        printWorld(); // prints the initial world with all the entities

        // runs the game
        while (running) {
            boolean attackInstance = false; // This turns true if there was an attack during the iteration
            // object attack
            // rock attack
            for (int rockIdx = 0; rockIdx < this.rocks.size(); rockIdx++){
                if (this.rocks.get(rockIdx).getEntityPosition().getPointX() != -1) {
                    attackInstance = this.rocks.get(rockIdx).rockAttack() || attackInstance;
                }
            }
            // paper attack
            for (int paperIdx = 0; paperIdx < this.paper.size(); paperIdx++){
                if (this.paper.get(paperIdx).getEntityPosition().getPointX() != -1) {
                    attackInstance = this.paper.get(paperIdx).paperAttack() || attackInstance;
                }
            }
            // scissors attack
            for (int scissorsIdx = 0; scissorsIdx < this.scissors.size(); scissorsIdx++){
                if (this.scissors.get(scissorsIdx).getEntityPosition().getPointX() != -1) {
                    attackInstance = this.scissors.get(scissorsIdx).scissorsAttack() || attackInstance;
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

            /*
            if (Rock.rockCount == 0 && Paper.paperCount == 0 && Scissors.scissorsCount == 0){
                running = false;
                winner = "No Winner";
                break;
            }
            // Checks to see if Scissors Has Won
            else if (Rock.rockCount == 0 && Paper.paperCount == 0) {
                running = false;
                winner = "Scissors";
                break;
            }
            // checks to see if rock has won
            else if ((Paper.paperCount == 0 && Scissors.scissorsCount == 0)){
                running = false;
                winner = "Rock";
                break;
            }
            // checks to see if Paper has won
            else if (Scissors.scissorsCount == 0 && Rock.rockCount == 0){
                running = false;
                winner = "Paper";
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

        printWorld(); // prints the final world
        System.out.printf("Winner: %s", winner); // prints the winner of the game

    }

     */





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
                if (map[idxWidth][idxHeight] instanceof Rock) { // checks if it is a rock
                    System.out.print("|R");
                } else if (map[idxWidth][idxHeight] instanceof Paper) { // checks if it is a paper
                    System.out.print("|P");
                } else if (map[idxWidth][idxHeight] instanceof Scissors) { // checks if is it a scissors
                    System.out.print("|S");
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
