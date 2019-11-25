package War;

import GameUtil.AbstractGameGui;

import javax.swing.*;

public class WarGui extends AbstractGameGui {
    private final int WIDTH = 500;
    private final int HEIGHT = 500;

    public WarGui(JFrame parent) {
        super(parent,new War());
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
    protected void setUp() {
        //Build Gui Here
    }
}
