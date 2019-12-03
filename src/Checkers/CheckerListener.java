package Checkers;
//----------------------------------------------------------------------------
// File name: CheckerListener.java
// Project name: Games
// ---------------------------------------------------------------------------
// / Creator’s name and email: Anthony Ellis, ellisah@etsu.edu
// Course-Section: CSCI-1260-201
// Creation Date: 11/29/19
// Date of Last Modification: 11/29/19
// ---------------------------------------------------------------------------
/** Class Name: CheckerListener <br>
 * Class Purpose: An interface that has a move method and jump method for the checkers <br>
 *
 * <hr>
 * Date created: 11/29/19 <br>
 * Date last modified: 11/29/19
 * @author Anthony Ellis
 */
public interface CheckerListener {

    /**
     * Method Name: move <br>
     * Method Purpose: interface method that is to be used in another class to define it's logic for moving a checker<br>
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
     * @param checker the checker being used
     * @param start the starting point of the checker
     * @param finish the finishing point of the checker
     */
    public boolean move(Checker checker, CheckerTile start, CheckerTile finish);

    /**
     * Method Name: jump <br>
     * Method Purpose: interface method that is to be used in another class to define it's logic for jumping a checker<br>
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
     * @param checker the checker being used
     * @param start the starting point of the checker
     * @param finish the finishing point of the checker
     */
    public boolean jump(Checker checker, CheckerTile start, CheckerTile finish);
}
