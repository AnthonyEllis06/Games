package Checkers;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.dnd.*;


public class CheckerTile extends JPanel implements DropTargetListener
{
    private int x;
    private int y;
    private Boolean valid;
    private Checker checker;
    public CheckerTile(Color color, int x, int y)
    {
        super();
        setTileColor(color);
        setVisible(true);
        checker = null;

    }

    public void setTileColor(Color color)
    {
        setBackground(color);
        if(color==Color.RED) {
            valid = true;
            new DropTarget(this,this);
        }
        else {
            valid = false;
        }
    }
    public void setChecker(Checker checker){
        if(this.checker != null) {
            return;
        }
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
            dtde.rejectDrop();
            return;
        }
        if(getChecker() != null) {
            dtde.rejectDrop();
            dropChecker.prev.setChecker(dropChecker);
        }
        dtde.acceptDrop(DnDConstants.ACTION_MOVE);
        dtde.dropComplete(true);
        setChecker(dropChecker);
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