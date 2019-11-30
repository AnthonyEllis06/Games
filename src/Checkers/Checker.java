package Checkers;


import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DragGestureEvent;
import java.awt.dnd.DragGestureListener;
import java.awt.dnd.DragSource;
import java.io.IOException;

public class Checker extends JLabel implements DragGestureListener {
    CheckerTransferable transferable;
    CheckerTile curr;
    CheckerTile prev;

    public Checker(CheckerTile tile, Color color){
        super();
        //Image m = new BufferedImage();
        DragSource.getDefaultDragSource().createDefaultDragGestureRecognizer(this, DnDConstants.ACTION_MOVE,this);
        String filename;
        if(color == Color.RED)
            filename ="C:\\Users\\Anthony\\Desktop\\Games\\src\\GameUtil\\Images\\RedChecker.png";
        else
            filename = "C:\\Users\\Anthony\\Desktop\\Games\\src\\GameUtil\\Images\\BlackChecker.png";
        ImageIcon checkerImage = new ImageIcon(filename);
        setIcon(checkerImage);
        curr = tile;
        prev = null;
        tile.setChecker(this);
    }

    public void setCurr(CheckerTile curr) {
        this.curr = curr;
    }
    public void setPrev(CheckerTile prev){
        this.prev= curr;
    }

    public CheckerTile getCurr() {
        return curr;
    }

    public CheckerTile getPrev() {
        return prev;
    }
    public void moveBack(){
        prev.clearTile();
        prev.setChecker(this);
        curr.clearTile();
        curr = prev;
        prev = null;
    }

    @Override
    public void dragGestureRecognized(DragGestureEvent dge) {
        CheckerTransferable transferable = new CheckerTransferable(this);
        DragSource ds = dge.getDragSource();
        prev = curr;
        prev.clearTile();
        prev.repaint();
        ds.startDrag(dge,DragSource.DefaultMoveDrop,transferable,null);
    }

}
