
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
// 2. Ask for user input for entities "How many of each rock paper scissors do you want
//in the world" (ie, three rocks, three papers, three scissors. input: 3)
// 3. check if the amount of rocks, papers, and scissors provided will fit in the world space
// 4. run world function and print result
import com.sun.jdi.IntegerType;
//
//
//import java.util.Scanner;
//
//
//public class Gameplay {
//    public static int wInt = 0; // width of the world
//    public static int hInt = 0; // height of the world
//    public static World GameWorld;
//
//    /*
//    Purpose: to initialize a world and run a game
//    input: null
//    result: a world is created and a game is played (a bunch of things are printed to the console)
//    output: null
//     */
//    static void runGame(Integer objects) {
//        Rock.rockCount = 0;
//        Paper.paperCount = 0;
//        Scissors.scissorsCount = 0;
//        GameWorld = new World(wInt, hInt, objects);
//        GameWorld.playRound();
//    }
//
//    public static void main(String[] args) {
//        Scanner input = new Scanner(System.in);
//        boolean validInput = false;
//
//        while (!validInput) {
//            try {
//                // Prompts for width and Height of the world
//                System.out.println("Welcome to the Rock, paper, scissors game \n"); // This section of code prompts the users to input a length-
//                System.out.println("What is the width of your world?: ");          // and width for the game matrix
//                // prompts for width of the world
//                String w = input.nextLine();
//                // prompts for height of the world
//                System.out.println("What is the height of your world?: ");
//                String h = input.nextLine();
//
//                // sets world width and converts string -> int
//                wInt = Integer.parseInt(w);
//                // sets world height and converts string -> int
//                hInt = Integer.parseInt(h);
//
//                // checks to see if height or width are negative
//                if (wInt < 0 || hInt < 0) {
//                    System.out.println("negative input, try again? (y/n)");
//                    String c = input.nextLine();
//                    if (c.equalsIgnoreCase("y")) {
//                        continue;
//                    }
//                    return;
//                }
//
//                // Creates the Game World where the simulation will play
//
//
//                // asks for number of entities
//                System.out.println("How many of each rock paper scissors do you want\n" +
//                        "in the world (i.e., three rocks, three papers, three scissors. input: 3)?");
//                String Objects = input.nextLine();
//                // converts number of objects wanted from string -> int
//                int objInts = Integer.parseInt(Objects);
//                // checks to see if objects input is negative or 0
//                if (objInts <= 0) {
//                    System.out.println("invalid input, needs to be greater than 0, try again? (y/n)");
//                    String c = input.nextLine();
//                    if (c.equals("y")) {
//                        continue;
//                    }
//                    return;
//                }
//
//
//                // checks to see if the amount of objects the user requested is to many for the world
//                if ((objInts * 3) > (wInt * hInt)) {
//                    System.out.println("too many objects");
//                    System.out.println("try again? (y/n)");
//                    String c = input.nextLine();
//                    if (c.equals("y")) {
//                        continue;
//                    }
//                    return;
//                } else {
//                    // prints this to tell the user that we are tring to add entities
//                    System.out.printf("Added %d rock, %d paper, %d scissors.%n", objInts, objInts, objInts);
//                    runGame(objInts);
//                    // stops the while loop
//                    validInput = true;
//                }
//            }
//            // catches an error if they put a string that can not be converted into a number
//            catch (NumberFormatException e) {
//                System.out.println("incorrect input, try again? (y/n)");
//                String c = input.nextLine();
//                if (!c.equals("y")) {
//                    return;
//                }
//            }
//            // catches an error if the array is negative so we can not create the array
//            catch (NegativeArraySizeException e) {
//                System.out.println("negative input, try again? (y/n)");
//                String c = input.nextLine();
//                if (!c.equals("y")) {
//                    return;
//                }
//            }
//        }
//    }
//}
