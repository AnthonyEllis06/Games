//----------------------------------------------------------------------------
// File name: AbstractGameGui.java
// Project name: Games
// ---------------------------------------------------------------------------
// / Creator’s name and email: Anthony Ellis, ellisah@etsu.edu
// Course-Section: CSCI 1260 - 201
// Creation Date: 12/01/2019
// Date of Last Modification: 12/01/2019
// ---------------------------------------------------------------------------
package GameUtil;

import Menu.GameMenuGui;
import javax.swing.*;
import java.util.ArrayList;

/** Class Name: AbstractGameGui <br>
 * Class Purpose: Abstract class that is child class of JPanel.
 *              This abstract class is responsible for the components of the game <br>
 *
 * <hr>
 * Date created: 12/01/2019 <br>
 * Date last modified: 12/01/2019
 * @author Anthony Ellis
 */
public abstract class AbstractGameGui extends JPanel {
    private JFrame parent; //JFrame object named parent
    protected GameInterface game; //GameInterface object named game/ specific game like black jack and etc

    /**
     * Method Name: AbstractGameGui <br>
     * Method Purpose: Constructor of the class that sets the default values of the fields of the class. <br>
     *
     * <hr>
     * Date created: 12/01/2019 <br>
     * Date last modified: 12/01/2019 <br>
     *
     * <hr>
     * Notes on specifications, special algorithms, and assumptions:
     *   notes go here
     *
     * <hr>
     * @param parent JFrame object
     * @param game the specific game to be used like BlackJack, TicTacToe, and etc
     */
    public AbstractGameGui(JFrame parent, GameInterface game) {
        super(); //calls the super class's constructor
        this.parent = parent; //the class variable parent is set as the parent variable that was passed as a parameter
        parent.setSize(getGameWidth(),getGameHeight()); //setting the size of the JFrame
        if(game != null)
            this.game = game; //if game is not null, then the class variable game is set as the game variable that was passed as a parameter
        if(parent.getJMenuBar().getMenuCount()>1)
            parent.getJMenuBar().remove(1);
        setUp(); //set up the game
        parent.setContentPane(this);
        setVisible(true);
    } //end AbstractGameGui(JFrame parent, GameInterface game)

    /**
     * Method Name: addPLayers <br>
     * Method Purpose: Gets the number of players allowed to play the game and prompts the users for their names and adds
     *                 the player to the game. <br>
     *
     * <hr>
     * Date created: 12/01/2019 <br>
     * Date last modified: 12/01/2019 <br>
     *
     * <hr>
     * Notes on specifications, special algorithms, and assumptions:
     *   notes go here
     *
     * <hr>
     */
    protected void addPlayers(){
        if(game!=null){ //if the game is not null
            String playerName; //declare playerName to hold the name of the player
            int numPlayers = game.getNumPlayers(); //get the number of players allowed to play the game
            for(int p = 1;p<=numPlayers;p++ ) { //keep looping till p is greater than the nunber of players
                playerName =
                        (String) JOptionPane.showInputDialog( //show message to the user to enter name. This will show depending on the number of players allowed to play
                                parent,
                                "Enter New Player Name:",
                                "New Player",
                                JOptionPane.PLAIN_MESSAGE
                        );
                game.addPlayer(new Player(playerName)); //once the user enter his name, it will be added to the game as a player
            }
        }
    } //end addPlayers

    /**
     * Method Name: GetParent <br>
     * Method Purpose: Gets the parent (a JFrame object) <br>
     *
     * <hr>
     * Date created: 12/01/2019 <br>
     * Date last modified: 12/01/2019 <br>
     *
     * <hr>
     * Notes on specifications, special algorithms, and assumptions:
     *   notes go here
     *
     * <hr>
     * @return parent
     */
    protected JFrame GetParent(){
        return parent;
    } //end GetParent

    /**
     * Method Name: BackToMenu <br>
     * Method Purpose: Brings the user back to the menu <br>
     *
     * <hr>
     * Date created: 12/01/2019 <br>
     * Date last modified: 12/01/2019 <br>
     *
     * <hr>
     * Notes on specifications, special algorithms, and assumptions:
     *   notes go here
     *
     * <hr>
     */
    public void BackToMenu(){
        new GameMenuGui(parent); //creates an instance of GameMenuGui with a JFrame object as its parameter(parent)

    } //end BackToMenu

    /**
     * Method Name: getGame <br>
     * Method Purpose: Gets the game that will be played/used <br>
     *
     * <hr>
     * Date created: 12/01/2019 <br>
     * Date last modified: 12/01/2019 <br>
     *
     * <hr>
     * Notes on specifications, special algorithms, and assumptions:
     *   notes go here
     *
     * <hr>
     * @return game the game that will  be played
     */
    public GameInterface getGame(){
        return game;
    } //end getGame

    /**
     * Method Name: getGameWidth <br>
     * Method Purpose: Gets the width of the game's JFrame <br>
     *
     * <hr>
     * Date created: 12/01/2019 <br>
     * Date last modified: 12/01/2019 <br>
     *
     * <hr>
     * Notes on specifications, special algorithms, and assumptions:
     *   notes go here
     *
     * <hr>
     */
    protected abstract int getGameWidth(); //end getGameWidth

    /**
     * Method Name: getGameHeight <br>
     * Method Purpose: gets the height of the game's JFrame <br>
     *
     * <hr>
     * Date created: 12/01/2019 <br>
     * Date last modified: 12/01/2019 <br>
     *
     * <hr>
     * Notes on specifications, special algorithms, and assumptions:
     *   notes go here
     *
     * <hr>
     */
    protected abstract int getGameHeight(); //end getGameHeight

    /**
     * Method Name: setUp <br>
     * Method Purpose: Sets up the game <br>
     *
     * <hr>
     * Date created: 12/01/2019 <br>
     * Date last modified: 12/01/2019 <br>
     *
     * <hr>
     * Notes on specifications, special algorithms, and assumptions:
     *   notes go here
     *
     * <hr>
     */
    protected abstract void setUp(); //end setUp
}
