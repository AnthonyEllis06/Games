package Checkers;
//----------------------------------------------------------------------------
// File name: Coordinate.java
// Project name: Games
// ---------------------------------------------------------------------------
// / Creator’s name and email:
// Course-Section: CSCI-1260-201
// Creation Date: 11/29/19
// Date of Last Modification: 11/29/19
// ---------------------------------------------------------------------------
/** Class Name: Coordinate <br>
 * Class Purpose: Gets the coordinate of the checker's location <br>
 *
 * <hr>
 * Date created: 11/29/19 <br>
 * Date last modified: 11/29/19
 * @author
 */
public class Coordinate {

    private int x; //x coordinate of the checker
    private int y; //y coordinate of the checker

    /**
     * Method Name: Coordinate  <br>
     * Method Purpose: sets the default coordinates for checkers <br>
     *
     * <hr>
     * Date created: 11/29/19 <br>
     * Date last modified: 11/29/19 <br>
     *
     * <hr>
     * Notes on specifications, special algorithms, and assumptions:
     *   notes go here
     *
     * <hr>
     *   @param  x the x coordinate of the checker
     *   @param  y the y coordinate of the checker
     */
    public Coordinate(int x, int y){
        this.x = x;
        this.y = y;
    }

    /**
     * Method Name: getX <br>
     * Method Purpose: get the x coordinate of the checker <br>
     *
     * <hr>
     * Date created: 11/29/19 <br>
     * Date last modified: 11/29/19 <br>
     *
     * <hr>
     * Notes on specifications, special algorithms, and assumptions:
     *   notes go here
     *
     * <hr>
     *   @return an int that contains the x coordinate of the checker
     */
    public int getX(){
        return x;
    }

    /**
     * Method Name: getY <br>
     * Method Purpose: get the y coordinate of the checkers <br>
     *
     * <hr>
     * Date created: 11/29/19 <br>
     * Date last modified: 11/29/19 <br>
     *
     * <hr>
     * Notes on specifications, special algorithms, and assumptions:
     *   notes go here
     *
     * <hr>
     *   @return an int containing the y coordinate of the checker
     */
    public int getY(){
        return y;
    }

    /**
     * Method Name: getCoordinate <br>
     * Method Purpose: get the coordinates of both x and y and return it <br>
     *
     * <hr>
     * Date created: 11/29/19 <br>
     * Date last modified: 11/29/19 <br>
     *
     * <hr>
     * Notes on specifications, special algorithms, and assumptions:
     *   notes go here
     *
     * <hr>
     *   @return an int containing the x and y coordinates of the checker
     */
    public int[] getCoordinates(){
        return new int[]{x,y};
    }

    /**
     * Method Name: compareCoordinates <br>
     * Method Purpose: finds the difference between the coordinates <br>
     *
     * <hr>
     * Date created: 11/29/19 <br>
     * Date last modified: 11/29/19 <br>
     *
     * <hr>
     * Notes on specifications, special algorithms, and assumptions:
     *   notes go here
     *
     * <hr>
     * @param c1 coordinate 1 to compare
     * @param c2 coordinate 2 to compare
     * @return an int 0
     */
    public static int CompareCoordinates(Coordinate c1, Coordinate c2){
        int vertDifference = c1.getY()-c2.getY(); //subtracts coordinate 2 from coordinate 1

        //if the difference is less than 1 or greater than -1 return a 0 else return the difference
        if(vertDifference > 1 || vertDifference < -1)
            return 0;
        else
            return vertDifference;
    }
}
