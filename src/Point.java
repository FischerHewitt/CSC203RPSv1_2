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

public class Point {
    private int x;
    private int y;

    // Purpose: creates a point object
    // Input: int, int
    // Result: point object
    Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    // Purpose: get the x value of a point
    // Input: null
    // Result: returns an integer of the x vale
    // output: int
    public int getPointX(){
        return this.x;
    }
    // Purpose: get the y value of a point
    // Input: null
    // Result: returns an integer of the y vale
    // output: int
    public int getPointY(){
        return this.y;
    }

    // Purpose: get the Point object
    // Input: null
    // Result: returns a Point
    // output: Point

    public Point getPoint(){
        return this;
    }

}
