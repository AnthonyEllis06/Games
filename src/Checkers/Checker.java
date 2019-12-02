package Checkers;import javax.swing.*;import java.awt.*;import java.awt.datatransfer.DataFlavor;import java.awt.datatransfer.Transferable;import java.awt.datatransfer.UnsupportedFlavorException;import java.awt.dnd.*;import java.io.IOException;//----------------------------------------------------------------------------// File name: Checker.java// Project name: Games// ---------------------------------------------------------------------------// / Creator’s name and email: Amber Stanifer, Alex Shepherd, Anthony Ellis, Elyssa Llavan// Course-Section: CSCI-1260-201// Creation Date: 11/29/19// Date of Last Modification: 11/29/19// ---------------------------------------------------------------------------/** Class Name: Checker <br> * Class Purpose: In charge of moving game logic <br> * * <hr> * Date created: 11/29/19 <br> * Date last modified: 11/29/19 * @author Amber Stanifer, Alex Shepherd, Anthony Ellis, Elyssa Llavan */public class Checker extends JLabel implements DragGestureListener, DragSourceListener{    CheckerTransferable transferable; //if the checker is transferable or not    CheckerTile curr; //current checker in  use    CheckerTile prev; //previous checker used    CheckerListener checkerListener; //listens    private boolean black; //used in setting the color of checkers on the board    Checker checker;    public Checker(CheckerTile tile, Color color) {        super();//Image m = new BufferedImage();        DragSource.getDefaultDragSource().createDefaultDragGestureRecognizer(this, DnDConstants.ACTION_MOVE,this); //allows a checker to be dragged        ImageIcon RedCheckerImage = null; //sets image to null        ImageIcon BlackCheckerImage = null; //sets image to null        //sets a universal path so that any user that accesses this can see the checkers automatically, sets color of checkers using images of checkers of said color        if (color == Color.RED) {            RedCheckerImage = new ImageIcon(getClass().getResource("/GameUtil/Images/RedChecker.png"));            black = false;            setIcon(RedCheckerImage);        } else {            BlackCheckerImage = new ImageIcon(getClass().getResource("/GameUtil/Images/BlackChecker.png"));            black = true;            setIcon(BlackCheckerImage);        }        curr = tile; //sets tile to current        prev = curr; //sets current tile to previous        tile.setChecker(this); //sets checker    }    public Checker(CheckerPieces kingBlackChecker) {    }    /**     * Method Name: setCheckerListener <br>     * Method Purpose: Listens for a checker to be moved or jumped<br>     *     * <hr>     * Date created: 11/29/19 <br>     * Date last modified: 11/29/19 <br>     *     * <hr>     * Notes on specifications, special algorithms, and assumptions:     *   notes go here     *     * <hr>     * @param checkerListener listens for a checker to be jumped or move     */    public void setCheckerListener(CheckerListener checkerListener){        this.checkerListener = checkerListener;    }    //The plan is to move everything in this into the Checkers move method and call it via the listener    // also make a jump method that will call checkers jump method method    /**     * Method Name: move <br>     * Method Purpose: allows a checker to move a space <br>     *     * <hr>     * Date created: 11/29/19 <br>     * Date last modified: 11/29/19 <br>     *     * <hr>     * Notes on specifications, special algorithms, and assumptions:     *   notes go here     *     * <hr>     * @param tileFinish the tile the move finishes on     */    public boolean move(CheckerTile tileFinish){        //checkerListener.move(this, this.curr, tileFinish);        int start = curr.getTileX(); //starting tile of the checker        int finish = tileFinish.getTileX(); //finishing tile of the checker        int vert = finish-start ; //subtracts the coordinates of the finish and starting points of the checker        //if the finish is not valid return false and if its null also return false, if the vert different is equal to -1 return true        if(!tileFinish.valid())            return false;        else if(tileFinish.getChecker()!=null)            return false;        else if(vert>1||vert<-1)            return false;        else{            if(black){                if(vert == -1)                    return true;                else                    return false;            }            else{                if(vert==1)                    return true;                else                    return false;            }        }    }    /**     * Method Name: jump <br>     * Method Purpose: allows for a checker to be jumped and taken off the board<br>     *     * <hr>     * Date created: 11/29/19 <br>     * Date last modified: 11/29/19 <br>     *     * <hr>     * Notes on specifications, special algorithms, and assumptions:     *   notes go here     *     * <hr>     * @return false     */    public boolean jump(CheckerTile tileFinish){        int start = curr.getTileX(); //gets starting point of the checker        int finish = tileFinish.getTileX(); //gets ending point of the checker        int vert = finish-start ; // subtracts the coordinates of the finish and start        this.checker = null; //sets checker to null        removeAll(); //removes all        if(!tileFinish.valid())            return false;        else if(tileFinish.getChecker()!=null)            return false;        else if(vert > 2||vert <-2)            return false;        else{            if(black){                if(vert == -2)                    return true;                else                    return false;            }            else{                if(vert== 2)                    return true;                else                    return false;            }        }    }    /**     * Method Name: setCurr <br>     * Method Purpose: sets current checker tile<br>     *     * <hr>     * Date created: 11/29/19 <br>     * Date last modified: 11/29/19 <br>     *     * <hr>     * Notes on specifications, special algorithms, and assumptions:     *   notes go here     *     * <hr>     * @param curr current checker tile     */    public void setCurr(CheckerTile curr) {        this.curr = curr;    }    /**     * Method Name: setPrev <br>     * Method Purpose: sets previous checker tile<br>     *     * <hr>     * Date created: 11/29/19 <br>     * Date last modified: 11/29/19 <br>     *     * <hr>     * Notes on specifications, special algorithms, and assumptions:     *   notes go here     *     * <hr>     * @param prev previous checker tile     */    public void setPrev(CheckerTile prev){        this.prev= curr;    }    /**     * Method Name: getCurr <br>     * Method Purpose: gets the current checker tile and returns it<br>     *     * <hr>     * Date created: 11/29/19 <br>     * Date last modified: 11/29/19 <br>     *     * <hr>     * Notes on specifications, special algorithms, and assumptions:     *   notes go here     *     * <hr>     * @return current checker tile     */    public CheckerTile getCurr() {        return curr;    }    /**     * Method Name: getPrev <br>     * Method Purpose: gets the previous checker tile and returns it<br>     *     * <hr>     * Date created: 11/29/19 <br>     * Date last modified: 11/29/19 <br>     *     * <hr>     * Notes on specifications, special algorithms, and assumptions:     *   notes go here     *     * <hr>     * @return previous checker tile     */    public CheckerTile getPrev() {        return prev;    }    /**     * Method Name: dragGestureRecognized <br>     * Method Purpose: allow the checker to be moved <br>     *     * <hr>     * Date created: 11/29/19 <br>     * Date last modified: 11/29/19 <br>     *     * <hr>     * Notes on specifications, special algorithms, and assumptions:     *   notes go here     *     * <hr>     * @param dge a drag gesture     */    @Override    public void dragGestureRecognized(DragGestureEvent dge) {        CheckerTransferable transferable = new CheckerTransferable(this);        DragSource ds = dge.getDragSource();        ds.startDrag(dge,DragSource.DefaultMoveDrop,transferable,this);    }    //All these methods had to be implemented but are not necessary to be used    @Override    public void dragEnter(DragSourceDragEvent dragSourceDragEvent) {    }    @Override    public void dragOver(DragSourceDragEvent dragSourceDragEvent) {    }    @Override    public void dropActionChanged(DragSourceDragEvent dragSourceDragEvent) {    }    @Override    public void dragExit(DragSourceEvent dragSourceEvent) {    }    /**     * Method Name: dragDropEnd <br>     * Method Purpose: if the checker moves successfully clear the current tile<br>     *     * <hr>     * Date created: 11/29/19 <br>     * Date last modified: 11/29/19 <br>     *     * <hr>     * Notes on specifications, special algorithms, and assumptions:     *   notes go here     *     * <hr>     * @param dragSourceDropEvent a dragged item     */    @Override    public void dragDropEnd(DragSourceDropEvent dragSourceDropEvent) {        if(dragSourceDropEvent.getDropSuccess() == true){            curr.clearTile();        }    }}