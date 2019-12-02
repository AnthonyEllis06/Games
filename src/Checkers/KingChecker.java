package Checkers;

import javax.swing.*;
import java.awt.*;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DragGestureEvent;
import java.awt.dnd.DragSource;
//----------------------------------------------------------------------------
// File name: KingChecker.java
// Project name: Games
// ---------------------------------------------------------------------------
// / Creator’s name and email: Amber Stanifer, stanifera@etsu.edu
// Course-Section: CSCI-1260-201
// Creation Date: 11/29/19
// Date of Last Modification: 11/29/19
// ---------------------------------------------------------------------------
/** Class Name: KingChecker <br>
 * Class Purpose: To turn a checker into a king checker <br>
 *
 * <hr>
 * Date created: 11/29/19 <br>
 * Date last modified: 11/29/19
 * @author Amber Stanifer
 */
public class KingChecker extends Checker {
    CheckerTile tileFinish;
    CheckerTile curr;
    boolean king = false;
    private boolean black; //used in setting the color of checkers on the board
    /**
     * Method Name: KingChecker <br>
     * Method Purpose: Constructor that calls the super tile <br>
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
    public KingChecker(CheckerTile tile, Color color) {
        super(tile, color);
        DragSource.getDefaultDragSource().createDefaultDragGestureRecognizer(this, DnDConstants.ACTION_MOVE,this); //allows a checker to be dragged

        ImageIcon KingRedCheckerImage = null; //sets image to null
        ImageIcon KingBlackCheckerImage = null; //sets image to null

        //sets a universal path so that any user that accesses this can see the checkers automatically, sets color of checkers using images of checkers of said color
        if (color == Color.RED) {
            KingRedCheckerImage = new ImageIcon(getClass().getResource("/GameUtil/Images/RedChecker.png"));
            black = false;
            setIcon(KingRedCheckerImage);
        } else {
            KingBlackCheckerImage = new ImageIcon(getClass().getResource("/GameUtil/Images/BlackChecker.png"));
            black = true;
            setIcon(KingBlackCheckerImage);
        }
        curr = tile; //sets tile to current
        prev = curr; //sets current tile to previous
        tile.setChecker(this); //sets checker

    }

    public boolean setKingChecker() {
        if(curr.getTileY() == 0)
            new Checker(CheckerPieces.KING_BLACK_CHECKER);
        else if(curr.getTileY() == 7)
            new Checker(CheckerPieces.KING_RED_CHECKER);

        return true;
    }

    public boolean moveChecker(int x, int y){
        int start = curr.getTileX(); //starting tile of the checker
        int finish = tileFinish.getTileX(); //finishing tile of the checker
        int vert = finish-start ; //subtracts the coordinates of the finish and starting points of the checker

        //allows a king checker to be moved backwards and forwards
        if(!tileFinish.valid())
            return false;
        else if(setKingChecker() == true)
            return false;
        else if(vert > 1 && vert < -1)
            return false;
        else{
            if(setKingChecker() == true){
                if(vert > -1 || vert < 1)
                    return true;
                else
                    return false;
            }
            else{
               if(setKingChecker() == true) {
                if(vert > 1 || vert < -1)
                    return true;
                else
                    return false;
            }

        }
    }
        return true;
    }

    /**
     * Method Name: dragGestureRecognized <br>
     * Method Purpose: allow the checker to be moved <br>
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
     * @param dge a drag gesture
     */
    @Override
    public void dragGestureRecognized(DragGestureEvent dge) {
        CheckerTransferable transferable = new CheckerTransferable(this);
        DragSource ds = dge.getDragSource();
        ds.startDrag(dge,DragSource.DefaultMoveDrop,transferable,this);
    }
}
