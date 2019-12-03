//----------------------------------------------------------------------------
// File name: TicTacToeTile.java
// Project name: Games
// ---------------------------------------------------------------------------
// / Creator’s name and email: Alex Shepherd, shepherdap@etsu.edu
// Course-Section: CSCI 1260 - 201
// Creation Date: 11/29/2019
// Date of Last Modification: 11/29/2019
// ---------------------------------------------------------------------------
package TicTacToe;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.util.ArrayList;

/** Class Name: TicTacToeTile <br>
 * Class Purpose: This class is responsible for building each tile for the TicTacToe board.
 *              This class also represents how each tile will work.
 *              <br>
 *
 * <hr>
 * Date created: 11/29/2019 <br>
 * Date last modified: 11/29/2019
 * @author Alex Shepherd
 */
public class TicTacToeTile extends JPanel {
    private ArrayList<TicTacToeTile> directions; //ArrayList of directions
    private JLabel tileButton; //tile of the TicTacToe that is built as a button
    private String text; //text on the button
    private boolean reserved; //boolean that determines if the tile is reserved or it's been taken by the player already
    private int position; // position of the tile

    /**
     * Method Name: TicTacToeTile <br>
     * Method Purpose: Constructor of the TicTacToeTile class. This sets the default values of the fields of the class. <br>
     *
     * <hr>
     * Date created: 11/29/2019 <br>
     * Date last modified: 11/29/2019 <br>
     *
     * <hr>
     * Notes on specifications, special algorithms, and assumptions:
     *   notes go here
     *
     * <hr>
     *   @param  position of the tile
     */
    public TicTacToeTile(int position){
        super(new BorderLayout()); //calls the parent constructor

        tileButton = new JLabel(" ", SwingConstants.CENTER); //creates a new button
        tileButton.setFont(new Font(Font.SERIF, Font.BOLD,50 )); //sets the font of the label of the button, such as font style, size, and etc.
        setBorder(new BevelBorder(1)); //sets the border of the button
        add(tileButton, BorderLayout.CENTER); //adds the button that is set as the center component of the layout.
        reserved= false; //initialize the button to unreserved (reserved = false)
        this.position = position; //initialize the class variable position to the position variable that is passed as a parameter
    } //end TicTacToeTile(int position)

    /**
     * Method Name: setText <br>
     * Method Purpose: This method sets the text that will be printed on the button. <br>
     *
     * <hr>
     * Date created: 11/29/2019 <br>
     * Date last modified: 11/29/2019 <br>
     *
     * <hr>
     * Notes on specifications, special algorithms, and assumptions:
     *   notes go here
     *
     * <hr>
     *   @param  text that will be printed on the tile/button selected by the current player
     */
    public void setText(String text){
        if(reserved != true){
            this.text = text; //if the tile/button is not reserved, set the class variable text to the passed parameter text
            tileButton.setText(text); //sets the text/label of the button
            reserved = true; //change to true after changing the text/adding the text to the button
        }
    } //end setText(String text)

    /**
     * Method Name: getPosition <br>
     * Method Purpose: returns the position of the tile. <br>
     *
     * <hr>
     * Date created: 11/29/2019 <br>
     * Date last modified: 11/29/2019 <br>
     *
     * <hr>
     * Notes on specifications, special algorithms, and assumptions:
     *   notes go here
     *
     * <hr>
     *   @return position of the tile
     */
    public int getPosition(){
        return position;
    } //end getPosition


}

