package Checkers;

import GameUtil.GameLogicListener;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.dnd.*;
import java.awt.event.ActionEvent;

//----------------------------------------------------------------------------
// File name: CheckerTile.java
// Project name: Games
// ---------------------------------------------------------------------------
// / Creator’s name and email: Anthony Ellis, ellisah@etsu.edu
// Course-Section: CSCI-1260-201
// Creation Date: 11/29/19
// Date of Last Modification: 11/29/19
// ---------------------------------------------------------------------------
/** Class Name: CheckerTile <br>
 * Class Purpose: In charge of game logic <br>
 *
 * <hr>
 * Date created: 11/29/19 <br>
 * Date last modified: 11/29/19
 * @author Anthony Ellis
 */
public class CheckerTile extends JPanel implements DropTargetListener
{
    private int tilex; //x coordinate of the tile
    private int tiley; //y coordinate of the tile

    private Coordinate coordinate; //coordinate of tile
    private Boolean valid; //boolean to check if move is valid or not
    private Checker checker; //creates new checker

    /**
     * Method Name: CheckerTile <br>
     * Method Purpose: Constructor that prepares for the creation of tiles <br>
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
     * @param color color of the tile
     * @param x x coordinate of the tile
     * @param y y coordinate of the tile
     */
    public CheckerTile(Color color, int x, int y)
    {
        super(); //calling of the super constructor
        setTileColor(color); //sets the tile color
        tilex = x; //x coordinate of the tile
        tiley = y; //y coordinate of the tile
        setBorder(new BevelBorder(1)); //sets border around the checkers to give a nicer look
        setVisible(true); //sets the visibility of checkers to true
        checker = null; //sets checker to null

    }

    /**
     * Method Name: setTileColor <br>
     * Method Purpose: Sets the tiles colors <br>
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
     * @param color color of the tile
     */
    public void setTileColor(Color color)
    {
        setBackground(color);
        if(color==Color.RED) {
            this.valid = false;
            new DropTarget(this,this);
        }
        else {
            this.valid = true;
            new DropTarget(this,this);
        }
    }

    /**
     * Method Name: setChecker <br>
     * Method Purpose: adds checker to the board <br>
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
     * @param checker sets checker position
     */
    public void setChecker(Checker checker){
        this.checker = checker; //sets a checker to itself
        checker.setPrev(checker.getCurr()); //sets the previous checker to whatever was stored in current checker
        checker.setCurr(this); //sets this checker to current checker
        add(checker); //adds checker to board
        revalidate(); //instruct LayoutManager to recalculate layout
        repaint(); //repaint components that have changed that can affect the layout
    }

    /**
     * Method Name: getChecker <br>
     * Method Purpose: simple getter than retrieves the checker <br>
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
    public Checker getChecker() {
        return checker;
    }

    /**
     * Method Name: clearTile <br>
     * Method Purpose: clears tile of the checker <br>
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
     *
     */
    public void clearTile(){
        this.valid = true; //checks if it is valid
        this.checker = null; //sets checker to null
        removeAll(); //removes all
        revalidate(); //instruct LayoutManager to recalculate layout
        repaint(); //repaint components that have changed that can affect the layout
    }

    /**
     * Method Name: drop <br>
     * Method Purpose: Handles the validation of checker movements and drops <br>
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
     * @param dtde handles dropping events of checkers
     */
    @Override
    public void drop(DropTargetDropEvent dtde) {
        Transferable transferable = dtde.getTransferable(); // Get the transfer which can provide the dropped item data
        DataFlavor[] flavors = transferable.getTransferDataFlavors(); // Get the data formats of the dropped item
        Checker dropChecker; //allows the checker to be dropped

        //tries for a checker to be dropped and returns rejected drop if invalid
        try{
            dropChecker = (Checker) transferable.getTransferData(flavors[0]);
        }
        catch (UnsupportedFlavorException unsupported){
            dtde.rejectDrop();
            return;
        }
        catch (java.io.IOException ioexception){
            System.out.println(ioexception.getLocalizedMessage());
            dtde.rejectDrop();
            return;
        }

        // if the checker is moved to a valid place drops the checker successfully, else returns false
        if(dropChecker.move(this)) {
            dtde.dropComplete(true);
            setChecker(dropChecker);
            dtde.acceptDrop(DnDConstants.ACTION_MOVE);

        }
        else{
            dtde.rejectDrop();
            dtde.dropComplete(false);
        }


    }

    /**
     * Method Name: getTileX <br>
     * Method Purpose: returns the x coordinate of the tile <br>
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
     * @return int with the tile x
     */
    public int getTileX() {
        return tilex;
    }

    public int getTileY() { return tiley; }

    /**
     * Method Name: valid <br>
     * Method Purpose: A boolean to assert whether a move is valid or invalid <br>
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
     * @return boolean validating if its invalid or valid
     */
    public boolean valid(){
        if(this.valid)
            return true;
        else
            return false;
    }

    //All of these have to be implemented but do not have to do anything
    @Override
    public void dragEnter(DropTargetDragEvent dtde) {}
    @Override
    public void dragOver(DropTargetDragEvent dtde) {}
    @Override
    public void dropActionChanged(DropTargetDragEvent dtde) {}
    @Override
    public void dragExit(DropTargetEvent dte) {
    }
}