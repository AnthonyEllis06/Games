package Checkers;
import GameUtil.AbstractGameGui;

import javax.swing.*;
import java.awt.*;

public class CheckersGui extends AbstractGameGui {
    private final int WIDTH = 800;
    private final int HEIGHT = 800;
    Checkers checkers;
    public CheckersGui(JFrame parent) {
        super(parent, null);

    }

    @Override
    protected int getGameWidth() {
        return WIDTH;
    }

    @Override
    protected int getGameHeight() {
        return HEIGHT;
    }

    @Override
    public void setUp()
    {

        setLayout(new GridLayout(8,8));
        //
        //boolean red = false;
        checkers= new Checkers();
        for(int x = 0; x<8;x++){
            for(int y = 0; y<8; y++){
                add(checkers.getCheckerTile(x,y));
            }
        }
        CheckerTile tile = checkers.getCheckerTile(0,0);
        new Checker(tile);

        repaint();
    }
}

