package Checkers;


import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.dnd.DragGestureEvent;
import java.awt.dnd.DragGestureListener;
import java.io.IOException;

public class Checker extends JLabel implements Transferable, DragGestureListener {
    public Checker(int x, int y){
        super();
        //Image m = new BufferedImage();
        ImageIcon checkerImage = new ImageIcon("C:\\Users\\antho\\Desktop\\Games\\src\\GameUtil\\Images\\black2.png");
        setIcon(checkerImage);
    }


    @Override
    public void dragGestureRecognized(DragGestureEvent dge) {
        dge.startDrag(Cursor.getDefaultCursor(),this);
    }

    @Override
    public DataFlavor[] getTransferDataFlavors() {
        return new DataFlavor[0];
    }

    @Override
    public boolean isDataFlavorSupported(DataFlavor flavor) {
        return true;
    }

    @Override
    public Object getTransferData(DataFlavor flavor) throws UnsupportedFlavorException, IOException {
        return this;
    }
}
