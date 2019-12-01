//----------------------------------------------------------------------------
// File name: TicTacToeGui.java
// Project name: Games
// ---------------------------------------------------------------------------
// / Creator’s name and email:
// Course-Section:CSCI 1260 - 201
// Creation Date: 11/29/2019
// Date of Last Modification: 11/29/2019
// ---------------------------------------------------------------------------
package TicTacToe;

import GameUtil.AbstractGameGui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/** Class Name: TicTacToeGui <br>
 * Class Purpose: This is a child class of AbstractGameGui that builds the GUI for the TicTacToe Game. <br>
 *
 * <hr>
 * Date created: 11/29/2019 <br>
 * Date last modified: 11/29/2019
 * @author student’s name here
 */
public class TicTacToeGui extends AbstractGameGui {
    private final int WIDTH = 500; //constant width of the JFrame
    private final int HEIGHT = 500; //constant height of the JFrame
    private JLabel currPlayerLabel; //current player's label

    /**
     * Method Name: TicTacToeGui <br>
     * Method Purpose: Construction of the TicTacToeGui. This sets the default value of the fields in the class. <br>
     *
     * <hr>
     * Date created: 11/29/2019 <br>
     * Date last modified: 11/29/2019<br>
     *
     * <hr>
     * Notes on specifications, special algorithms, and assumptions:
     *   notes go here
     *
     * <hr>
     *   @param  parent JFrame parent that will be used to call the super class constructor
     */
    public TicTacToeGui(JFrame parent) {
        super(parent,new TicTacToe()); //using the super keyword means they are referring to the parent variable of the super class
        addPlayers(); //calls addPLayers() to add players to the game.
        currPlayerLabel = new JLabel(getGame().getCurrPlayer().getName()+"'s turn"); //prints who's turn it is
        parent.getJMenuBar().add(currPlayerLabel); //adds the label of the current player
        revalidate(); //instruct LayoutManager to recalculate layout
        repaint(); //repaint components that have changed that can affect the layout

    } //end TicTacToeGui

    /**
     * Method Name: getGameWidth <br>
     * Method Purpose: Returns the width of the JFrame. <br>
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
     *   @return WIDTH the width of the JFrame.

     */
    @Override
    protected int getGameWidth() {
        return WIDTH;
    } //end getGameWidth

    /**
     * Method Name: getGameHeight <br>
     * Method Purpose: Returns the height of the JFrame. <br>
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
     *   @return HEIGHT the height of the JFrame
     */
    @Override
    protected int getGameHeight() {
        return HEIGHT;
    } //end getHeight

    /**
     * Method Name: setUp <br>
     * Method Purpose: This method sets each tile to form the TicTacToe board. <br>
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
    protected void setUp() {
        setLayout(new GridLayout(3,3)); //sets a grid layout that has 3 rows and3 columns
        TicTacToeTile tile; //declare tile
        for(int i = 0; i<9; i++){  //keep looping until i is greater than 9
            tile = new TicTacToeTile(i); //declare a new tile
            add(tile); //add the tile to the
            tile.addMouseListener(new PanelMouseAdapter()); //register an instance to event handler as listener
        } //end for loop

    } //end setUp

    /** Class Name: PanelMouseAdapter <br>
     * Class Purpose: An inner class that inherits from MouseAdapter. This class <br>
     *
     * <hr>
     * Date created: 11/29/2019 <br>
     * Date last modified: 11/29/2019
     * @author student’s name here
     */
    private class PanelMouseAdapter extends MouseAdapter {
        /**
         * Method Name: mousePressed <br>
         * Method Purpose: This method puts all the components of the game and make it run. This is where the game will loop until someone
         *                  wins the game.<br>
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
         *   @param  e the MouseEvent object
         */
        public void mousePressed(MouseEvent e){
            TicTacToe temp = (TicTacToe) getGame();
            if(!temp.gameWon()) {
                TicTacToeTile tile = (TicTacToeTile)e.getSource(); //get which tile was pressed
                tile.setText(temp.getCurrPlayerText()); //set the text of the current player to the pressed tile
                temp.setBoardSpot(tile.getPosition(),temp.getCurrPlayerText()); //set the board spot passing the position of the tile pressed and the current player text
                if(!temp.gameWon()) {
                    //temp.seeBoard();
                    temp.nextPlayerTurn(); //if the no one has won yet, set the next player
                    currPlayerLabel.setText(temp.getCurrPlayer().getName() + "'s Turn"); //display a label stating who's player's turn it is
                } //end if
                else{
                    currPlayerLabel.setText(temp.getCurrPlayer().getName()+" Has Won"); //if the current player has won the game, display a label stating the player has won
                } //end else
            } //end if
            else{
                currPlayerLabel.setText(temp.getCurrPlayer().getName()+" Has Won"); //if the current player has won the game, display a label stating the player has won
            } //end else

        } //end mousePressed(MouseEvent e)
    } // end PanelMouseAdapter


}

