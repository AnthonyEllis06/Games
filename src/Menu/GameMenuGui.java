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
//----------------------------------------------------------------------------
// File name: FileManager.java
// Project name: Games
// ---------------------------------------------------------------------------
// / Creator’s name and email: Anthony Ellis, ellisah@etsu.edu
// Course-Section: CSCI-1260-201
// Creation Date: 12/1/19
// Date of Last Modification: 12/1/19
// ---------------------------------------------------------------------------
/** Class Name: GameMenuGUI <br>
 * Class Purpose: Creates the GUI that holds all the games   <br>
 *
 * <hr>
 * Date created: 11/29/19 <br>
 * Date last modified: 11/29/19
 * @author Anthony Ellis
 */
public class GameMenuGui extends AbstractGameGui implements ActionListener {
    private final int WIDTH = 150; //sets the width of the JFrame
    private final int HEIGHT = 200; //sets the height of the JFrame

    /**
     * Method Name: GameMenuGui <br>
     * Method Purpose: constructor that sets up the JFrame   <br>
     *
     * <hr>
     * Date created: 12/1/19 <br>
     * Date last modified: 12/1/19 <br>
     *
     * <hr>
     * Notes on specifications, special algorithms, and assumptions:
     *   notes go here
     *
     * <hr>
     *
     */
    public GameMenuGui(JFrame parent){
        super(parent, null);
        parent.getJMenuBar().setVisible(false);
    }

    /**
     * Method Name: getGameWidth <br>
     * Method Purpose: Simple getter of the game's width <br>
     *
     * <hr>
     * Date created: 11/29/19 <br>
     * Date last modified: 11/29/19 <br>
     *
     * <hr>
     * Notes on specifications, special algorithms, and assumptions:
     *
     *
     * <hr>
     * @return an int containing the game's width
     */
    @Override
    protected int getGameWidth() {
        return WIDTH;
    }

    /**
     * Method Name: getGameHeight <br>
     * Method Purpose: Simple getter of the game's height <br>
     *
     * <hr>
     * Date created: 11/29/19 <br>
     * Date last modified: 11/29/19 <br>
     *
     * <hr>
     * Notes on specifications, special algorithms, and assumptions:
     *
     *
     * <hr>
     * @return an int containing the game's height
     */
    @Override
    protected int getGameHeight() {
        return HEIGHT;
    }

    /**
     * Method Name: setUp <br>
     * Method Purpose: Sets up the GUI for the games <br>
     *
     * <hr>
     * Date created: 11/29/19 <br>
     * Date last modified: 11/29/19 <br>
     *
     * <hr>
     * Notes on specifications, special algorithms, and assumptions:
     *
     *
     */
    @Override
    protected void setUp() {

        //Sets up the Checkers Button on the GUI
        setBackground(Color.DARK_GRAY); //sets the background color
        JButton checkerButton = new JButton("Checkers"); //sets name of button to Checkers
        checkerButton.addActionListener(this); //sets an action listener for if it is clicked
        checkerButton.setActionCommand("checker"); //sends to checkers if clicked
        checkerButton.setBackground(Color.WHITE); //background color of the button is white
        checkerButton.setForeground(Color.BLACK); //background color of the text is black
        add(checkerButton); //adds button to the menu

        //Sets up the TicTacToe Button on the GUI
        JButton ticTacToeButton = new JButton("TicTacToe"); //sets name of button to TicTacToe
        ticTacToeButton.addActionListener(this); //sets an action listener for if it is clicked
        ticTacToeButton.setActionCommand("ticTac"); //sends to tictactoe if clicked
        ticTacToeButton.setBackground(Color.WHITE);//background color of the button is white
        ticTacToeButton.setForeground(Color.BLACK); //background color of the text is black
        add(ticTacToeButton); //adds button to the menu

        //Sets up the War button on the GUI
        JButton WarButton = new JButton("War"); //sets name of button to war
        WarButton.addActionListener(this); //sets an action listener for if it is clicked
        WarButton.setBackground(Color.WHITE); //background color of the button is white
        WarButton.setForeground(Color.BLACK); //background color of the text is black
        WarButton.setActionCommand("War"); //sends to war if clicked
        add(WarButton); //adds button to the menu

        //Sets up the BlackJack button on the GUI
        JButton BlackJackButton = new JButton("BlackJack"); //sets name of button to blackjack
        BlackJackButton.addActionListener(this); //sets an action listener for if it is clicked
        BlackJackButton.setBackground(Color.WHITE); //background color of the button is white
        BlackJackButton.setForeground(Color.BLACK); //background color of the text is black
        BlackJackButton.setActionCommand("BlackJack"); //sends to blackjack if clicked
        add(BlackJackButton); //adds button to the menu
    }

    /**
     * Method Name: checker <br>
     * Method Purpose: gets the checker game <br>
     *
     * <hr>
     * Date created: 11/29/19 <br>
     * Date last modified: 11/29/19 <br>
     *
     * <hr>
     * Notes on specifications, special algorithms, and assumptions:
     *
     *
     */
    private void checker(){
        new CheckersGui(this.GetParent());
    }

    /**
     * Method Name: ticTacToe <br>
     * Method Purpose: get the tictactoe game <br>
     *
     * <hr>
     * Date created: 11/29/19 <br>
     * Date last modified: 11/29/19 <br>
     *
     * <hr>
     * Notes on specifications, special algorithms, and assumptions:
     *
     *
     */
    private void ticTacToe(){
        new TicTacToeGui(this.GetParent());
    }

    /**
     * Method Name: war <br>
     * Method Purpose: get the war game <br>
     *
     * <hr>
     * Date created: 11/29/19 <br>
     * Date last modified: 11/29/19 <br>
     *
     * <hr>
     * Notes on specifications, special algorithms, and assumptions:
     *
     *
     */
    private void war(){
        new WarGui(this.GetParent());
    }

    /**
     * Method Name: blackJack <br>
     * Method Purpose: get the blackJack <br>
     *
     * <hr>
     * Date created: 11/29/19 <br>
     * Date last modified: 11/29/19 <br>
     *
     * <hr>
     * Notes on specifications, special algorithms, and assumptions:
     *
     *
     */
    private void blackJack(){
        new BlackJackGui(this.GetParent());
    }

    /**
     * Method Name: actionPerformed <br>
     * Method Purpose: sends to desired game <br>
     *
     * <hr>
     * Date created: 11/29/19 <br>
     * Date last modified: 11/29/19 <br>
     *
     * <hr>
     * Notes on specifications, special algorithms, and assumptions:
     *
     * @param e Action
     */
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
