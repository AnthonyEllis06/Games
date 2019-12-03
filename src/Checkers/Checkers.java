package Checkers;

import GameUtil.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.Serializable;
//----------------------------------------------------------------------------
// File name: Checkers.java
// Project name: Games
// ---------------------------------------------------------------------------
// / Creator’s name and email: Amber Stanifer, Alex Shepherd, Anthony Ellis, Elyssa Llavan
// Course-Section: CSCI-1260-201
// Creation Date: 11/29/19
// Date of Last Modification: 11/29/19
// ---------------------------------------------------------------------------
/** Class Name: Checkers <br>
 * Class Purpose: This class is in charge of running the game <br>
 *
 * <hr>
 * Date created: 11/29/19 <br>
 * Date last modified: 11/29/19
 * @author Amber Stanifer, Alex Shepherd, Anthony Ellis, Elyssa Llavan
 */
public class Checkers implements GameInterface, CheckerListener, Serializable {

    private CheckerTile[][] board; //creates a new checker board

    /**
     * Method Name: Checkers <br>
     * Method Purpose: Constructor that creates the board <br>
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
     */
    public Checkers() {
        board = new CheckerTile[8][8];
        makeBoard();
        setBoard();
    }

    /**
     * Method Name: makeBoard <br>
     * Method Purpose: creates the checkerboard <br>
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
     */
    private void makeBoard(){
        Color curr=Color.RED; //sets the current color usage to red

        //sets the boards colors up
        for(int x = 0; x <8; x++) {
            for (int y = 0; y < 8; y++){
                board[x][y] = new CheckerTile(curr,x,y);
                curr = getNextColor(curr);
            }
            curr= getNextColor(curr);
        }
    }

    /**
     * Method Name: setBoard <br>
     * Method Purpose: places checkers on the board <br>
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
     */
    private void setBoard(){

        boolean startFirst = false; //starting first is false
        Checker temp; //temporary checker holder
        //Puts checkers on the board
        for(int y = 0 ; y<=7; y++){
            int x =1;
            if(startFirst)
                x=0;
            for(; x<=7; x+=2){
                if(y<3){
                    temp = new Checker(board[y][x], Color.RED);
                }
                if(y>4){
                    temp= new Checker(board[y][x], Color.BLACK);
                }

            }
            startFirst = !startFirst;
        }
    }

    /**
     * Method Name: getNextColor <br>
     * Method Purpose: sets the next color of the board <br>
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
     *   @param  curr the current color of the checker going
     *   @return a color of the tile to do next
     */
    private Color getNextColor(Color curr){
        if(curr.equals(Color.RED)){
            return Color.GRAY;
        }
        else{
            return Color.RED;
        }
    }

    /**
     * Method Name: getCheckerTile <br>
     * Method Purpose: simple getter that gets the board coordinates <br>
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
     *   @param  x the x coordinate of the board
     *   @param  y the y coordinate of the board
     *   @return a CheckerTile that returns the board's coordinates
     */
    public CheckerTile getCheckerTile(int x, int y){
        return board[x][y];
    }

    //Has to be implemented but doesn't need to be used
    @Override
    public void play() {

    }

    /**
     * Method Name: getCurrPlayer <br>
     * Method Purpose: simple getter that returns the current player <br>
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
     *   @return null
     */
    @Override
    public Player getCurrPlayer() {
        return null;
    }

    //Has to be implemented but doesn't need to be used
    @Override
    public void addPlayer(Player newPlayer) {

    }

    //Has to be implemented but doesn't need to be used
    @Override
    public void nextPlayerTurn() {

    }

    /**
     * Method Name: gameWon <br>
     * Method Purpose: uses a boolean to tell if the game has been won or not <br>
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
     * @return null
     */
    @Override
    public Boolean gameWon() {
        return null;
    }

    /**
     * Method Name: getNumPlayers <br>
     * Method Purpose: getter that returns number of players in game <br>
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
     *   @return number of players
     */
    @Override
    public int getNumPlayers() {
        return 0;
    }

    /**
     * Method Name: gameOver <br>
     * Method Purpose: uses a boolean to tell if the game is over <br>
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
     *   @return false if game isn't over yet
     */
    @Override
    public Boolean gameOver() {
        return false;
    }

    /**
     * Method Name: move <br>
     * Method Purpose: allows checker to move <br>
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
     *   @return true for move to be completed
     */
    @Override
    public boolean move(Checker checker, CheckerTile start, CheckerTile finish) {
    return true;
    }

    /**
     * Method Name: gameOver <br>
     * Method Purpose: uses a boolean to tell if the game is over <br>
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
     *   @return false if game isn't over yet
     */
    @Override
    public boolean jump(Checker checker, CheckerTile start, CheckerTile finish) {
        return false;
    }


    //Has to be implemented but doesn't need to be used
    @Override
    public void CallCommand() {

    }
}
