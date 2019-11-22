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
    public Checker(int x, int y){
        super();
        //Image m = new BufferedImage();
        DragSource.getDefaultDragSource().createDefaultDragGestureRecognizer(this, DnDConstants.ACTION_MOVE,this);
        ImageIcon checkerImage = new ImageIcon("C:\\Users\\Anthony\\Desktop\\Games\\src\\GameUtil\\Images\\BlackChecker.png");
        setIcon(checkerImage);
    }


    @Override
    public void dragGestureRecognized(DragGestureEvent dge) {
        CheckerTransferable transferable = new CheckerTransferable(this);
        DragSource ds = dge.getDragSource();
        ds.startDrag(dge,DragSource.DefaultCopyDrop,transferable,null);
    }

}
