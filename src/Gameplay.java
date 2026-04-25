
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
//Steps
// 1. Ask for user input for dimensions (ex. width: 3, height: 3)
// 2. Ask for user input for entities ("How many of each rock paper scissors do you want
//in the world (ie, three rocks, three papers, three scissors. input: 3)
// 3. check if the amount of rocks, papers, and scissors provided will fit in the world space
// 4. run world function and print result
import com.sun.jdi.IntegerType;


import java.util.Scanner;


public class Gameplay {
    public static int wInt = 0;
    public static int lInt = 0;
    public static World GameWorld;

    // Takes in the user input
    static void runGame(Integer objects) {
        Rock.rockCount = 0;
        Paper.paperCount = 0;
        Scissors.scissorsCount = 0;
        GameWorld.initializeObjects(objects);
        GameWorld.playRound();
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean validInput = false;

        while (!validInput) {
            try {
                System.out.println("Welcome to the Rock, paper, scissors game \n"); // This section of code prompts the users to input a length-
                System.out.println("What is the width of your matrix?: ");          // and width for the game matrix
                String w = input.nextLine();
                System.out.println("What is the height of your matrix?: ");
                String l = input.nextLine();

                wInt = Integer.parseInt(w);
                lInt = Integer.parseInt(l);

                if (wInt < 0 || lInt < 0) {
                    System.out.println("negative input, try again? (y/n)");
                    String c = input.nextLine();
                    if (c.equalsIgnoreCase("y")) {
                        continue;
                    }
                    return;
                }

                // Creates the Game World where the simulation will play
                GameWorld = new World(wInt, lInt);

                System.out.println("How many of each rock paper scissors do you want\n" +
                        "in the world (i.e., three rocks, three papers, three scissors. input: 3)?");
                String Objects = input.nextLine();
                int objInts = Integer.parseInt(Objects);

                if (objInts < 0) {
                    System.out.println("negative input, try again? (y/n)");
                    String c = input.nextLine();
                    if (c.equals("y")) {
                        continue;
                    }
                    return;
                }

                System.out.printf("Added %d rock, %d paper, %d scissors.%n", objInts, objInts, objInts);

                if ((objInts * 3) > (wInt * lInt)) {
                    System.out.println("too many objects");
                    System.out.println("try again? (y/n)");
                    String c = input.nextLine();
                    if (c.equals("y")) {
                        continue;
                    }
                    return;
                } else {
                    runGame(objInts);
                    validInput = true;
                }
            }
            catch (NumberFormatException e) {
                System.out.println("incorrect input, try again? (y/n)");
                String c = input.nextLine();
                if (!c.equals("y")) {
                    return;
                }
            }
            catch (NegativeArraySizeException e) {
                System.out.println("negative input, try again? (y/n)");
                String c = input.nextLine();
                if (!c.equals("y")) {
                    return;
                }
            }
        }
    }
}