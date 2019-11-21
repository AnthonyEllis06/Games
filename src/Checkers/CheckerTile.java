package Checkers;

import javafx.scene.shape.Ellipse;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.dnd.DropTargetDragEvent;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.dnd.DropTargetEvent;
import java.awt.dnd.DropTargetListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

public class CheckerTile extends Canvas implements DropTargetListener
{
    private Boolean valid;
    public CheckerTile()
    {
        super();

        setVisible(true);

    }

    public void setTileColor(Color color)
    {
        setBackground(color);
        if(color==Color.RED)
            valid = true;
        else
            valid= false;
    }

    @Override
    public void dragEnter(DropTargetDragEvent dtde) {
        if(valid)
            setTileColor(Color.PINK);
    }

    @Override
    public void dragOver(DropTargetDragEvent dtde) {

    }

    @Override
    public void dropActionChanged(DropTargetDragEvent dtde) {

    }

    @Override
    public void dragExit(DropTargetEvent dte) {
        if(valid)
            setTileColor(Color.RED);
    }

    @Override
    public void drop(DropTargetDropEvent dtde) {

    }
}