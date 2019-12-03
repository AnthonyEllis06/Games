//----------------------------------------------------------------------------
// File name: GameInterface.java
// Project name: Games
// ---------------------------------------------------------------------------
// / Creator’s name and email: Anthony Ellis, ellisah@etsu.edu
// Course-Section: CSCI 1260 - 201
// Creation Date: 12/01/2019
// Date of Last Modification: 12/01/2019
// ---------------------------------------------------------------------------
package GameUtil;

/** Interface Name: GameInterface <br>
 * Interface Purpose: To make the games run similar and smooth by having a play method where all the other abstract methods are called. <br>
 *
 * <hr>
 * Date created: 12/01/2019 <br>
 * Date last modified: 12/01/2019
 * @author Anthony Ellis
 */
public interface GameInterface extends GameLogicListener{

    /**
     * Method Name: play <br>
     * Method Purpose: The idea is to have the play method in this game interface make the games all run similar and smooth.
     *              It works by continuously making players take turns.
     *              Needs notify to be used to allow players for use strats <br>
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
     */
    default void play(){
        int numPlayers = getNumPlayers(); //gets the number of players allowed to play the game
        Player curr = getCurrPlayer(); //gets the current player and assign it to Play curr variable
        for (int i = 0; i<numPlayers;i++){
            if(curr!= null){
                addPlayer(curr); //adds the curr as the plauer of the game. This will loop until the total number of players are added on the game.
            }
        }
        while(!gameOver()){ //while the game is not over, the players will take each turn until someone meets the winning conditions
            for(int i = 0;i<numPlayers;i++)
                nextPlayerTurn();
            gameWon();
        }
        gameOver(); //if the winning conditions are met, the game is over.
    } //end play

    /**
     * Method Name: getCurrPlayer <br>
     * Method Purpose: Returns current player. <br>
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
     *
     */
    Player getCurrPlayer(); //end getCurrPlayer
    /**
     * Method Name: addPLayer <br>
     * Method Purpose: Used in play to add player <br>
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
     * @param newPlayer the new player of the game
     */
    void addPlayer(Player newPlayer); //end addPlayer

    /**
     * Method Name: nextPlayerTurn <br>
     * Method Purpose: Sets the turn for the next player <br>
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
     */
    void nextPlayerTurn(); //end nextPlayerTurn

    /**
     * Method Name: gameWon <br>
     * Method Purpose: Checks if game is won in win condition. <br>
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
     */
    Boolean gameWon();

    /**
     * Method Name: getNumPlayers <br>
     * Method Purpose: Returns the total amount of players <br>
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
     */
    int getNumPlayers(); //end getNumPlayers

    /**
     * Method Name: gameOver <br>
     * Method Purpose: Used to see if game is over and also where you can do calls for a custom game over <br>
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
     */
    Boolean gameOver(); //end gameOver
}
