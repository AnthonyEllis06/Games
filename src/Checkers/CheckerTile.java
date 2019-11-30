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


public class CheckerTile extends JPanel implements DropTargetListener
{
    private int tilex;
    private int tiley;

    private Coordinate coordinate;
    private Boolean valid;
    private Checker checker;
    public CheckerTile(Color color, int x, int y)
    {
        super();
        setTileColor(color);
        tilex = x;
        tiley = y;
        setBorder(new BevelBorder(1));
        setVisible(true);
        checker = null;

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
        this.checker = null;
        removeAll();
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


    public int getTileX() {
        return tilex;
    }
    public boolean valid(){
        if(this.valid)
            return true;
        else
            return false;
    }

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