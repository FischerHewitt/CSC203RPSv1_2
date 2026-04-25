//Steps
// 1. Ask for user input for dimensions (ex. width: 3, height: 3)
// 2. Ask for user input for entities ("How many of each rock paper scissors do you want
//in the world (ie, three rocks, three papers, three scissors. input: 3)
// 3. check if the amount of rocks, papers, and scissors provided will fit in the world space
// 4. run world function and print result
import com.sun.jdi.IntegerType;


import java.util.Scanner;
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






public class Gameplay {
    public static int wInt = 0;
    public static int lInt = 0;
    public static World GameWorld = new World(lInt, wInt);
    /* Takes in the user input */


    static void runGame(Integer objects) {
        GameWorld.addEntity();
        GameWorld.initializeObjects(objects);
        GameWorld.playRound();
    }




    public static void main() {
        try {
            Scanner input = new Scanner(System.in);                                    /* This section of code prompts the users to input a length- */
            System.out.println("Welcome to the Rock, paper, scissors game \n");            /* and width for the game matrix*/
            System.out.println("What is the width of your matrix?: ");
            String w = input.nextLine();
            System.out.println("What is the length of your matrix?: ");
            String l = input.nextLine();
            wInt = Integer.parseInt(w);
            if (wInt < 0) {
                System.out.println("negative input, try again? (y/n)");
                String c = input.nextLine();
                if (c.equals("y")){
                    main();
                }
            }
            lInt = Integer.parseInt(l);
            if (lInt < 0) {
                System.out.println("negative input, try again? (y/n)");
                String c = input.nextLine();
                if (c.equals("y")){
                    main();
                }
            }
            /* Creates the Game World where the simulation will play */




            System.out.println("How many of each rock paper scissors do you want\n" +
                    "in the world (i.e., three rocks, three papers, three scissors. input: 3)?");
            String Objects = input.nextLine();
            int objInts = Integer.parseInt(Objects);
            System.out.printf("Added %d rock, %d paper, %d scissors.", objInts, objInts, objInts);
            if ((objInts * 3) > (wInt * lInt)) {
                System.out.println("too many objects");
            } else {
                runGame(objInts);
            }




        }
        catch (NumberFormatException e) {
            System.out.println("incorrect input, try again? (y/n)");
            Scanner input = new Scanner(System.in);
            String c = input.nextLine();
            if (c.equals("y")){
                main();
            }
        }
        catch (NegativeArraySizeException e) {
            System.out.println("negative input, try again? (y/n)");
            Scanner input = new Scanner(System.in);
            String c = input.nextLine();
            if (c.equals("y")){
                main();
            }
        }


    }


}
