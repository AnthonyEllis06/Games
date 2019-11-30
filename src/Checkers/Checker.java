package Checkers;


import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.dnd.*;
import java.io.IOException;

public class Checker extends JLabel implements DragGestureListener, DragSourceListener{
    CheckerTransferable transferable;
    CheckerTile curr;
    CheckerTile prev;
    CheckerListener checkerListener;
    private boolean black;

    public Checker(CheckerTile tile, Color color){
        super();
        //Image m = new BufferedImage();
        DragSource.getDefaultDragSource().createDefaultDragGestureRecognizer(this, DnDConstants.ACTION_MOVE,this);
        String filename;

        if(color == Color.RED){
            filename ="C:\\Users\\Anthony\\Desktop\\Games\\src\\GameUtil\\Images\\RedChecker.png";
            black = false;
        }
        else{
            filename = "C:\\Users\\Anthony\\Desktop\\Games\\src\\GameUtil\\Images\\BlackChecker.png";
            black = true;
        }
        ImageIcon checkerImage = new ImageIcon(filename);
        setIcon(checkerImage);
        curr = tile;
        prev = curr;
        tile.setChecker(this);
    }
    public void setCheckerListener(CheckerListener checkerListener){
        this.checkerListener = checkerListener;
    }
    public boolean move(CheckerTile tileFinish){
        int start = curr.getTileX();
        int finish = tileFinish.getTileX();
        int vert = finish-start ;
        if(!tileFinish.valid())
            return false;
        else if(tileFinish.getChecker()!=null)
            return false;
        else if(vert>1||vert<-1)
            return false;
        else{
            if(black){
                if(vert==-1)
                    return true;
                else
                    return false;
            }
            else{
                System.out.println(this.black);
                if(vert==1)
                    return true;
                else
                    return false;
            }

        }
    }
    public boolean jump(CheckerTile tileFinish){
        int start = curr.getTileX();
        int finish = tileFinish.getTileX();
        int vert = finish-start ;
        return false;
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

    @Override
    public void dragGestureRecognized(DragGestureEvent dge) {
        CheckerTransferable transferable = new CheckerTransferable(this);
        DragSource ds = dge.getDragSource();
        ds.startDrag(dge,DragSource.DefaultMoveDrop,transferable,this);
    }

    @Override
    public void dragEnter(DragSourceDragEvent dragSourceDragEvent) {

    }

    @Override
    public void dragOver(DragSourceDragEvent dragSourceDragEvent) {

    }

    @Override
    public void dropActionChanged(DragSourceDragEvent dragSourceDragEvent) {

    }

    @Override
    public void dragExit(DragSourceEvent dragSourceEvent) {

    }

    @Override
    public void dragDropEnd(DragSourceDropEvent dragSourceDropEvent) {
        if(dragSourceDropEvent.getDropSuccess() == true){
            curr.clearTile();
        }
    }
}
