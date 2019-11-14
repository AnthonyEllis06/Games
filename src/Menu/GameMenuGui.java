package Menu;

import GameUtil.AbstractGameGui;
import BlackJack.BlackJackGui;
import Checkers.CheckersGui;
import TicTacToe.TicTacToeGui;
import War.WarGui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameMenuGui extends AbstractGameGui implements ActionListener {
    private final int WIDTH = 150;
    private final int HEIGHT = 200;
    public GameMenuGui(JFrame parent){
        super(parent);
        GetParent().getJMenuBar().setVisible(false);
        GetParent().add(this, BorderLayout.CENTER);
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
        JButton checkerButton = new JButton("Checkers");
        checkerButton.addActionListener(this);
        checkerButton.setActionCommand("checker");
        add(checkerButton);

        JButton ticTacToeButton = new JButton("TicTacToe");
        ticTacToeButton.addActionListener(this);
        ticTacToeButton.setActionCommand("ticTac");
        add(ticTacToeButton);

        JButton WarButton = new JButton("War");
        WarButton.addActionListener(this);
        WarButton.setActionCommand("War");
        add(WarButton);

        JButton BlackJackButton = new JButton("BlackJack");
        BlackJackButton.addActionListener(this);
        BlackJackButton.setActionCommand("BlackJack");
        add(BlackJackButton);

    }
    private void checker(){
        this.removeAll();
        new CheckersGui(this.GetParent());
    }
    private void ticTacToe(){
        this.removeAll();
        new TicTacToeGui(this.GetParent());
    }
    private void war(){
        this.removeAll();
        new WarGui(this.GetParent());
    }
    private void blackJack(){
        this.removeAll();
        new BlackJackGui(this.GetParent());
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        GetParent().getJMenuBar().setVisible(true);
        String action = e.getActionCommand();
        if(action.equals("checker"))
            checker();
        else if(action.equals("ticTac"))
            ticTacToe();
        else if(action.equals("War"))
            war();
        else if(action.equals("BlackJack"))
            blackJack();
    }
}
