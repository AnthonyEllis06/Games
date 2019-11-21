package TicTacToe;

import GameUtil.AbstractGameGui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TicTacToeGui extends AbstractGameGui {
    private final int WIDTH = 500;
    private final int HEIGHT = 500;
    private JLabel currPlayerLabel;

    public TicTacToeGui(JFrame parent) {
        super(parent,new TicTacToe());
        addPlayers();
        currPlayerLabel = new JLabel(getGame().getCurrPlayer().getName()+"'s turn");
        parent.getJMenuBar().add(currPlayerLabel);
        revalidate();
        repaint();

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
        setLayout(new GridLayout(3,3));
        TicTacToeTile tile;
        for(int i = 0; i<9; i++){
            tile = new TicTacToeTile(i);
            add(tile);
            tile.addMouseListener(new PanelMouseAdapter());
        }

    }

    private class PanelMouseAdapter extends MouseAdapter {

        public void mousePressed(MouseEvent e){
            TicTacToe temp = (TicTacToe) getGame();
            if(!temp.gameWon()) {
                TicTacToeTile tile = (TicTacToeTile)e.getSource();
                tile.setText(temp.getCurrPlayerText());
                temp.setBoardSpot(tile.getPosition(),temp.getCurrPlayerText());
                if(!temp.gameWon()) {
                    //temp.seeBoard();
                    temp.nextPlayerTurn();
                    currPlayerLabel.setText(temp.getCurrPlayer().getName() + "'s Turn");
                }
                else{
                    currPlayerLabel.setText(temp.getCurrPlayer().getName()+" Has Won");
                }
            }
            else{
                currPlayerLabel.setText(temp.getCurrPlayer().getName()+" Has Won");
            }

        }
    }


}
