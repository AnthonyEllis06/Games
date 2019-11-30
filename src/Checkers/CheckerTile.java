package Checkers;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.dnd.*;


public class CheckerTile extends JPanel implements DropTargetListener
{
    private int x;
    private int y;



    private Coordinate coordinate;
    private Boolean valid;
    private Checker checker;
    public CheckerTile(Color color, int x, int y)
    {
        super();
        setTileColor(color);
        this.x = x;
        this.y = y;
        //setCoordinate();
        setBorder(new BevelBorder(1));
        setVisible(true);
        checker = null;

    }
    private void setCoordinate(){
        coordinate = new Coordinate(x,y);
    }
    public Coordinate getCoordinate() {
        return coordinate;
    }

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
    public void setChecker(Checker checker){
        this.checker = checker;
        checker.setPrev(checker.getCurr());
        checker.setCurr(this);
        add(checker);
        revalidate();
        repaint();
    }

    public Checker getChecker() {
        return checker;
    }

    public void clearTile(){
        this.valid = true;
        remove(0);
        revalidate();
        repaint();
    }
    @Override
    public void drop(DropTargetDropEvent dtde) {
        Transferable transferable = dtde.getTransferable();
        DataFlavor[] flavors = transferable.getTransferDataFlavors();
        Checker dropChecker;
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
        if(this.valid == true ) {
            dtde.acceptDrop(DnDConstants.ACTION_MOVE);
            dtde.dropComplete(true);
            setChecker(dropChecker);
            dropChecker.setCurr(this);
        }
        else{
            dropChecker.moveBack();
            dtde.rejectDrop();
            dtde.dropComplete(false);

        }
    }


    @Override
    public void dragEnter(DropTargetDragEvent dtde) {}
    @Override
    public void dragOver(DropTargetDragEvent dtde) {}
    @Override
    public void dropActionChanged(DropTargetDragEvent dtde) {}
    @Override
    public void dragExit(DropTargetEvent dte) {}
}