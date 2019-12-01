//----------------------------------------------------------------------------
// File name: TicTacToe.java
// Project name: Games
// ---------------------------------------------------------------------------
// / Creator’s name and email:
// Course-Section: CSCI 1260 - 201
// Creation Date: 11/29/2019
// Date of Last Modification: 11/29/2019
// ---------------------------------------------------------------------------
package TicTacToe;

import GameUtil.*;

import java.awt.event.ActionEvent;
import java.util.ArrayList;

/** Class Name: TicTacToe <br>
 * Class Purpose: This class holds the components needed to build the TicTacToe game. Such as building the board, the players,
 *                  changing players turn and checking if a player has one the game. <br>
 *
 * <hr>
 * Date created: 11/29/2019 <br>
 * Date last modified: 11/29/2019
 * @author student’s name here
 */
public class TicTacToe implements GameInterface {
    private Player x; //player for x
    private Player o; //player for o
    private Player curr; //current player
    private String[] board; //board for TicTacToe
    private boolean gameWon; //boolean to know if someone won the game
    private ArrayList<String[]> winConditions = new ArrayList<>(); //ArrayList of win conditions for TicTacToe
    private int[] winSpots; //array of win spots of the game

    /**
     * Method Name: TicTacToe <br>
     * Method Purpose: Constructor of the TicTacToe class. This sets the default value of the declared variables. <br>
     *
     * <hr>
     * Date created: 11/29/2019 <br>
     * Date last modified: 11/29/2019 <br>
     *
     * <hr>
     * Notes on specifications, special algorithms, and assumptions:
     *   notes go here
     *
     * <hr>
     */
    public TicTacToe() {
        x = null; //set player x to null
        o = null; //set player o to null
        curr = x; //set player x as the current player
        String empty = " ";
        gameWon = false; //set gameWon to false before the game starts
        board = new String[9]; //initialize an array of String with the size of 9
        for(int i = 0;i<9;i++){
            board[i] =empty; //creates an empty TicTacToe board with 9 tiles/buttons
        }
    } //end TicTacToe()


    /**
     * Method Name: setBoardSpot <br>
     * Method Purpose: This sets the spots for TicTacToe board <br>
     *
     * <hr>
     * Date created: 11/29/2019 <br>
     * Date last modified: 11/29/2019 <br>
     *
     * <hr>
     * Notes on specifications, special algorithms, and assumptions:
     *   notes go here
     *
     * <hr>
     *   @param  index of each spots
     *   @param  set set of spots
     */
    public void setBoardSpot(int index, String set){
        board[index]=set;
        for(int i =1; i<=9;i++){System.out.println();}
    } //end setBoardSpot(int index, String set)
    /**
     * Method Name: seeBoard <br>
     * Method Purpose: This prints the board of the TicTacToe <br>
     *
     * <hr>
     * Date created: 11/29/2019 <br>
     * Date last modified: 11/29/2019 <br>
     *
     * <hr>
     * Notes on specifications, special algorithms, and assumptions:
     *   notes go here
     *
     * <hr>
     */
    public void seeBoard(){
        System.out.println(board[0]+" "+board[1]+" "+board[2]); //prints boards(tiles) 1-3
        System.out.println(board[3]+" "+board[4]+" "+board[5]); //prints boards(tiles) 4-6
        System.out.println(board[6]+" "+board[7]+" "+board[8]); //prints boards(tiles) 7-9
    } //end seeBoard

    /**
     * Method Name: getCurrPLayer <br>
     * Method Purpose: Returns the current player. <br>
     *
     * <hr>
     * Date created: 11/29/2019 <br>
     * Date last modified: 11/29/2019 <br>
     *
     * <hr>
     * Notes on specifications, special algorithms, and assumptions:
     *   notes go here
     *
     * <hr>
     *   @return curr the current player.
     */
    @Override
    public Player getCurrPlayer() {
        return curr;
    } //end getCurrPlayer()

    /**
     * Method Name: addPlayer <br>
     * Method Purpose: Adds new player to the game. <br>
     *
     * <hr>
     * Date created: 11/29/2019 <br>
     * Date last modified: 11/29/2019 <br>
     *
     * <hr>
     * Notes on specifications, special algorithms, and assumptions:
     *   notes go here
     *
     * <hr>
     *   @param  newPlayer the new player
     */
    @Override
    public void addPlayer(Player newPlayer) {
        if(x == null)
            x= newPlayer; // if x is equal to null, set x as the newPlayer
        else
            o=newPlayer; // if the if condition is false, set o as the newPlayer
        curr=o; //set curr to o

    } //end addPlayer(Player newPlayer)

