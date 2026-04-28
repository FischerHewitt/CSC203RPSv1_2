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




Testing Framework:
System.out.println("Testing moveRock() method. Current position ( %d, %d )." ,
       getEntityPosition().x, getEntityPosition().y );
       System.out.println("Expected output one of: " +
               "( 3, 7 ), ( 3, 6 ), ( 3, 8 ), ( 4, 6 ), ( 4, 8 ), ( 5, 7 ), (5, 6 ), ( 5, 8 )");
       System.out.printf("Actual output: (%d, %d).", getEntityPosition().x, getEntityPosition().y );
*/




import java.util.Arrays;


public class TestCases {
    public static void main(String[] args){
        // Test 01
        // Testing World(int width=2, int height=3)
        System.out.println("Test 01:\nTesting World(int width=2, int height=3) method.");
        System.out.println("Expected output: w=2, h=3");
        System.out.print("Actual output:");
        World world1 = new World(2, 3); // creates a new world with width=2 height=3
        System.out.printf("w=%d, h=%d %n%n", world1.world.length, world1.world[0].length); //formats with width and height


        // Test 02
        // Testing printWorld() with width=2, height=3, world is empty
        System.out.println("\n\nTest 02:\nTesting printWorld() method. w=2, h=3, world is empty.");
        System.out.println(
                """
        Expected output:
        World:
        +-+-+
        | | |
        +-+-+
        | | |
        +-+-+
        | | |
        +-+-+
        """);
        System.out.println("Actual output:");
        world1.printWorld(); //prints the world


        // Test 03
        // Testing Print world with objects in the world.
        System.out.println("\n\nTest 03:\nTesting printWorld() method. w=3, h=4, Rocks=3");
        System.out.println(
                """
        Expected output:
        World:
        +-+-+-+
        |R| | |
        +-+-+-+
        | |R| |
        +-+-+-+
        | | |R|
        +-+-+-+
        | | | |
        +-+-+-+
        """);
        World world2 = new World(3, 4);
        Rock.rockCount = 0;
        Paper.paperCount = 0;
        Scissors.scissorsCount = 0;// new world width=3 height=4
        world2.world[0][0] = new Rock(new Point(0,0), world2.world); // new rock at Point(0,0)
        world2.world[1][1] = new Rock(new Point(1,1), world2.world); // new rock at Point(1,1)
        world2.world[2][2] = new Rock(new Point(2,2), world2.world); // new rock at Point(2,2)
        System.out.println("Actual output:");
        world2.printWorld();


        // Test 04
        // Test addRock() method. w=2, h=3, Rocks=1
        System.out.println("\n\nTest 04:\nTesting addRock() method. w=2, h=3, Rocks=1");
        System.out.println(
                """
        Expected output:
        World:
        +-+-+or+-+-+or+-+-+or+-+-+or+-+-+or+-+-+
        |R| |  | |R|  | | |  | | |  | | |  | | |
        +-+-+  +-+-+  +-+-+  +-+-+  +-+-+  +-+-+
        | | |  | | |  |R| |  | |R|  | | |  | | |
        +-+-+  +-+-+  +-+-+  +-+-+  +-+-+  +-+-+
        | | |  | | |  | | |  | | |  |R| |  | |R|
        +-+-+  +-+-+  +-+-+  +-+-+  +-+-+  +-+-+
        """);
        Rock.rockCount = 0;
        Paper.paperCount = 0;
        Scissors.scissorsCount = 0;
        world1.addRock();
        System.out.println("Actual output:");
        world1.printWorld();


        // Test 05
        // Test addPaper() method. w=2, h=3, paper=1
        System.out.println("\n\nTest 05:\nTesting addPaper() method. w=2, h=3, Paper=1");
        System.out.println(
                """
        Expected output:
        World:
        +-+-+or+-+-+or+-+-+or+-+-+or+-+-+or+-+-+
        |P| |  | |P|  | | |  | | |  | | |  | | |
        +-+-+  +-+-+  +-+-+  +-+-+  +-+-+  +-+-+
        | | |  | | |  |P| |  | |P|  | | |  | | |
        +-+-+  +-+-+  +-+-+  +-+-+  +-+-+  +-+-+
        | | |  | | |  | | |  | | |  |P| |  | |P|
        +-+-+  +-+-+  +-+-+  +-+-+  +-+-+  +-+-+
        """);
        World world3 = new World(2, 3);
        Rock.rockCount = 0;
        Paper.paperCount = 0;
        Scissors.scissorsCount = 0;
        world3.addPaper();
        System.out.println("Actual output:");
        world3.printWorld();


        // Test 06
        // Test addScissors() method. w=2, h=3, scissors = 1
        System.out.println("\n\nTest 06:\nTesting addScissors() method. w=2, h=3, Scissors=1");
        System.out.println(
                """
        Expected output:
        World:
        +-+-+or+-+-+or+-+-+or+-+-+or+-+-+or+-+-+
        |S| |  | |S|  | | |  | | |  | | |  | | |
        +-+-+  +-+-+  +-+-+  +-+-+  +-+-+  +-+-+
        | | |  | | |  |S| |  | |S|  | | |  | | |
        +-+-+  +-+-+  +-+-+  +-+-+  +-+-+  +-+-+
        | | |  | | |  | | |  | | |  |S| |  | |S|
        +-+-+  +-+-+  +-+-+  +-+-+  +-+-+  +-+-+
        """);
        World world4 = new World(2, 3);
        Rock.rockCount = 0;
        Paper.paperCount = 0;
        Scissors.scissorsCount = 0;
        world4.addScissors();
        System.out.println("Actual output:");
        world4.printWorld();


        // Test 07
        // Test findEmpty() method indirectly using world1. w=2, h=3, Rocks=12
        System.out.println("\n\nTest 07:\nTesting findEmpty() method. w=2, h=3, Rocks=12");
        System.out.println(
                """
        Expected output:
        World:
        +-+-+-+-+
        |R|R|R|R|
        +-+-+-+-+
        |R|R|R|R|
        +-+-+-+-+
        |R|R|R|R|
        +-+-+-+-+
        """);
        World world7 = new World(4, 3); // new world width=3 height=4
        Rock.rockCount = 0;
        Paper.paperCount = 0;
        Scissors.scissorsCount = 0;
        for (int xWorld7 = 0; xWorld7 < world7.width - 1; xWorld7++){
            for (int yWorld7 = 0; yWorld7 < world7.height; yWorld7++){
                world7.world[xWorld7][yWorld7] = new Rock(new Point(xWorld7,yWorld7), world7.world);
            }
        }
        world7.world[3][0] = new Rock(new Point(3,0), world7.world); // new rock at Point(3,0)
        world7.world[3][1] = new Rock(new Point(3,1), world7.world); // new rock at Point(3,1)
        world7.addRock();
        System.out.println("Actual output:");
        world7.printWorld();




        // Test 08
        // Test findEmpty() method indirectly using world1. w=2, h=3, Rocks=5
        System.out.println("\n\nTest 08:\nTesting findEmpty() method. w=2, h=3, Rocks=5");
        System.out.println(
                """
        Expected output:
        World:
        +-+-+or+-+-+or+-+-+or+-+-+or+-+-+or+-+-+
        |R|R|  |R|R|  |R|R|  |R|R|  |R| |  | |R|
        +-+-+  +-+-+  +-+-+  +-+-+  +-+-+  +-+-+
        |R|R|  |R|R|  |R| |  | |R|  |R|R|  |R|R|
        +-+-+  +-+-+  +-+-+  +-+-+  +-+-+  +-+-+
        |R| |  | |R|  |R|R|  |R|R|  |R|R|  |R|R|
        +-+-+  +-+-+  +-+-+  +-+-+  +-+-+  +-+-+
        """);
        Rock.rockCount = 1;
        Paper.paperCount = 0;
        Scissors.scissorsCount = 0;
        world1.addRock();
        world1.addRock();
        world1.addRock();
        world1.addRock();
        System.out.println("Actual output:");
        world1.printWorld();


        // Test 09
        // Test getRandomWidth() and getRandomHeight() method. w=2, h=3
        System.out.println("\n\nTest 09:\nTesting getRandomWidth() and getRandomHeight() method. w=2, h=3");
        System.out.println(
                """
        Expected output:
        getRandomWidth = 0 or 1
        getRandomHeight = 0, 1, or 2
        """);
        System.out.println("Actual output:");
        System.out.printf("getRandomWidth = %d%n" +
                "getRandomHeight = %d", world1.getRandomWidth(), world1.getRandomHeight());


        // Test 10
        // Test addEntitys method.
        System.out.println("\n\nTest 10:\nTesting addEntitys() method.");
        System.out.println(
                """
        Expected output: A world with 2 rocks 2 paper and 2 scissors.
        ex:
        +-+-+
        |R|P|
        +-+-+
        |P|S|
        +-+-+
        |S|R|
        +-+-+
        """);
        System.out.println("Actual output:");
        World world10 = new World(2, 3);
        Rock.rockCount = 0;
        Paper.paperCount = 0;
        Scissors.scissorsCount = 0;
        world10.addEntitys(2);
        world10.printWorld();


        // Test 11
        // Test moveRock() method. Rock starting at (1,1)
        System.out.println("\n\nTest 11:\nTesting moveRock() method, starting at (1,1).");
        System.out.println(
                """
        Expected output:
        ex:
        +-+-+or+-+-+or+-+-+or+-+-+or+-+-+or+-+-+
        |R| |  | |R|  | | |  | | |  | | |  | | |
        +-+-+  +-+-+  +-+-+  +-+-+  +-+-+  +-+-+
        | | |  | | |  |R| |  | |R|  | | |  | | |
        +-+-+  +-+-+  +-+-+  +-+-+  +-+-+  +-+-+
        | | |  | | |  | | |  | | |  |R| |  | |R|
        +-+-+  +-+-+  +-+-+  +-+-+  +-+-+  +-+-+
        """);
        System.out.println("Actual output:");
        World world11 = new World(2, 3);
        Rock.rockCount = 0;
        Paper.paperCount = 0;
        Scissors.scissorsCount = 0;
        world11.world[1][1] = new Rock(new Point(1,1), world11.world);
        ((Rock) world11.world[1][1]).moveRock();
        world11.printWorld();


        // Test 12
        // Test movePaper() method. Paper starting at (1,1)
        System.out.println("\n\nTest 12:\nTesting movePaper() method, starting at (1,1).");
        System.out.println(
                """
        Expected output:
        ex:
        +-+-+-+or+-+-+-+or+-+-+-+or+-+-+-+or+-+-+-+or+-+-+-+or+-+-+-+or+-+-+-+or+-+-+-+
        |P| | |  | |P| |  | | |P|  | | | |  | | | |  | | | |  | | | |  | | | |  | | | |
        +-+-+-+or+-+-+-+or+-+-+-+or+-+-+-+or+-+-+-+or+-+-+-+or+-+-+-+or+-+-+-+or+-+-+-+
        | | | |  | | | |  | | | |  |P| | |  | |P| |  | | |P|  | | | |  | | | |  | | | |
        +-+-+-+or+-+-+-+or+-+-+-+or+-+-+-+or+-+-+-+or+-+-+-+or+-+-+-+or+-+-+-+or+-+-+-+
        | | | |  | | | |  | | | |  | | | |  | | | |  | | | |  |P| | |  | |P| |  | | |P|
        +-+-+-+or+-+-+-+or+-+-+-+or+-+-+-+or+-+-+-+or+-+-+-+or+-+-+-+or+-+-+-+or+-+-+-+
        """);
        System.out.println("Actual output:");
        World world12 = new World(3, 3);
        Rock.rockCount = 0;
        Paper.paperCount = 0;
        Scissors.scissorsCount = 0;
        world12.world[1][1] = new Paper(new Point(1,1), world12.world);
        ((Paper) world12.world[1][1]).movePaper();
        world12.printWorld();


        // Test 13
        // Test moveScissors() method. Scissors starting at (0,0)
        System.out.println("\n\nTest 13:\nTesting moveScissors() method, starting at (0,0).");
        System.out.println(
                """
        Expected output:
        ex:
        +-+-+-+or+-+-+-+or+-+-+-+or+-+-+-+or+-+-+-+or+-+-+-+or+-+-+-+or+-+-+-+or+-+-+-+
        |S| | |  | |S| |  | | |S|  | | | |  | | | |  | | | |  | | | |  | | | |  | | | |
        +-+-+-+or+-+-+-+or+-+-+-+or+-+-+-+or+-+-+-+or+-+-+-+or+-+-+-+or+-+-+-+or+-+-+-+
        | | | |  | | | |  | | | |  |S| | |  | |S| |  | | |S|  | | | |  | | | |  | | | |
        +-+-+-+or+-+-+-+or+-+-+-+or+-+-+-+or+-+-+-+or+-+-+-+or+-+-+-+or+-+-+-+or+-+-+-+
        | | | |  | | | |  | | | |  | | | |  | | | |  | | | |  |S| | |  | |S| |  | | |S|
        +-+-+-+or+-+-+-+or+-+-+-+or+-+-+-+or+-+-+-+or+-+-+-+or+-+-+-+or+-+-+-+or+-+-+-+
        """);
        System.out.println("Actual output:");
        World world13 = new World(3, 3);
        Rock.rockCount = 0;
        Paper.paperCount = 0;
        Scissors.scissorsCount = 0;
        world13.world[0][0] = new Scissors(new Point(0,0), world13.world);
        ((Scissors) world13.world[0][0]).moveScissors();
        world13.printWorld();


        // Test 14
        // Test moveRock() method. Rock starting at (1,1) and seeing if it stays at 1,1 if its blocked in
        System.out.println("\n\nTest 14:\nTesting moveRock() method, starting at (1,1), seeing if it stays at (1,1).");
        System.out.println(
                """
                Expected output:
                World:
                +-+-+-+-+
                |R|R|R|R|
                +-+-+-+-+
                |R|R|R|R|
                +-+-+-+-+
                |R|R|R|R|
                +-+-+-+-+
                """);
        Rock.rockCount = 12;
        Paper.paperCount = 0;
        Scissors.scissorsCount = 0;
        ((Rock) world7.world[1][1]).moveRock();
        System.out.println("Actual output:");
        world7.printWorld();


        // Test 15
// Test movePaper() method. Paper at (1,1) blocked in
        System.out.println("\n\nTest 15:\nTesting movePaper() method, starting at (1,1), blocked in.");
        System.out.println(
                """
        Expected output:
        World:
        +-+-+-+
        |P|P|P|
        +-+-+-+
        |P|P|P|
        +-+-+-+
        |P|P|P|
        +-+-+-+
        """);


        World world15 = new World(3, 3);
        Rock.rockCount = 0;
        Paper.paperCount = 0;
        Scissors.scissorsCount = 0;


        // Fill entire grid with Paper
        for (int x15 = 0; x15 < 3; x15++) {
            for (int y15 = 0; y15 < 3; y15++) {
                world15.world[x15][y15] = new Paper(new Point(x15, y15), world15.world);
            }
        }


        // Try to move center Paper
        ((Paper) world15.world[1][1]).movePaper();
        System.out.println("Actual output:");
        world15.printWorld();


        // Test 16
        // Test moveScissors() method. Scissors at (1,1) blocked in
        System.out.println("\n\nTest 16:\nTesting moveScissors() method, starting at (1,1), blocked in.");
        System.out.println(
                """
        Expected output:
        World:
        +-+-+-+
        |S|S|S|
        +-+-+-+
        |S|S|S|
        +-+-+-+
        |S|S|S|
        +-+-+-+
        """);


        World world16 = new World(3, 3);
        Rock.rockCount = 0;
        Paper.paperCount = 0;
        Scissors.scissorsCount = 0;


        // Fill entire grid with Scissors
        for (int x16 = 0; x16 < 3; x16++) {
            for (int y16 = 0; y16 < 3; y16++) {
                world16.world[x16][y16] = new Scissors(new Point(x16, y16), world16.world);
            }
        }


        // Try to move center Scissors
        ((Scissors) world16.world[1][1]).moveScissors();
        System.out.println("Actual output:");
        world16.printWorld();




        // Test 17
        // Test scissorsAttack() method. Scissors starting at (1,1)
        System.out.println("\n\nTest 17:\nTesting scissorsAttack(). Scissors is at (1,1).");
        System.out.println(
                """
        Expected output:
        All Paper in the 8 surrounding squares are removed.
        ex:
        +-+-+-+
        | | | |
        +-+-+-+
        | |S| |
        +-+-+-+
        | | | |
        +-+-+-+
        """);
        World world17 = new World(3, 3);
        Rock.rockCount = 0;
        Paper.paperCount = 0;
        Scissors.scissorsCount = 0;
        world17.world[1][1] = new Scissors(new Point(1,1), world17.world);


        // Add Paper to all 8 surrounding spaces
        world17.world[0][0] = new Paper(new Point(0,0), world17.world);
        world17.world[0][1] = new Paper(new Point(0,1), world17.world);
        world17.world[0][2] = new Paper(new Point(0,2), world17.world);
        world17.world[1][0] = new Paper(new Point(1,0), world17.world);
        world17.world[1][2] = new Paper(new Point(1,2), world17.world);
        world17.world[2][0] = new Paper(new Point(2,0), world17.world);
        world17.world[2][1] = new Paper(new Point(2,1), world17.world);
        world17.world[2][2] = new Paper(new Point(2,2), world17.world);


        System.out.println("Added Paper:");
        world17.printWorld();
        System.out.println("Actual output:");
        ((Scissors) world17.world[1][1]).scissorsAttack();
        world17.printWorld();


        // Test 18
        // Test rockAttack() method. Rock starting at (1,1)
        System.out.println("\n\nTest 18:\nTesting rockAttack(). Rock is at (1,1).");
        System.out.println(
                """
        Expected output:
        All Scissors in the 8 surrounding squares are removed.
        ex:
        +-+-+-+
        | | | |
        +-+-+-+
        | |R| |
        +-+-+-+
        | | | |
        +-+-+-+
        """);
        World world18 = new World(3, 3);
        Rock.rockCount = 0;
        Paper.paperCount = 0;
        Scissors.scissorsCount = 0;
        world18.world[1][1] = new Rock(new Point(1,1), world18.world);


        // Add Scissors to all 8 surrounding spaces
        world18.world[0][0] = new Scissors(new Point(0,0), world18.world);
        world18.world[0][1] = new Scissors(new Point(0,1), world18.world);
        world18.world[0][2] = new Scissors(new Point(0,2), world18.world);
        world18.world[1][0] = new Scissors(new Point(1,0), world18.world);
        world18.world[1][2] = new Scissors(new Point(1,2), world18.world);
        world18.world[2][0] = new Scissors(new Point(2,0), world18.world);
        world18.world[2][1] = new Scissors(new Point(2,1), world18.world);
        world18.world[2][2] = new Scissors(new Point(2,2), world18.world);


        System.out.println("Added Scissors:");
        world18.printWorld();
        System.out.println("Actual output:");
        ((Rock) world18.world[1][1]).rockAttack();
        world18.printWorld();






        // Test 19
        // Test paperAttack() method. Paper starting at (1,1)
        System.out.println("\n\nTest 19:\nTesting paperAttack(). Paper is at (1,1).");
        System.out.println(
                """
        Expected output:
        All Rocks in the 8 surrounding squares are removed.
        ex:
        +-+-+-+
        | | | |
        +-+-+-+
        | |P| |
        +-+-+-+
        | | | |
        +-+-+-+
        """);
        World world19 = new World(3, 3);
        Rock.rockCount = 0;
        Paper.paperCount = 0;
        Scissors.scissorsCount = 0;
        world19.world[1][1] = new Paper(new Point(1,1), world19.world);


        // Add Rocks to all 8 surrounding spaces
        world19.world[0][0] = new Rock(new Point(0,0), world19.world);
        world19.world[0][1] = new Rock(new Point(0,1), world19.world);
        world19.world[0][2] = new Rock(new Point(0,2), world19.world);
        world19.world[1][0] = new Rock(new Point(1,0), world19.world);
        world19.world[1][2] = new Rock(new Point(1,2), world19.world);
        world19.world[2][0] = new Rock(new Point(2,0), world19.world);
        world19.world[2][1] = new Rock(new Point(2,1), world19.world);
        world19.world[2][2] = new Rock(new Point(2,2), world19.world);


        System.out.println("Added Rocks:");
        world19.printWorld();
        System.out.println("Actual output:");
        ((Paper) world19.world[1][1]).paperAttack();
        world19.printWorld();




// Test 20
        // getEntityPosition for rock at 1,1
        System.out.println("\n\nTest 20:\nTesting getEntityPosition(). Rock is placed at (1,1).");
        System.out.println(
                """
        Expected output:
        x=1, y=1
        """);
        World world20 = new World(3, 3);
        Rock.rockCount = 0;
        Paper.paperCount = 0;
        Scissors.scissorsCount = 0;
        world20.world[1][1] = new Rock(new Point(1, 1), world20.world);
        Point rockPosition = ((Rock) world20.world[1][1]).getEntityPosition();
        System.out.println("Actual output:");
        System.out.printf("x=%d, y=%d %n%n", rockPosition.getPointX(), rockPosition.getPointY());




        // Test 21 - same thing but corner
        System.out.println("\n\nTest 21:\nTesting getEntityPosition(). Rock placed at corner (0,0).");
        System.out.println(
                """
        Expected output:
        x=0, y=0
        """);
        World world21 = new World(3, 3);
        Rock.rockCount = 0;
        Paper.paperCount = 0;
        Scissors.scissorsCount = 0;
        world21.world[0][0] = new Rock(new Point(0, 0), world21.world);
        Point result21 = ((Rock) world21.world[0][0]).getEntityPosition();
        System.out.println("Actual output:");
        System.out.printf("x=%d, y=%d %n%n", result21.getPointX(), result21.getPointY());




        // Test 22 - setEntityPosition
        // move rock from 1,1 to 2,2
        System.out.println("\n\nTest 22:\nTesting setEntityPosition(). Rock moved from (1,1) to (2,2).");
        System.out.println(
                """
        Expected output:
        x=2, y=2
        """);
        World world22 = new World(3, 3);
        Rock.rockCount = 0;
        Paper.paperCount = 0;
        Scissors.scissorsCount = 0;
        world22.world[1][1] = new Rock(new Point(1, 1), world22.world);
        Rock movedRock = (Rock) world22.world[1][1];
        movedRock.setEntityPosition(new Point(2, 2));
        System.out.println("Actual output:");
        System.out.printf("x=%d, y=%d %n%n", movedRock.getEntityPosition().getPointX(), movedRock.getEntityPosition().getPointY());




        // Test 23
        // what happens when rock gets removed, position should be -1,-1
        System.out.println("\n\nTest 23:\nTesting setEntityPosition(). Rock set to (-1,-1) when removed.");
        System.out.println(
                """
        Expected output:
        x=-1, y=-1
        """);
        World world23 = new World(3, 3);
        Rock.rockCount = 0;
        Paper.paperCount = 0;
        Scissors.scissorsCount = 0;
        world23.world[0][0] = new Rock(new Point(0, 0), world23.world);
        Rock deadRock = (Rock) world23.world[0][0];
        deadRock.setEntityPosition(new Point(-1, -1));
        System.out.println("Actual output:");
        System.out.printf("x=%d, y=%d %n%n", deadRock.getEntityPosition().getPointX(), deadRock.getEntityPosition().getPointY());




        // Test 24 - checkNeighbors
        // rock in the middle of 3x3 should have 9 (includes itself)
        System.out.println("\n\nTest 24:\nTesting checkNeighbors(). Rock at center (1,1) in 3x3.");
        System.out.println(
                """
        Expected output:
        Neighbor count = 9
        """);
        World world24 = new World(3, 3);
        Rock.rockCount = 0;
        Paper.paperCount = 0;
        Scissors.scissorsCount = 0;
        world24.world[1][1] = new Rock(new Point(1, 1), world24.world);
        int result24 = ((Rock) world24.world[1][1]).checkNeighbors().size();
        System.out.println("Actual output:");
        System.out.printf("Neighbor count = %d %n%n", result24);




        // Test 25
        // corner should only have 4 nieghbors
        System.out.println("\n\nTest 25:\nTesting checkNeighbors(). Rock at corner (0,0) in 3x3.");
        System.out.println(
                """
        Expected output:
        Neighbor count = 4
        """);
        World world25 = new World(3, 3);
        Rock.rockCount = 0;
        Paper.paperCount = 0;
        Scissors.scissorsCount = 0;
        world25.world[0][0] = new Rock(new Point(0, 0), world25.world);
        int rockCornerNeighbors = ((Rock) world25.world[0][0]).checkNeighbors().size();
        System.out.println("Actual output:");
        System.out.printf("Neighbor count = %d %n%n", rockCornerNeighbors);




        // Test 26 - edge not corner so should be 6
        System.out.println("\n\nTest 26:\nTesting checkNeighbors(). Rock at edge (1,0) in 3x3.");
        System.out.println(
                """
        Expected output:
        Neighbor count = 6
        """);
        World world26 = new World(3, 3);
        Rock.rockCount = 0;
        Paper.paperCount = 0;
        Scissors.scissorsCount = 0;
        world26.world[1][0] = new Rock(new Point(1, 0), world26.world);
        int result26 = ((Rock) world26.world[1][0]).checkNeighbors().size();
        System.out.println("Actual output:");
        System.out.printf("Neighbor count = %d %n%n", result26);




        // Test 27
        System.out.println("\n\nTest 27:\nTesting getEntityPosition(). Scissors placed at (1,1).");
        System.out.println(
                """
        Expected output:
        x=1, y=1
        """);
        World world27 = new World(3, 3);
        Rock.rockCount = 0;
        Paper.paperCount = 0;
        Scissors.scissorsCount = 0;
        world27.world[1][1] = new Scissors(new Point(1, 1), world27.world);
        Point scissorsPosition = ((Scissors) world27.world[1][1]).getEntityPosition();
        System.out.println("Actual output:");
        System.out.printf("x=%d, y=%d %n%n", scissorsPosition.getPointX(), scissorsPosition.getPointY());




        // Test 28 - corner case for scissors getEntityPosition
        System.out.println("\n\nTest 28:\nTesting getEntityPosition(). Scissors at corner (0,0).");
        System.out.println(
                """
        Expected output:
        x=0, y=0
        """);
        World world28 = new World(3, 3);
        Rock.rockCount = 0;
        Paper.paperCount = 0;
        Scissors.scissorsCount = 0;
        world28.world[0][0] = new Scissors(new Point(0, 0), world28.world);
        Point result28 = ((Scissors) world28.world[0][0]).getEntityPosition();
        System.out.println("Actual output:");
        System.out.printf("x=%d, y=%d %n%n", result28.getPointX(), result28.getPointY());




        // Test 29 - setEntityPosition scissors
        System.out.println("\n\nTest 29:\nTesting setEntityPosition(). Scissors moved from (1,1) to (2,2).");
        System.out.println(
                """
        Expected output:
        x=2, y=2
        """);
        World world29 = new World(3, 3);
        Rock.rockCount = 0;
        Paper.paperCount = 0;
        Scissors.scissorsCount = 0;
        world29.world[1][1] = new Scissors(new Point(1, 1), world29.world);
        Scissors movedScissors = (Scissors) world29.world[1][1];
        movedScissors.setEntityPosition(new Point(2, 2));
        System.out.println("Actual output:");
        System.out.printf("x=%d, y=%d %n%n", movedScissors.getEntityPosition().getPointX(), movedScissors.getEntityPosition().getPointY());




        // Test 30
        // scissors removed, should go to -1 -1
        System.out.println("\n\nTest 30:\nTesting setEntityPosition(). Scissors set to (-1,-1) when removed.");
        System.out.println(
                """
        Expected output:
        x=-1, y=-1
        """);
        World world30 = new World(3, 3);
        Rock.rockCount = 0;
        Paper.paperCount = 0;
        Scissors.scissorsCount = 0;
        world30.world[0][0] = new Scissors(new Point(0, 0), world30.world);
        Scissors deadScissors = (Scissors) world30.world[0][0];
        deadScissors.setEntityPosition(new Point(-1, -1));
        System.out.println("Actual output:");
        System.out.printf("x=%d, y=%d %n%n", deadScissors.getEntityPosition().getPointX(), deadScissors.getEntityPosition().getPointY());




        // Test 31 - checkNeighbors scissors center
        System.out.println("\n\nTest 31:\nTesting checkNeighbors(). Scissors at center (1,1) in 3x3.");
        System.out.println(
                """
        Expected output:
        Neighbor count = 9
        """);
        World world31 = new World(3, 3);
        Rock.rockCount = 0;
        Paper.paperCount = 0;
        Scissors.scissorsCount = 0;
        world31.world[1][1] = new Scissors(new Point(1, 1), world31.world);
        int result31 = ((Scissors) world31.world[1][1]).checkNeighbors().size();
        System.out.println("Actual output:");
        System.out.printf("Neighbor count = %d %n%n", result31);




        // Test 32
        // corner scissors, should only be 4
        System.out.println("\n\nTest 32:\nTesting checkNeighbors(). Scissors at corner (0,0) in 3x3.");
        System.out.println(
                """
        Expected output:
        Neighbor count = 4
        """);
        World world32 = new World(3, 3);
        Rock.rockCount = 0;
        Paper.paperCount = 0;
        Scissors.scissorsCount = 0;
        world32.world[0][0] = new Scissors(new Point(0, 0), world32.world);
        int scissorsCornerNeighbors = ((Scissors) world32.world[0][0]).checkNeighbors().size();
        System.out.println("Actual output:");
        System.out.printf("Neighbor count = %d %n%n", scissorsCornerNeighbors);




        // Test 33 - edge should be 6
        System.out.println("\n\nTest 33:\nTesting checkNeighbors(). Scissors at edge (1,0) in 3x3.");
        System.out.println(
                """
        Expected output:
        Neighbor count = 6
        """);
        World world33 = new World(3, 3);
        Rock.rockCount = 0;
        Paper.paperCount = 0;
        Scissors.scissorsCount = 0;
        world33.world[1][0] = new Scissors(new Point(1, 0), world33.world);
        int result33 = ((Scissors) world33.world[1][0]).checkNeighbors().size();
        System.out.println("Actual output:");
        System.out.printf("Neighbor count = %d %n%n", result33);

        // Test 34
        // Test removeEntitys() method. Dead Rock is removed from rocks list.
        System.out.println("\n\nTest 34:\nTesting removeEntitys() method. Dead Rock is removed from rocks list.");
        System.out.println(
                """
        Expected output:
        rocks size before = 2
        rocks size after = 1
        remaining rock position: x=1, y=1
        """);
        World world34 = new World(3, 3);
        // restets counts
        Rock.rockCount = 0;
        Paper.paperCount = 0;
        Scissors.scissorsCount = 0;
        // adds one alive and dead rock
        Rock aliveRock34 = new Rock(new Point(1, 1), world34.world);
        Rock deadRock34 = new Rock(new Point(-1, -1), world34.world);
        world34.rocks.add(aliveRock34);
        world34.rocks.add(deadRock34);
        // prints actual output
        System.out.println("Actual output:");
        System.out.printf("rocks size before = %d%n", world34.rocks.size());
        // removes entities
        world34.removeEntitys();
        System.out.printf("rocks size after = %d%n", world34.rocks.size());
        System.out.printf("remaining rock position: x=%d, y=%d %n%n",
                world34.rocks.get(0).getEntityPosition().getPointX(),
                world34.rocks.get(0).getEntityPosition().getPointY());


        // Test 35
        // Test removeEntitys() method. Dead Paper and Scissors are removed from lists.
        System.out.println("\n\nTest 35:\nTesting removeEntitys() method. Dead Paper and Scissors are removed from lists.");
        System.out.println(
                """
        Expected output:
        paper size before = 2
        scissors size before = 2
        paper size after = 1
        scissors size after = 1
        remaining paper position: x=0, y=0
        remaining scissors position: x=2, y=2
        """);
        World world35 = new World(3, 3);
        // resets counts
        Rock.rockCount = 0;
        Paper.paperCount = 0;
        Scissors.scissorsCount = 0;
        // adds 1 alive paper and scissors, and 1 dead paper and scissors
        Paper alivePaper35 = new Paper(new Point(0, 0), world35.world);
        Paper deadPaper35 = new Paper(new Point(-1, -1), world35.world);
        Scissors aliveScissors35 = new Scissors(new Point(2, 2), world35.world);
        Scissors deadScissors35 = new Scissors(new Point(-1, -1), world35.world);
        world35.paper.add(alivePaper35);
        world35.paper.add(deadPaper35);
        world35.scissors.add(aliveScissors35);
        world35.scissors.add(deadScissors35);
        // actual tesrting
        System.out.println("Actual output:");
        System.out.printf("paper size before = %d%n", world35.paper.size());
        System.out.printf("scissors size before = %d%n", world35.scissors.size());
        // remove entitys
        world35.removeEntitys();
        // prints outputs
        System.out.printf("paper size after = %d%n", world35.paper.size());
        System.out.printf("scissors size after = %d%n", world35.scissors.size());
        System.out.printf("remaining paper position: x=%d, y=%d%n",
                world35.paper.get(0).getEntityPosition().getPointX(),
                world35.paper.get(0).getEntityPosition().getPointY());
        System.out.printf("remaining scissors position: x=%d, y=%d %n%n",
                world35.scissors.get(0).getEntityPosition().getPointX(),
                world35.scissors.get(0).getEntityPosition().getPointY());


        // Test 36
        // Test removeEntitys() method. Living entities stay in their lists.
        System.out.println("\n\nTest 36:\nTesting removeEntitys() method. Living entities stay in their lists.");
        System.out.println(
                """
        Expected output:
        rocks size before = 1
        paper size before = 1
        scissors size before = 1
        rocks size after = 1
        paper size after = 1
        scissors size after = 1
        """);
        World world36 = new World(3, 3);
        // resets rock counts
        Rock.rockCount = 0;
        Paper.paperCount = 0;
        Scissors.scissorsCount = 0;
        // adds alive rock paper scissors
        Rock aliveRock36 = new Rock(new Point(0, 0), world36.world);
        Paper alivePaper36 = new Paper(new Point(1, 1), world36.world);
        Scissors aliveScissors36 = new Scissors(new Point(2, 2), world36.world);
        world36.rocks.add(aliveRock36);
        world36.paper.add(alivePaper36);
        world36.scissors.add(aliveScissors36);
        // prints actual output
        System.out.println("Actual output:");
        System.out.printf("rocks size before = %d%n", world36.rocks.size());
        System.out.printf("paper size before = %d%n", world36.paper.size());
        System.out.printf("scissors size before = %d%n", world36.scissors.size());
        // testing to make sure it does not remove anything alive
        world36.removeEntitys();
        System.out.printf("rocks size after = %d%n", world36.rocks.size());
        System.out.printf("paper size after = %d%n", world36.paper.size());
        System.out.printf("scissors size after = %d %n%n", world36.scissors.size());

        // Test __
        // Test playRound() method. Rock should beat Scissors and win.
        System.out.println("\n\nTest __:\nTesting playRound() method. Rock should defeat Scissors and win.");
        System.out.println(
                """
        Expected output:
        Initial world has one Rock and one Scissors.
        Scissors is removed during playRound().
        Final winner should be Rock.
        ex final world:
        +-+-+
        |R| |
        +-+-+
        | | |
        +-+-+
        Winner: Rock
        """);

        World world__ = new World(2, 2);
        Rock.rockCount = 0;
        Paper.paperCount = 0;
        Scissors.scissorsCount = 0;

        // Create Rock and Scissors
        Rock rock__ = new Rock(new Point(0, 0), world__.world);
        Scissors scissors__ = new Scissors(new Point(1, 0), world__.world);

        // Add them to world[][]
        world__.world[0][0] = rock__;
        world__.world[1][0] = scissors__;

        // Add them to ArrayLists used by playRound()
        world__.rocks.add(rock__);
        world__.scissors.add(scissors__);

        System.out.println("Actual output:");
        world__.playRound();
        System.out.println();

    }
}