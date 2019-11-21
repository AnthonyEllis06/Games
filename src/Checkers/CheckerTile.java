package Checkers;

import javafx.scene.shape.Ellipse;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.dnd.*;
import java.io.IOException;


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
        }
        else {
            valid = false;
        }
    }
    public void setChecker(Checker checker){
        int x = getWidth();
        int y = getHeight();
        checker = new Checker(x,y);
        add(new Checker(x,y));
    }

    @Override
    public void dragEnter(DropTargetDragEvent dtde) {

    }

    @Override
    public void dragOver(DropTargetDragEvent dtde) {

    }

    @Override
    public void dropActionChanged(DropTargetDragEvent dtde) {

    }

    @Override
    public void dragExit(DropTargetEvent dte) {

    }

    @Override
    public void drop(DropTargetDropEvent dtde) {
        Checker check = (Checker) dtde.getSource();
        try {
            check.getTransferData(new DataFlavor());
        }
        catch (UnsupportedFlavorException ufe){
            System.out.println("null checker");
        }
        catch (IOException ioe){

        }
    }
}