    /**
     * Method Name: getCurrPlayerText <br>
     * Method Purpose: Gets the current player text that will be printed on the TicTacToe board. <br>
     *
     * <hr>
     * Date created: 11/29/2019 <br>
     * Date last modified: 11/29/2019 <br>
     *
     * <hr>
     * Notes on specifications, special algorithms, and assumptions:
     *   notes go here
     *
     * <hr>
     *   @return currText the "X" or "O" that will be printed on the TicTacToe board
     */
    String getCurrPlayerText(){
        String currText = " ";
        if(curr == x) {
            currText= "X"; //if curr is equal to x, set currText to "X"
        } //end if
        else{
            currText=  "O"; //if the if condition is false, set currText to "O"
        } //end else
        return currText;
    } //end getCurrPlayerText()


    /**
     * Method Name: nexPlayerTurn <br>
     * Method Purpose: Assigns the next player to have his turn. <br>
     *
     * <hr>
     * Date created: 11/29/2019 <br>
     * Date last modified: 11/29/2019 <br>
     *
     * <hr>
     * Notes on specifications, special algorithms, and assumptions:
     *   notes go here
     *
     * <hr>
     */
    @Override
    public void nextPlayerTurn() {
        if(curr==x)
            curr = o; //if curr(current player) is equal to x, set curr to o
        else
            curr = x; //if the if condition is false, set curr to x.
    } //end nextPlayerTurn()


    /**
     * Method Name: gameWon <br>
     * Method Purpose: This method is responsible for checking if a player has won the game. It will each possible winning conditions. <br>
     *
     * <hr>
     * Date created: 11/29/2019 <br>
     * Date last modified: 11/29/2019 <br>
     *
     * <hr>
     * Notes on specifications, special algorithms, and assumptions:
     *   notes go here
     *
     * <hr>
     *   @return boolean showing that the game has been won.
     */
    @Override
    public Boolean gameWon() {
        if(gameWon==false){
            String possibleWins[]=new String[8]; //declare an array of possibleWins with a size of 8
            //check rows
            possibleWins[0] = board[0]+board[1]+board[2];
            possibleWins[1] = board[3]+board[4]+board[5];
            possibleWins[2]= board[6]+board[7]+board[8];
            //check columns
            possibleWins[3] = board[0]+board[3]+board[6];
            possibleWins[4] = board[1]+board[4]+board[7];
            possibleWins[5] = board[2]+board[5]+board[8];
            //check diagonals
            possibleWins[6] = board[0]+board[4]+board[8];
            possibleWins[7] = board[2]+board[4]+board[6];

            for(int i = 0; i<8;i++) {
                //System.out.println(possibleWins[i] + i);
                if (possibleWins[i].equals("XXX")) { //if any of the possibleWins shows an output equals to "XXX"
                    gameWon= true; //change the gameWon to true
                    return true;
                } //end if
                else if (possibleWins[i].equals("OOO")) { //if any of the possibleWins shows an output equals to "OOO"
                    gameWon=true; //change gameWon to true
                    return true;
                } //end else if
            } //end for loop
            return false; //if not of the statements above is true, return false and keep looping
        } //end if
        return true; //returns true if a player has won the game
    } //end gameWon


    /**
     * Method Name: getNumPlayers <br>
     * Method Purpose: Returns the number of players allowed to play the game. Here only 2 was returned because only
     *                  2 players can play TicTacToe.
     * <br>
     *
     * <hr>
     * Date created: 11/29/2019 <br>
     * Date last modified: 11/29/2019 <br>
     *
     * <hr>
     * Notes on specifications, special algorithms, and assumptions:
     *   notes go here
     *
     * <hr>
     *   @return number of players allowed to play the game.
     */
    @Override
    public int getNumPlayers() {
        return 2;
    } //end gameNumPlayers



    /**
     * Method Name: gameOver <br>
     * Method Purpose: Responsible for tracking if the game is over. However, in this case, the game will only be over if one
     *                  of the players won the game.<br>
     *
     * <hr>
     * Date created: 11/29/2019 <br>
     * Date last modified: 11/29/2019 <br>
     *
     * <hr>
     * Notes on specifications, special algorithms, and assumptions:
     *   notes go here
     *
     * <hr>
     *   @return a boolean - which is set to false because the game will not be over unless someone wins the game.
     */
    @Override
    public Boolean gameOver() {
        return false;
    } //end gameOver

    /**
     * Method Name: CallCommand <br>
     * Method Purpose: This method was implemented because it's a method of GameLogicListener(an interface) where GameInterface inherits from.  <br>
     *
     * <hr>
     * Date created: 11/29/2019 <br>
     * Date last modified: 11/29/2019 <br>
     *
     * <hr>
     * Notes on specifications, special algorithms, and assumptions:
     *   notes go here
     *
     * <hr>
     *
     */
    @Override
    public void CallCommand() {

    }//end CallCommand()
}

