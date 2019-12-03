//----------------------------------------------------------------------------
// File name: Player.java
// Project name: Games
// ---------------------------------------------------------------------------
// / Creator’s name and email: Anthony Ellis, ellisah@etsu.edu
// Course-Section: CSCI 1260 - 201
// Creation Date: 12/01/2019
// Date of Last Modification: 12/01/2019
package GameUtil;

/** Class Name: Player <br>
 * Class Purpose: This class holds all the attributes a player of a game has. <br>
 *
 * <hr>
 * Date created: 12/01/2019 <br>
 * Date last modified: 12/01/2019
 * @author Anthony Ellis
 */
public class Player {
    private String name; //name of the player
    private int score; //score of the player

    /**
     * Method Name: Player <br>
     * Method Purpose: Constructor of the Player class. This class sets the default values for the fields of the class. <br>
     *
     * <hr>
     * Date created: 12/01/2019 <br>
     * Date last modified: 12/01/2019 <br>
     *
     * <hr>
     * Notes on specifications, special algorithms, and assumptions:
     *   notes go here
     *
     * <hr>
     * @param name the name of the player
     */
    public Player(String name) {
        this.name = name; //class variable name set to the name variable that was passed as parameter.
        score = 0; //score set to 0
    } //end Player

    /**
     * Method Name:getName <br>
     * Method Purpose: Returns the name of the player. <br>
     *
     * <hr>
     * Date created: 12/01/2019 <br>
     * Date last modified: 12/01/2019 <br>
     *
     * <hr>
     * Notes on specifications, special algorithms, and assumptions:
     *   notes go here
     *
     * <hr>
     * @return name the name of the player
     */
    public String getName(){
        return name;
    } //end getName

    /**
     * Method Name: setName <br>
     * Method Purpose: Sets the name of the player. <br>
     *
     * <hr>
     * Date created: 12/01/2019 <br>
     * Date last modified: 12/01/2019 <br>
     *
     * <hr>
     * Notes on specifications, special algorithms, and assumptions:
     *   notes go here
     *
     * <hr>
     * @param name the name of the player
     */
    public void setName(String name) {
        this.name = name;
    } //end setName(String name)

    /**
     * Method Name: getScore <br>
     * Method Purpose: Returns the score. <br>
     *
     * <hr>
     * Date created: 12/01/2019 <br>
     * Date last modified: 12/01/2019 <br>
     *
     * <hr>
     * Notes on specifications, special algorithms, and assumptions:
     *   notes go here
     *
     * <hr>
     * @return score the score of the player
     */
    public int getScore() {
        return score;
    } //end score

    /**
     * Method Name: setScore <br>
     * Method Purpose: Sets the score. <br>
     *
     * <hr>
     * Date created: 12/01/2019 <br>
     * Date last modified: 12/01/2019 <br>
     *
     * <hr>
     * Notes on specifications, special algorithms, and assumptions:
     *   notes go here
     *
     * <hr>
     * @param score the score of the player
     */
    public void setScore(int score) {
        this.score = score;
    } //end getScore(int score)
}

