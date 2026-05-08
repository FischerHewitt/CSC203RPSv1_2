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
    public static void main(String[] args) {
        // Test 01
        // Testing World(int width=2, int height=3)
        System.out.println("Test 01:\nTesting World(int width=2, int height=3) method.");
        System.out.println("Expected output: w=2, h=3");
        System.out.print("Actual output:");
        World world1 = new World(2, 3, 0); // creates a new world with width=2 height=3
        System.out.printf("w=%d, h=%d %n%n", world1.map.length, world1.map[0].length); //formats with width and height


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
        World world2 = new World(3, 4, 0);
        // new world width=3 height=4
        world2.map[0][0] = new Rock(new Point(0, 0)); // new rock at Point(0,0)
        world2.map[1][1] = new Rock(new Point(1, 1)); // new rock at Point(1,1)
        world2.map[2][2] = new Rock(new Point(2, 2)); // new rock at Point(2,2)
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

        Rock.initializeEntity(world1);
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
        World world3 = new World(2, 3, 0);
        Paper.initializeEntity(world3);
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
        World world4 = new World(2, 3, 0);
        Scissors.initializeEntity(world4);
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
        World world7 = new World(4, 3, 0); // new world width=3 height=4
        for (int xWorld7 = 0; xWorld7 < world7.width - 1; xWorld7++) {
            for (int yWorld7 = 0; yWorld7 < world7.height; yWorld7++) {
                world7.map[xWorld7][yWorld7] = new Rock(new Point(xWorld7, yWorld7));
            }
        }
        world7.map[3][0] = new Rock(new Point(3, 0)); // new rock at Point(3,0)
        world7.map[3][1] = new Rock(new Point(3, 1)); // new rock at Point(3,1)
        Rock.initializeEntity(world7);
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

        for (int idx = 0; idx < 4; idx++) {
            Rock.initializeEntity(world1);
        }
        System.out.println("Actual output:");
        world1.printWorld();

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
        World world10 = new World(2, 3, 2);
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
        World world11 = new World(2, 3, 0);
        world11.map[1][1] = new Rock(new Point(1, 1));
        world11.map[1][1].move(world11.map[1][1], world11.map);
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
        World world12 = new World(3, 3, 0);
        world12.map[1][1] = new Paper(new Point(1, 1));
        world12.map[1][1].move(world12.map[1][1], world12.map);
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
        World world13 = new World(3, 3, 0);
        world13.map[0][0] = new Scissors(new Point(0, 0));
        world13.map[0][0].move(world13.map[0][0], world13.map);
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
        world7.map[1][1].move(world7.map[1][1], world7.map);
        System.out.println("Actual output:");
        world7.printWorld();

        // Test 15
        //Test movePaper() method. Paper at (1,1) blocked in
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


        World world15 = new World(3, 3, 0);


        // Fill entire grid with Paper
        for (int x15 = 0; x15 < 3; x15++) {
            for (int y15 = 0; y15 < 3; y15++) {
                world15.map[x15][y15] = new Paper(new Point(x15, y15));
            }
        }

        // Try to move center Paper
        world15.map[1][1].move(world15.map[1][1], world15.map);
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


        World world16 = new World(3, 3, 0);


        // Fill entire grid with Scissors
        for (int x16 = 0; x16 < 3; x16++) {
            for (int y16 = 0; y16 < 3; y16++) {
                world16.map[x16][y16] = new Scissors(new Point(x16, y16));
            }
        }


        // Try to move center Scissors
        world16.map[1][1].move(world16.map[1][1], world16.map);
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
                        Paper Count: 0
                        """);
        World world17 = new World(3, 3, 0);

        world17.map[1][1] = new Scissors(new Point(1, 1));

        // Add Paper to all 8 surrounding spaces
        world17.map[0][0] = new Paper(new Point(0, 0));
        world17.map[0][1] = new Paper(new Point(0, 1));
        world17.map[0][2] = new Paper(new Point(0, 2));
        world17.map[1][0] = new Paper(new Point(1, 0));
        world17.map[1][2] = new Paper(new Point(1, 2));
        world17.map[2][0] = new Paper(new Point(2, 0));
        world17.map[2][1] = new Paper(new Point(2, 1));
        world17.map[2][2] = new Paper(new Point(2, 2));

        System.out.println("Added Paper:");
        world17.printWorld();
        System.out.println("Actual output:");
        world17.map[1][1].attack(world17.map);
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
                        Scissors Count: 0
                        """);
        World world18 = new World(3, 3, 0);
        world18.map[1][1] = new Rock(new Point(1, 1));

        // Add Scissors to all 8 surrounding spaces
        world18.map[0][0] = new Scissors(new Point(0, 0));
        world18.map[0][1] = new Scissors(new Point(0, 1));
        world18.map[0][2] = new Scissors(new Point(0, 2));
        world18.map[1][0] = new Scissors(new Point(1, 0));
        world18.map[1][2] = new Scissors(new Point(1, 2));
        world18.map[2][0] = new Scissors(new Point(2, 0));
        world18.map[2][1] = new Scissors(new Point(2, 1));
        world18.map[2][2] = new Scissors(new Point(2, 2));

        System.out.println("Added Scissors:");
        world18.printWorld();
        System.out.println("Actual output:");
        world18.map[1][1].attack(world18.map);
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
                        Rock Count: 0
                        """);
        World world19 = new World(3, 3, 0);

        world19.map[1][1] = new Paper(new Point(1, 1));

        // Add Rocks to all 8 surrounding spaces
        world19.map[0][0] = new Rock(new Point(0, 0));
        world19.map[0][1] = new Rock(new Point(0, 1));
        world19.map[0][2] = new Rock(new Point(0, 2));
        world19.map[1][0] = new Rock(new Point(1, 0));
        world19.map[1][2] = new Rock(new Point(1, 2));
        world19.map[2][0] = new Rock(new Point(2, 0));
        world19.map[2][1] = new Rock(new Point(2, 1));
        world19.map[2][2] = new Rock(new Point(2, 2));

        System.out.println("Added Rocks:");
        world19.printWorld();
        System.out.println("Actual output:");
        world19.map[1][1].attack(world19.map);
        world19.printWorld();


        //Test 20
        // getEntityPosition for rock at 1,1
        System.out.println("\n\nTest 20:\nTesting getEntityPosition(). Rock is placed at (1,1).");
        System.out.println(
                """
                        Expected output:
                        x=1, y=1
                        """);
        World world20 = new World(3, 3, 0);
        world20.map[1][1] = new Rock(new Point(1, 1));
        Point rockPosition = world20.map[1][1].getEntityPosition();
        System.out.println("Actual output:");
        System.out.printf("x=%d, y=%d %n%n", rockPosition.getPointX(), rockPosition.getPointY());


//        // Test 21 - same thing but corner
        System.out.println("\n\nTest 21:\nTesting getEntityPosition(). Rock placed at corner (0,0).");
        System.out.println(
                """
                        Expected output:
                        x=0, y=0
                        """);
        World world21 = new World(3, 3, 0);
        world21.map[0][0] = new Rock(new Point(0, 0));
        Point result21 = (world21.map[0][0]).getEntityPosition();
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
        World world22 = new World(3, 3, 0);
        world22.map[1][1] = new Rock(new Point(1, 1));
        Rock movedRock = (Rock) world22.map[1][1];
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
        World world23 = new World(3, 3, 0);
        world23.map[0][0] = new Rock(new Point(0, 0));
        Rock deadRock = (Rock) world23.map[0][0];
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
        World world24 = new World(3, 3, 0);
        world24.map[1][1] = new Rock(new Point(1, 1));
        int result24 = world24.map[1][1].checkNeighbors(new Point(1, 1), world24.map).size();
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
        World world25 = new World(3, 3, 0);
        world25.map[0][0] = new Rock(new Point(0, 0));
        int rockCornerNeighbors = world25.map[0][0].checkNeighbors(new Point(0, 0), world25.map).size();
        System.out.println("Actual output:");
        System.out.printf("Neighbor count = %d %n%n", rockCornerNeighbors);


        // Test 26 - edge not corner so should be 6
        System.out.println("\n\nTest 26:\nTesting checkNeighbors(). Rock at edge (1,0) in 3x3.");
        System.out.println(
                """
                        Expected output:
                        Neighbor count = 6
                        """);
        World world26 = new World(3, 3, 0);
        world26.map[1][0] = new Rock(new Point(1, 0));
        int result26 = world26.map[1][0]
                .checkNeighbors(world26.map[1][0].getEntityPosition(), world26.map)
                .size();
        System.out.println("Actual output:");
        System.out.printf("Neighbor count = %d %n%n", result26);

        // Test 27
        System.out.println("\n\nTest 27:\nTesting getEntityPosition(). Scissors placed at (1,1).");
        System.out.println(
                """
                        Expected output:
                        x=1, y=1
                        """);
        World world27 = new World(3, 3, 0);
        world27.map[1][1] = new Scissors(new Point(1, 1));
        Point scissorsPosition = world27.map[1][1].getEntityPosition();
        System.out.println("Actual output:");
        System.out.printf("x=%d, y=%d %n%n",
                scissorsPosition.getPointX(),
                scissorsPosition.getPointY());


        // Test 28 - corner case for scissors getEntityPosition
        System.out.println("\n\nTest 28:\nTesting getEntityPosition(). Scissors at corner (0,0).");
        System.out.println(
                """
                        Expected output:
                        x=0, y=0
                        """);
        World world28 = new World(3, 3, 0);
        world28.map[0][0] = new Scissors(new Point(0, 0));
        Point result28 = world28.map[0][0].getEntityPosition();
        System.out.println("Actual output:");
        System.out.printf("x=%d, y=%d %n%n",
                result28.getPointX(),
                result28.getPointY());

        // Test 29 - setEntityPosition scissors
        System.out.println("\n\nTest 29:\nTesting setEntityPosition(). Scissors moved from (1,1) to (2,2).");
        System.out.println(
                """
                        Expected output:
                        x=2, y=2
                        """);
        World world29 = new World(3, 3, 0);
        world29.map[1][1] = new Scissors(new Point(1, 1));
        IEntity movedScissors = world29.map[1][1];
        movedScissors.setEntityPosition(new Point(2, 2));
        System.out.println("Actual output:");
        System.out.printf("x=%d, y=%d %n%n",
                movedScissors.getEntityPosition().getPointX(),
                movedScissors.getEntityPosition().getPointY());


        // Test 30
        // scissors removed, should go to -1 -1
        System.out.println("\n\nTest 30:\nTesting setEntityPosition(). Scissors set to (-1,-1) when removed.");
        System.out.println(
                """
                        Expected output:
                        x=-1, y=-1
                        """);
        World world30 = new World(3, 3, 0);
        world30.map[0][0] = new Scissors(new Point(0, 0));
        IEntity deadScissors = world30.map[0][0];
        deadScissors.setEntityPosition(new Point(-1, -1));
        System.out.println("Actual output:");
        System.out.printf("x=%d, y=%d %n%n",
                deadScissors.getEntityPosition().getPointX(),
                deadScissors.getEntityPosition().getPointY());



        // Test 31 - checkNeighbors scissors center
        System.out.println("\n\nTest 31:\nTesting checkNeighbors(). Scissors at center (1,1) in 3x3.");
        System.out.println(
                """
                        Expected output:
                        Neighbor count = 9
                        """);
        World world31 = new World(3, 3, 0);
        world31.map[1][1] = new Scissors(new Point(1, 1));
        int result31 = world31.map[1][1].checkNeighbors(new Point(1, 1), world31.map).size();
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
        World world32 = new World(3, 3, 0);
        world32.map[0][0] = new Scissors(new Point(0, 0));
        int scissorsCornerNeighbors = world32.map[0][0].checkNeighbors(new Point(0, 0), world32.map).size();
        System.out.println("Actual output:");
        System.out.printf("Neighbor count = %d %n%n", scissorsCornerNeighbors);




        // Test 33 - edge should be 6
        System.out.println("\n\nTest 33:\nTesting checkNeighbors(). Scissors at edge (1,0) in 3x3.");
        System.out.println(
                """
                        Expected output:
                        Neighbor count = 6
                        """);
        World world33 = new World(3, 3, 0);
        world33.map[1][0] = new Scissors(new Point(1, 0));
        int result33 = world33.map[1][0].checkNeighbors(new Point(1, 0), world33.map).size();
        System.out.println("Actual output:");
        System.out.printf("Neighbor count = %d %n%n", result33);

        // Test 34
        // Test cleanEntitys() method. Dead Rock is removed from entityArrayList.
        System.out.println("\n\nTest 34:\nTesting cleanEntitys() method. Dead Rock is removed from entityArrayList.");
        System.out.println(
                """
                        Expected output:
                        entityArrayList size before = 2
                        entityArrayList size after = 1
                        remaining entity position: x=1, y=1
                        """);
        World world34 = new World(3, 3, 0);
        // adds one alive and dead rock
        Rock aliveRock34 = new Rock(new Point(1, 1));
        Rock deadRock34 = new Rock(new Point(-1, -1));
        world34.entityArrayList.add(aliveRock34);
        world34.entityArrayList.add(deadRock34);
        // prints actual output
        System.out.println("Actual output:");
        System.out.printf("entityArrayList size before = %d%n", world34.entityArrayList.size());
        // removes entities
        world34.cleanEntitys();
        System.out.printf("entityArrayList size after = %d%n", world34.entityArrayList.size());
        System.out.printf("remaining entity position: x=%d, y=%d %n%n",
                world34.entityArrayList.get(0).getEntityPosition().getPointX(),
                world34.entityArrayList.get(0).getEntityPosition().getPointY());


        // Test 35
        // Test cleanEntitys() method. Dead Paper and Scissors are removed from entityArrayList.
        System.out.println("\n\nTest 35:\nTesting cleanEntitys() method. Dead Paper and Scissors are removed from entityArrayList.");
        System.out.println(
                """
                        Expected output:
                        entityArrayList size before = 4
                        entityArrayList size after = 2
                        remaining paper position: x=0, y=0
                        remaining scissors position: x=2, y=2
                        """);
        World world35 = new World(3, 3, 0);
        // adds 1 alive paper and scissors, and 1 dead paper and scissors
        Paper alivePaper35 = new Paper(new Point(0, 0));
        Paper deadPaper35 = new Paper(new Point(-1, -1));
        Scissors aliveScissors35 = new Scissors(new Point(2, 2));
        Scissors deadScissors35 = new Scissors(new Point(-1, -1));
        world35.entityArrayList.add(alivePaper35);
        world35.entityArrayList.add(deadPaper35);
        world35.entityArrayList.add(aliveScissors35);
        world35.entityArrayList.add(deadScissors35);
        // actual tesrting
        System.out.println("Actual output:");
        System.out.printf("entityArrayList size before = %d%n", world35.entityArrayList.size());
        // clean entitys
        world35.cleanEntitys();
        // prints outputs
        System.out.printf("entityArrayList size after = %d%n", world35.entityArrayList.size());
        System.out.printf("remaining paper position: x=%d, y=%d%n",
                world35.entityArrayList.get(0).getEntityPosition().getPointX(),
                world35.entityArrayList.get(0).getEntityPosition().getPointY());
        System.out.printf("remaining scissors position: x=%d, y=%d %n%n",
                world35.entityArrayList.get(1).getEntityPosition().getPointX(),
                world35.entityArrayList.get(1).getEntityPosition().getPointY());


        // Test 36
        // Test cleanEntitys() method. Living entities stay in entityArrayList.
        System.out.println("\n\nTest 36:\nTesting cleanEntitys() method. Living entities stay in entityArrayList.");
        System.out.println(
                """
                        Expected output:
                        entityArrayList size before = 3
                        entityArrayList size after = 3
                        """);
        World world36 = new World(3, 3, 0);
        // adds alive rock paper scissors
        Rock aliveRock36 = new Rock(new Point(0, 0));
        Paper alivePaper36 = new Paper(new Point(1, 1));
        Scissors aliveScissors36 = new Scissors(new Point(2, 2));
        world36.entityArrayList.add(aliveRock36);
        world36.entityArrayList.add(alivePaper36);
        world36.entityArrayList.add(aliveScissors36);
        // prints actual output
        System.out.println("Actual output:");
        System.out.printf("entityArrayList size before = %d%n", world36.entityArrayList.size());
        // testing to make sure it does not remove anything alive
        world36.cleanEntitys();
        System.out.printf("entityArrayList size after = %d %n%n", world36.entityArrayList.size());


        //test 37
        //getEntityPosition for paper at 1,1
        System.out.println(("\n\nTest 37:\nTesting getEntityPosition(). Paper is placed at (1,1)."));
        System.out.println(
                """
                        Expected output:
                        x=1, y=1
                        """);
        World world37 = new World(3, 3, 0);
        world37.map[1][1] = new Paper(new Point(1, 1));
        Point paperPosition = world37.map[1][1].getEntityPosition();
        System.out.println("Actual output:");
        System.out.printf("x=%d, y=%d %n%n", paperPosition.getPointX(), paperPosition.getPointY());


        // Test 38 - same thing but corner
        System.out.println("\n\nTest 38:\nTesting getEntityPosition(). Paper placed at corner (0,0).");
        System.out.println(
                """
                        Expected output:
                        x=0, y=0
                        """);
        World world38 = new World(3, 3, 0);
        world38.map[0][0] = new Paper(new Point(0, 0));
        Point result38 = world38.map[0][0].getEntityPosition();
        System.out.println("Actual output:");
        System.out.printf("x=%d, y=%d %n%n", result38.getPointX(), result38.getPointY());


        // Test 39 - setEntityPosition
        // move paper from 1,1 to 2,2
        System.out.println("\n\nTest 39:\nTesting setEntityPosition(). Paper moved from (1,1) to (2,2).");
        System.out.println(
                """
                        Expected output:
                        x=2, y=2
                        """);
        World world39 = new World(3, 3, 0);
        world39.map[1][1] = new Paper(new Point(1, 1));
        IEntity movedPaper = world39.map[1][1];
        movedPaper.setEntityPosition(new Point(2, 2));
        System.out.println("Actual output:");
        System.out.printf("x=%d, y=%d %n%n", movedPaper.getEntityPosition().getPointX(), movedPaper.getEntityPosition().getPointY());


        // Test 40
        // what happens when paper gets removed, position should be -1,-1
        System.out.println("\n\nTest 40:\nTesting setEntityPosition(). Paper set to (-1,-1) when removed.");
        System.out.println(
                """
                        Expected output:
                        x=-1, y=-1
                        """);
        World world40 = new World(3, 3, 0);
        world40.map[0][0] = new Paper(new Point(0, 0));
        IEntity deadPaper = world40.map[0][0];
        deadPaper.setEntityPosition(new Point(-1, -1));
        System.out.println("Actual output:");
        System.out.printf("x=%d, y=%d %n%n", deadPaper.getEntityPosition().getPointX(), deadPaper.getEntityPosition().getPointY());


        // Test 41 - checkNeighbors
        // paper in the middle of 3x3 should have 9 (includes itself)
        System.out.println("\n\nTest 41:\nTesting checkNeighbors(). Paper at center (1,1) in 3x3.");
        System.out.println(
                """
                        Expected output:
                        Neighbor count = 9
                        """);
        World world41 = new World(3, 3, 0);
        world41.map[1][1] = new Paper(new Point(1, 1));
        int result41 = world41.map[1][1].checkNeighbors(new Point(1, 1), world41.map).size();
        System.out.println("Actual output:");
        System.out.printf("Neighbor count = %d %n%n", result41);


        // Test 42
        // corner should only have 4 neighbors
        System.out.println("\n\nTest 42:\nTesting checkNeighbors(). Paper at corner (0,0) in 3x3.");
        System.out.println(
                """
                        Expected output:
                        Neighbor count = 4
                        """);
        World world42 = new World(3, 3, 0);
        world42.map[0][0] = new Paper(new Point(0, 0));
        int paperCornerNeighbors = world42.map[0][0].checkNeighbors(new Point(0, 0), world42.map).size();
        System.out.println("Actual output:");
        System.out.printf("Neighbor count = %d %n%n", paperCornerNeighbors);

        // Test 43 - edge not corner so should be 6
        System.out.println("\n\nTest 43:\nTesting checkNeighbors(). Paper at edge (1,0) in 3x3.");
        System.out.println(
                """
                        Expected output:
                        Neighbor count = 6
                        """);
        World world43 = new World(3, 3, 0);
        world43.map[1][0] = new Paper(new Point(1, 0));
        int result43 = world43.map[1][0].checkNeighbors(new Point(1, 0), world43.map).size();
        System.out.println("Actual output:");
        System.out.printf("Neighbor count = %d %n%n", result43);

        // Test 44
        // Test playRound() method. Rock should beat Scissors and win.
        System.out.println("\n\nTest 44:\nTesting playRound() method. Rock should defeat Scissors and win.");
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

        World world44 = new World(2, 2, 0);

        // Create Rock and Scissors
        Rock rock44 = new Rock(new Point(0, 0));
        Scissors scissors44 = new Scissors(new Point(1, 0));

        // Add them to world[][]
        world44.map[0][0] = rock44;
        world44.map[1][0] = scissors44;

        // Add them to ArrayLists used by playRound()
        world44.entityArrayList.add(rock44);
        world44.entityArrayList.add(scissors44);

        System.out.println("Actual output:");
        world44.playRound();
        System.out.println();

    }
}